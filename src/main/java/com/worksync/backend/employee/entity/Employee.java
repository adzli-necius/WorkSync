package com.worksync.backend.employee.entity;

import com.worksync.backend.common.entity.BaseEntity;
import com.worksync.backend.common.enums.Gender;
import com.worksync.backend.department.entity.Department;
import com.worksync.backend.employment.entity.EmploymentStatus;
import com.worksync.backend.position.entity.Position;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "employee")
public class Employee extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "employee_no", nullable = false, unique = true, length = 20)
    private String employeeNo;

    @Column(name = "full_name", nullable = false, length = 150)
    private String fullName;

    @Column(name = "ic_number", nullable = false, unique = true, length = 20)
    private String icNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private Gender gender;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "phone_number", nullable = false, length = 20)
    private String phoneNumber;

    @Column(name = "work_email", length = 150)
    private String workEmail;

    @Column(name = "personal_email", length = 150)
    private String personalEmail;

    @Column(name = "hire_date", nullable = false)
    private LocalDate hireDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "position_id", nullable = false)
    private Position position;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employment_status_id", nullable = false)
    private EmploymentStatus employmentStatus;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;
}