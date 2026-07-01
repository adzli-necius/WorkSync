package com.worksync.backend.employee.service.impl;

import com.worksync.backend.department.entity.Department;
import com.worksync.backend.department.repository.DepartmentRepository;
import com.worksync.backend.employee.dto.request.CreateEmployeeRequest;
import com.worksync.backend.employee.dto.response.CreateEmployeeResponse;
import com.worksync.backend.employee.entity.Employee;
import com.worksync.backend.employee.repository.EmployeeRepository;
import com.worksync.backend.employment.entity.EmploymentStatus;
import com.worksync.backend.employment.repository.EmploymentStatusRepository;
import com.worksync.backend.position.entity.Position;
import com.worksync.backend.position.repository.PositionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final PositionRepository positionRepository;
    private final EmploymentStatusRepository employmentStatusRepository;

    @Override
    public CreateEmployeeResponse createEmployee(CreateEmployeeRequest request) {

        //Checking
        validateEmployee(request);
        Department department = getDepartment(request.getDepartmentId());
        Position position = getPosition(request.getPositionId());
        EmploymentStatus employmentStatus = getEmploymentStatus(request.getEmploymentStatusId());

        //Build
        Employee employee = Employee.builder()
                .employeeNo(generateEmployeeNo())
                .fullName(request.getFullName())
                .icNumber(request.getIcNumber())
                .gender(request.getGender())
                .dateOfBirth(request.getDateOfBirth())
                .phoneNumber(request.getPhoneNumber())
                .workEmail(request.getWorkEmail())
                .personalEmail(request.getPersonalEmail())
                .hireDate(request.getHireDate())
                .department(department)
                .position(position)
                .employmentStatus(employmentStatus)
                .isActive(true)
                .build();

        Employee savedEmployee = employeeRepository.save(employee);

        return CreateEmployeeResponse.builder()
                .employeeNo(savedEmployee.getEmployeeNo())
                .fullName(savedEmployee.getFullName())
                .workEmail(savedEmployee.getWorkEmail())
                .department(savedEmployee.getDepartment().getName())
                .position(savedEmployee.getPosition().getName())
                .employmentStatus(savedEmployee.getEmploymentStatus().getName())
                .build();
    }

    private String generateEmployeeNo() {
        long totalEmployee = employeeRepository.count() + 1;
        return String.format("EMP%06d", totalEmployee);
    }

    private void validateEmployee(CreateEmployeeRequest req) {
        validateIcNumber(req.getIcNumber());
    }

        private void validateIcNumber(String icNumber) {
            if (employeeRepository.existsByIcNumber(icNumber)) {
                throw new RuntimeException("IC NUMBER ALREADY EXIST");
            }
    }

    private Department getDepartment(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("DEPARTMENT NOT FOUND"));
    }

    private Position getPosition(Long id) {
        return positionRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("POSITION NOT FOUND"));
    }

    private EmploymentStatus getEmploymentStatus(Long id) {
        return employmentStatusRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("EMPLOYEMENT STATUS NOT FOUND"));
    }


}
