package com.tourbooking.controller.tour;

import com.tourbooking.model.tour.Image;
import com.tourbooking.model.tour.Tour;
import com.tourbooking.model.tour.TourDTO;
import com.tourbooking.service.tour.ITourService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/tour")
public class TourController {
    @Autowired
    private ITourService tourService;

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        TourDTO tourDTO = new TourDTO();
        List<String> initList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            initList.add("");
        }
        tourDTO.setImageUrls(initList);
        return new ModelAndView("admin-create-tour", "tour", tourDTO);
    }

    @PostMapping("/create")
    public String create(@ModelAttribute TourDTO tour) {
        Tour tour1 = new Tour();
        BeanUtils.copyProperties(tour,tour1);
        List<Image> list = new ArrayList<>();
        for (String s: tour.getImageUrls()) {
            if(!"undefined".equals(s)){
                list.add(new Image(s,tour1));
            }
        }
        tour1.setImageUrls(list);
        tourService.create(tour1);
        return "redirect:/";
    }

    @GetMapping("/view/{id}")
    public ModelAndView showDetail(@PathVariable Integer id, Model model) {
        Locale locale = new Locale("vi", "VN");
        NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);
        model.addAttribute(numberFormat);
        return new ModelAndView("tour-view", "tour", tourService.findById(id).get());
    }

    @GetMapping("/update/{id}")
    public ModelAndView showUpdateForm(@PathVariable Integer id) {
        return new ModelAndView("admin-update-tour", "tour", tourService.findById(id).get());
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute Tour tour) {
        tourService.create(tour);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        tourService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/booking/{id}")
    public ModelAndView showBooking(@PathVariable Integer id, Model model) {
        return new ModelAndView("booking", "tour", tourService.findById(id).get());
    }

}
