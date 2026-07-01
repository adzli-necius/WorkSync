package com.worksync.backend.employee.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmployeeResponse {

    private String employeeNo;

    private String fullName;

    private String workEmail;
    private String department;
    private String position;
    private String employmentStatus;

}
