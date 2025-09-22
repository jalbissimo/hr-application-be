package com.hrapplication.populator;

import com.hrapplication.model.dto.EmployeeDTO;
import com.hrapplication.model.entity.Department;
import com.hrapplication.model.entity.Employee;
import lombok.experimental.UtilityClass;

import java.time.OffsetDateTime;

@UtilityClass
public class EmployeeMapper {

    public static Employee toEntity(EmployeeDTO dto, Department dep, Employee manager) {
        var now = OffsetDateTime.now();
        return Employee.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .jobTitle(dto.getJobTitle())
                .department(dep)
                .phone(dto.getPhone())
                .address(dto.getAddress())
                .salary(dto.getSalary())
                .cnp(dto.getCnp())
                .dateOfBirth(dto.getDateOfBirth())
                .manager(manager)
                .createdAt(now)
                .updatedAt(now)
                .build();
    }
}
