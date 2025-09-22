package com.hrapplication.service;

import com.hrapplication.model.dto.EmployeeDTO;
import com.hrapplication.model.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(EmployeeDTO employeeDTO);

    List<Employee> getAllEmployees();
}
