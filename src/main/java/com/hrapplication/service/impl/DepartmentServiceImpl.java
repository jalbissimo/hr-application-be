package com.hrapplication.service.impl;

import com.hrapplication.model.entity.Department;
import com.hrapplication.repository.DepartmentRepository;
import com.hrapplication.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;


    @Override
    public Department createDepartment(String departmentName) {

        Department department = Department.builder().name(departmentName).build();

        return departmentRepository.save(department);
    }
}
