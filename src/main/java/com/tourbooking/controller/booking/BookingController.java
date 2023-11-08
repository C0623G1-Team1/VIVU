package com.tourbooking.controller.booking;
import com.tourbooking.dto.booking.BookingDto;
import com.tourbooking.dto.tour.TourTruongDto;
import com.tourbooking.model.booking.Booking;
import com.tourbooking.model.booking.Promotion;
import com.tourbooking.model.tour.Tour;
import com.tourbooking.service.booking.IBookingService;
import com.tourbooking.service.booking.IPromotionService;
import com.tourbooking.service.booking.impl.EmailSenderService;
import com.tourbooking.service.tour.ITourService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Currency;
import java.util.Locale;

@Controller
@RequestMapping("/booking")
@SessionAttributes("bookingDto")
public class BookingController {
    @ModelAttribute("bookingDto")
    public BookingDto initBooking(){
        return new BookingDto();
    }
    @Autowired
    private IBookingService bookingService;
    @Autowired
    private IPromotionService promotionService;
    @Autowired
    private ITourService tourService;
    @Autowired
    EmailSenderService emailSenderService;

    @GetMapping("/{id}")
    public String showFormBooking(@PathVariable ("id") int id, Model model){
        TourTruongDto tourDto=convertTourToTourDto(id);

        Integer remain = getInteger(id, tourDto);
        model.addAttribute("amoutRemain",remain);

        BookingDto bookingDto=new BookingDto();
        bookingDto.setTourId(id);
        bookingDto.setAdultQuantity(0);
        bookingDto.setChildrenQuantity(0);
        model.addAttribute("sumBooking",0);
        model.addAttribute("tourDto",tourDto);
        model.addAttribute("bookingDto", bookingDto);
        return "/booking/booking-two";
    }

    private Integer getInteger(int id, TourTruongDto tourDto) {
        Integer adult=bookingService.sumAdultQuantity(id);
        if(adult==null){
            adult=0;
        }
        Integer children=bookingService.sumChildrenQuantity(id);
        if(children==null){
            children=0;
        }
        Integer sum=adult+children;
        Integer remain= tourDto.getTourAvailableSeat()-sum;
        return remain;
    }


    public TourTruongDto convertTourToTourDto(int idTour){
        Tour tour=tourService.findById(idTour).get();
        TourTruongDto tourDto=new TourTruongDto();
        tourDto.setId(tour.getId());
        tourDto.setAdultPrice(tour.getAdultPrice());
        tourDto.setChildPrice(tour.getChildPrice());
        String startDate= String.valueOf(tour.getStartDate());
        tourDto.setStartDate(startDate);
        tourDto.setTourAvailableSeat(tour.getTourAvailableSeat());
        String endDate= String.valueOf(tour.getEndDate());
        tourDto.setEndDate(endDate);
        tourDto.setTourImage(tour.getImageUrls().get(0).getUrl());
        tourDto.setTourName(tour.getTourName());
        return tourDto;
    }
    @PostMapping("/add")
    public String addBooking(@Validated @ModelAttribute BookingDto bookingDto,
                             BindingResult bindingResult,Model model,@SessionAttribute("bookingDto")
                                 BookingDto newBookingDto, @RequestParam("amount") String sum){
        new BookingDto().validate(bookingDto, bindingResult);
        TourTruongDto tourDto=convertTourToTourDto(bookingDto.getTourId());
        Integer remain = getInteger(tourDto.getId(), tourDto);
        Integer number= Integer.parseInt(sum);
        String linkPay=null;
        if(bindingResult.hasFieldErrors()||remain<number){
            model.addAttribute("sumBooking",number);
            model.addAttribute("amoutRemain",remain);
            model.addAttribute("tourDto",tourDto);
            model.addAttribute("booking", bookingDto);
            model.addAttribute("link",null);
            return "/booking/booking-two";
        } else {
            String time= String.valueOf(LocalDate.now());
            bookingDto.setDate(time);
            BeanUtils.copyProperties(bookingDto,newBookingDto);
            Promotion promotion=promotionService.findByCode(bookingDto.getPromotionCode());
            int idTour=bookingDto.getTourId();
            Tour tour=tourService.findById(idTour).get();
            long total=0;
            if (promotion!=null){
                newBookingDto.setPromotionCode(bookingDto.getPromotionCode());
                total=total(bookingDto,tour);
                total= (long) (total-total*0.1);
            } else {
                newBookingDto.setPromotionCode("not");
                total=total(bookingDto,tour);
            }
            linkPay=payment(total);
            model.addAttribute("amoutRemain",remain);
            model.addAttribute("link",linkPay);
            model.addAttribute("tourDto",tourDto);
            model.addAttribute("booking", bookingDto);
            return "/booking/booking-two";
        }

    }
    @GetMapping("/pay")
    public String resultBooking(@RequestParam("vnp_ResponseCode") String vnp_ResponseCode,
                                @SessionAttribute("bookingDto") BookingDto newBookingDto,
                                Model model){
        if(vnp_ResponseCode.equals("00")){
            Booking booking=new Booking();
            booking.setAdultQuantity(newBookingDto.getAdultQuantity());
            booking.setChildrenQuantity(newBookingDto.getChildrenQuantity());
            booking.setTour(tourService.findById(newBookingDto.getTourId()).get());
            booking.setEmail(newBookingDto.getEmail());
            Date date= Date.valueOf(newBookingDto.getDate());
            booking.setDate(date);
            booking.setName(newBookingDto.getName());
            booking.setPhone(newBookingDto.getPhone());
            booking.setCustomerIdCard(newBookingDto.getCustomerIdCard());
            booking.setPromotion(promotionService.findByCode(newBookingDto.getPromotionCode()));
            bookingService.createBooking(booking);
            String total=getTotal(booking,tourService.findById(newBookingDto.getTourId()).get());
            emailSenderService.sendEmail(newBookingDto.getEmail(),"ĐẶT TOUR THÀNH CÔNG","Cảm ơn bạn đã đặt tour", booking, total);
        } else {
            model.addAttribute("result","THANH TOÁN THẤT BẠI! VUI LÒNG THỬ LẠI");
        }
        return "/booking/email";
    }

