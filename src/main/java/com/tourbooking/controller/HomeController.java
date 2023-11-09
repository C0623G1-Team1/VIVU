package com.tourbooking.controller;

import com.tourbooking.model.tour.Tour;
import com.tourbooking.service.tour.ITourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping
public class HomeController {
    @Autowired
    private ITourService tourService;

    @GetMapping()
    public ModelAndView showTour(@PageableDefault(value = 6) Pageable pageable,
                                 @RequestParam(required = false, defaultValue = "") String name,
                                 @RequestParam(required = false, defaultValue = "1970-01-01") String startDate,
                                 @RequestParam(required = false, defaultValue = "2040-01-01") String endDate) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date sd = null;
        Date ed = null;
        try {
            sd = df.parse(startDate);
            ed = df.parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Page<Tour> tourList = tourService.search(pageable,name,sd,ed);
        return new ModelAndView("home-page", "tourList", tourList);
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login-form";
    }
}
