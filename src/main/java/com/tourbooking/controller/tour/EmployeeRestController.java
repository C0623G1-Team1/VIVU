package com.tourbooking.controller.tour;

import com.tourbooking.model.tour.IAccountDTO;
import com.tourbooking.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @GetMapping("/show-list-employee")
    public ResponseEntity<List<IAccountDTO>> test(@RequestParam String startDate,@RequestParam String endDate){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date sd = null;
        Date ed = null;
        try {
            sd = df.parse(startDate);
            ed =df.parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<IAccountDTO> list = employeeService.listEmployee(sd,ed);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
