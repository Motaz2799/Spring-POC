package com.motaz.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponse {
    private String id;
    private String name;
    private String email;
    private BigDecimal salary;
}

//Good practice to seperate model entities and dtos ---to avoid exposing the model to the client--- product req & response act as data transfer objects