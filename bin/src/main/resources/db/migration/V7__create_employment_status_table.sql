CREATE TABLE employment_status (
                                   id BIGSERIAL PRIMARY KEY,

                                   code VARCHAR(20) NOT NULL,
                                   name VARCHAR(100) NOT NULL,
                                   description VARCHAR(255),

                                   is_active BOOLEAN NOT NULL DEFAULT TRUE,

                                   created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                   created_by VARCHAR(100),
                                   updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                   updated_by VARCHAR(100),

                                   CONSTRAINT uq_employment_status_code UNIQUE(code)
);