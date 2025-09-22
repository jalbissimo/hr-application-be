package com.hrapplication.model.dto;


import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class EmployeeDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String jobTitle;
    private Long departmentId;
    private String phone;
    private String address;
    private BigDecimal salary;
    private String cnp;
    private LocalDate dateOfBirth;
    private Long managerId;
}
