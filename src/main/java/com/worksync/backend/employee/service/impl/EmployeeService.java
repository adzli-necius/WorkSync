package com.worksync.backend.employee.service.impl;

import com.worksync.backend.employee.dto.request.CreateEmployeeRequest;
import com.worksync.backend.employee.dto.response.CreateEmployeeResponse;

public interface  EmployeeService {
    CreateEmployeeResponse createEmployee(CreateEmployeeRequest request);
}
