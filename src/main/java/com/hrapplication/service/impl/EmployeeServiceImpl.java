package com.hrapplication.service.impl;

import com.hrapplication.model.dto.EmployeeDTO;
import com.hrapplication.model.entity.Department;
import com.hrapplication.model.entity.Employee;
import com.hrapplication.populator.EmployeeMapper;
import com.hrapplication.repository.DepartmentRepository;
import com.hrapplication.repository.EmployeeRepository;
import com.hrapplication.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    @Override
    public Employee createEmployee(EmployeeDTO employeeDTO) {

        if (employeeRepository.existsByEmail(employeeDTO.getEmail())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already in use");
        }

        Department dep = null;
        if (employeeDTO.getDepartmentId() != null) {
            dep = departmentRepository.findById(employeeDTO.getDepartmentId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Department not found"));
        }

        Employee manager = null;
        if (employeeDTO.getManagerId() != null) {
            manager = employeeRepository.findById(employeeDTO.getManagerId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Manager not found"));
        }

        Employee e = EmployeeMapper.toEntity(employeeDTO, dep, manager);
        return employeeRepository.save(e);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAllWithRelations();
    }
}
