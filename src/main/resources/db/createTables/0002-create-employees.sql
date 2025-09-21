CREATE TABLE IF NOT EXISTS employees (
                                            id               BIGSERIAL PRIMARY KEY,
                                            keycloak_user_id VARCHAR(64)  NOT NULL UNIQUE,
    first_name       VARCHAR(100) NOT NULL,
    last_name        VARCHAR(100) NOT NULL,
    email            VARCHAR(255) NOT NULL UNIQUE,
    job_title        VARCHAR(150),
    department_id    BIGINT REFERENCES departments(id) ON DELETE SET NULL,
    phone            VARCHAR(40),
    address          TEXT,
    salary           NUMERIC(14,2),
    cnp       VARCHAR(64),
    date_of_birth    DATE,
    manager_id       BIGINT REFERENCES employees(id) ON DELETE SET NULL,
    created_at       TIMESTAMPTZ NOT NULL DEFAULT now(),
    updated_at       TIMESTAMPTZ NOT NULL DEFAULT now(),
    version          BIGINT NOT NULL DEFAULT 0
    );

