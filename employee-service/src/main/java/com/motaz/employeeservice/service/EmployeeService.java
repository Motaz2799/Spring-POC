package com.motaz.employeeservice.service;

import com.motaz.employeeservice.dto.EmployeeRequest;
import com.motaz.employeeservice.dto.EmployeeResponse;
import com.motaz.employeeservice.model.Employee;
import com.motaz.employeeservice.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    public void createEmployee(EmployeeRequest employeeRequest) {
        Employee employee = Employee.builder()
                .name(employeeRequest.getName())
                .email(employeeRequest.getEmail())
                .salary(employeeRequest.getSalary())
                .build();

        employeeRepository.save(employee);
        log.info("Employee {} created successfully", employee.getId());
    }

    public List<EmployeeResponse> getAllEmployees(){
        List<Employee> employees= employeeRepository.findAll();
        return employees.stream().map(this::mapToEmployeeResponse).toList();

    }

    private EmployeeResponse mapToEmployeeResponse(Employee employee) {
        return EmployeeResponse.builder().id(employee.getId())
                .name(employee.getName())
                .email(employee.getEmail())
                .salary(employee.getSalary())
                .build();
    }
}
