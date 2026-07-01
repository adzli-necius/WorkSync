package com.worksync.backend.employee.controller;

import com.worksync.backend.employee.dto.request.CreateEmployeeRequest;
import com.worksync.backend.employee.dto.response.CreateEmployeeResponse;
import com.worksync.backend.employee.service.impl.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/create-employee")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateEmployeeResponse createEmployee(@Valid @RequestBody CreateEmployeeRequest request) {
        return employeeService.createEmployee(request);
    }
}

