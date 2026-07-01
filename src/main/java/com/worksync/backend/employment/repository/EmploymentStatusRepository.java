package com.worksync.backend.employment.repository;

import com.worksync.backend.employment.entity.EmploymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmploymentStatusRepository extends JpaRepository<EmploymentStatus, Long> {

    Optional<EmploymentStatus> findByCode(String code);
}
