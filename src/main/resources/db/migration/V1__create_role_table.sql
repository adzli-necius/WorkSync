CREATE TABLE role (
                      id BIGSERIAL PRIMARY KEY,
                      code VARCHAR(30) NOT NULL UNIQUE,
                      name VARCHAR(100) NOT NULL,
                      description VARCHAR(255),
                      is_active BOOLEAN NOT NULL DEFAULT TRUE,
                      created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                      created_by VARCHAR(100),
                      updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                      updated_by VARCHAR(100)
);