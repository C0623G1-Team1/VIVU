package com.tourbooking.service.employee;

import com.tourbooking.model.tour.IAccountDTO;
import com.tourbooking.repository.employee.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    @Override
    public List<IAccountDTO> listEmployee(Date startDate, Date endDate) {
        return iEmployeeRepository.getListEmployee(startDate,endDate);
    }
}
