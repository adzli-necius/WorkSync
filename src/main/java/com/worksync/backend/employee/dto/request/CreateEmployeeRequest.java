package com.worksync.backend.employee.dto.request;

import com.worksync.backend.common.enums.Gender;
import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmployeeRequest {

    private String fullName;
    private String icNumber;
    private Gender gender;
    private LocalDate dateOfBirth;

    private String phoneNumber;

    private String personalEmail;

    private String workEmail;

    private LocalDate hireDate;

    private Long departmentId;

    private Long positionId;

    private Long employmentStatusId;
}
