package com.tourbooking.service.employee;

import com.tourbooking.model.tour.IAccountDTO;

import java.util.Date;
import java.util.List;

public interface IEmployeeService {
    List<IAccountDTO> listEmployee(Date startDate, Date endDate);
}
