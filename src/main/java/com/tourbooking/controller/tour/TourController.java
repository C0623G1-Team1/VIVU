package com.tourbooking.controller.tour;

import com.tourbooking.model.tour.Tour;
import com.tourbooking.service.tour.ITourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/tour")
public class TourController {
    @Autowired
    private ITourService tourService;

    @GetMapping()
    public ModelAndView showTour() {
        return new ModelAndView("home-page", "tourList", tourService.showList());
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        return new ModelAndView("admin-create-tour", "tour", new Tour());
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Tour tour) {
        tourService.create(tour);
        return "redirect:/";
    }

    @GetMapping("/view/{id}")
    public ModelAndView showDetail(@PathVariable Integer id) {
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

}
