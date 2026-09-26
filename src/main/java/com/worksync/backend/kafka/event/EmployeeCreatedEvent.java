package com.worksync.backend.kafka.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeCreatedEvent {
    private String employeeNo;
    private String fullName;
    private String workEmail;
    private String department;
    private String position;
}