    @GetMapping("/list")
    public ModelAndView showListBooking(@PageableDefault(value = 11, sort = "date", direction = Sort.Direction.DESC) Pageable pageable){
        return new ModelAndView("/booking/bookingManager","list",bookingService.showListBooking(pageable));
    }
    @GetMapping("{id}/detail")
    public String showBookingDetail(Model model, @PathVariable int id){
        Booking booking=bookingService.findById(id);
        Tour tour=tourService.findById(booking.getTour().getId()).get();
        model.addAttribute("img",tour.getImageUrls().get(0).getUrl());
        model.addAttribute("booking",booking);
        model.addAttribute("total",getTotal(booking,tour));
        return "/booking/booking-detail";
    }

    private static String getTotal(Booking booking, Tour tour) {
        long total= tour.getAdultPrice()* booking.getAdultQuantity()+ tour.getChildPrice()* booking.getChildrenQuantity();
        Locale locale = new Locale("vi", "VN");
        Currency currency = Currency.getInstance("VND");

        DecimalFormatSymbols df = DecimalFormatSymbols.getInstance(locale);
        df.setCurrency(currency);
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        numberFormat.setCurrency(currency);
        String sum=numberFormat.format(total);
        return sum;
    }

    @GetMapping("/delete")
    public String deleteBooking(@RequestParam int id){
        bookingService.delete(id);
        return "redirect:/booking/list";
    }
    @GetMapping("/findCustomer")
    public ModelAndView findByCustomer(@RequestParam("phone") String phone, Model model, @PageableDefault(value = 5, sort = "date", direction = Sort.Direction.DESC) Pageable pageable){
        return new ModelAndView("/booking/bookingManager","list",bookingService.findByPhone(phone, pageable));
    }
    public String payment(long price){
        PaymentController paymentController=new PaymentController();
        try {
            return String.valueOf(paymentController.getPay(price));
        } catch (UnsupportedEncodingException e) {
            System.out.println("loi");
        }
        return "loi";
    }
    public long total(BookingDto bookingDto,Tour tour){
        long total=bookingDto.getAdultQuantity()* tour.getAdultPrice()
                + bookingDto.getChildrenQuantity()* tour.getChildPrice();
        return total;
    }
}
