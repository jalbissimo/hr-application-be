CREATE TABLE IF NOT EXISTS departments (
                                              id   BIGSERIAL PRIMARY KEY,
                                              name VARCHAR(128) NOT NULL UNIQUE
    );
