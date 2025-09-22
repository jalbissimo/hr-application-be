package com.hrapplication.controller;

import com.hrapplication.model.entity.Department;
import com.hrapplication.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {

    @Autowired
    private final DepartmentService service;


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Department createDepartment(@RequestParam String departmentName) {
        return service.createDepartment(departmentName);
    }

}
