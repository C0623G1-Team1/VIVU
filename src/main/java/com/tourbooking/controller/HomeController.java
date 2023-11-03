package com.tourbooking.controller;

import com.tourbooking.model.tour.Tour;
import com.tourbooking.service.tour.ITourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping
public class HomeController {
    @Autowired
    private ITourService tourService;

    @GetMapping()
    public ModelAndView showTour() {
        List<Tour> tourList = tourService.showList();
        return new ModelAndView("home-page", "tourList", tourList);
    }
}
