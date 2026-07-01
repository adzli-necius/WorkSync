CREATE TABLE employee (
                          id BIGSERIAL PRIMARY KEY,

                          employee_no VARCHAR(20) NOT NULL,
                          full_name VARCHAR(150) NOT NULL,
                          ic_number VARCHAR(20) NOT NULL,

                          gender VARCHAR(10) NOT NULL,
                          date_of_birth DATE,

                          phone_number VARCHAR(20) NOT NULL,

                          work_email VARCHAR(150),
                          personal_email VARCHAR(150),

                          hire_date DATE NOT NULL,

                          department_id BIGINT NOT NULL,
                          position_id BIGINT NOT NULL,
                          employment_status_id BIGINT NOT NULL,

                          is_active BOOLEAN NOT NULL DEFAULT TRUE,

                          created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                          created_by VARCHAR(100),
                          updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                          updated_by VARCHAR(100),

                          CONSTRAINT uq_employee_no UNIQUE(employee_no),
                          CONSTRAINT uq_employee_ic UNIQUE(ic_number),

                          CONSTRAINT fk_employee_department
                              FOREIGN KEY (department_id)
                                  REFERENCES department(id),

                          CONSTRAINT fk_employee_position
                              FOREIGN KEY (position_id)
                                  REFERENCES position(id),

                          CONSTRAINT fk_employee_status
                              FOREIGN KEY (employment_status_id)
                                  REFERENCES employment_status(id)
);