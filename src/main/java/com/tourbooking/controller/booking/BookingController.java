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

import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.time.LocalDate;

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

    @GetMapping("")
    public String showFormBooking(@RequestParam("idTour") int idTour, Model model){
        TourTruongDto tourDto=convertTourToTourDto(idTour);
        BookingDto bookingDto=new BookingDto();
        bookingDto.setTourId(idTour);
        bookingDto.setAdultQuantity(1);
        bookingDto.setChildrenQuantity(0);
        model.addAttribute("tourDto",tourDto);
        model.addAttribute("bookingDto", bookingDto);
        return "/booking/booking";
    }
    public TourTruongDto convertTourToTourDto(int idTour){
        Tour tour=tourService.findById(idTour).get();
        TourTruongDto tourDto=new TourTruongDto();
        tourDto.setId(tour.getId());
        tourDto.setAdultPrice(tour.getAdultPrice());
        tourDto.setChildPrice(tour.getChildPrice());
        String startDate= String.valueOf(tour.getStartDate());
        tourDto.setStartDate(startDate);
        String endDate= String.valueOf(tour.getEndDate());
        tourDto.setEndDate(endDate);
        tourDto.setTourImage(tour.getTourImage());
        tourDto.setTourName(tour.getTourName());
        return tourDto;
    }
    @PostMapping("/add")
    public String addBooking(@Validated @ModelAttribute BookingDto bookingDto,
                             BindingResult bindingResult, Model model,@SessionAttribute("bookingDto")
                                 BookingDto newBookingDto){
        new BookingDto().validate(bookingDto, bindingResult);
        String linkPay=null;
        if(bindingResult.hasFieldErrors()){
            TourTruongDto tourDto=convertTourToTourDto(bookingDto.getTourId());
            model.addAttribute("tourDto",tourDto);
            model.addAttribute("booking", bookingDto);
            model.addAttribute("link",linkPay);
            return "/booking/booking";
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
            model.addAttribute("link",linkPay);
            TourTruongDto tourDto=convertTourToTourDto(bookingDto.getTourId());
            model.addAttribute("tourDto",tourDto);
            model.addAttribute("booking", bookingDto);
            return "/booking/booking";
        }

    }
    @GetMapping("/pay")
    public String resultBooking(@RequestParam("vnp_ResponseCode") String vnp_ResponseCode,@SessionAttribute("bookingDto") BookingDto newBookingDto, Model model){
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
            booking.setPromotion(promotionService.findByCode(newBookingDto.getPromotionCode()));
            Booking booking1=booking;
            bookingService.createBooking(booking);
            model.addAttribute("result","Thanh toán thành công");
            emailSenderService.sendEmail(newBookingDto.getEmail(),"VIVU","Cảm ơn bạn đã đặt tour");
        } else {
            model.addAttribute("result","Thanh toán thất bại");
        }
        return "result";
    }

    @GetMapping("/list")
    public ModelAndView showListBooking(@PageableDefault(value = 2, sort = "id", direction = Sort.Direction.DESC) Pageable pageable){
        return new ModelAndView("/booking/bookingManager","list",bookingService.showListBooking(pageable));
    }
    @GetMapping("{id}/detail")
    public String showBookingDetail(Model model, @PathVariable int id){
        Booking booking=bookingService.findById(id);
        Tour tour=tourService.findById(booking.getTour().getId()).get();
        model.addAttribute("img",tour.getTourImage());
        model.addAttribute("booking",booking);
        long total=tour.getAdultPrice()*booking.getAdultQuantity()+tour.getChildPrice()* booking.getChildrenQuantity();
        model.addAttribute("total",total+"");
        return "/booking/bookingDetail";
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
