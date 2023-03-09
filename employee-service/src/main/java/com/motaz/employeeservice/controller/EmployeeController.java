package com.motaz.employeeservice.controller;

import com.motaz.employeeservice.dto.EmployeeRequest;
import com.motaz.employeeservice.dto.EmployeeResponse;
import com.motaz.employeeservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createEmployee(@RequestBody EmployeeRequest employeeRequest) {
        employeeService.createEmployee(employeeRequest);

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeResponse> getAllEmployees() {
       return employeeService.getAllEmployees();


    }
}

