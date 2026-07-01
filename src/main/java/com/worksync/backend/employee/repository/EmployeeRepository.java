package com.worksync.backend.employee.repository;

import com.worksync.backend.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByEmployeeNo(String employeeNo);

    Optional<Employee> findByIcNumber(String icNumber);

    boolean existsByEmployeeNo(String employeeNo);

    boolean existsByIcNumber(String icNumber);

    List<Employee> findByDepartmentId(Long departmentId);

}