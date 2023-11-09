package com.tourbooking.controller.tour;

import com.tourbooking.model.tour.IAccountDTO;
import com.tourbooking.model.tour.Tour;
import com.tourbooking.service.employee.IEmployeeService;
import com.tourbooking.service.tour.ITourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
public class EmployeeRestController {
    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private ITourService iTourService;


    @GetMapping("/show-list-employee")
    public ResponseEntity<List<IAccountDTO>> test(@RequestParam String startDate, @RequestParam String endDate) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date sd = null;
        Date ed = null;
        try {
            sd = df.parse(startDate);
            ed = df.parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<IAccountDTO> list = employeeService.listEmployee(sd, ed);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/test")
    public ResponseEntity<Page<Tour>> show(@PageableDefault(value = 6) Pageable pageable,
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
        System.out.println(sd);
        System.out.println(ed);
        Page<Tour> tourList = iTourService.search(pageable, name, sd, ed);
        return new ResponseEntity<>(tourList, HttpStatus.OK);
    }

}
