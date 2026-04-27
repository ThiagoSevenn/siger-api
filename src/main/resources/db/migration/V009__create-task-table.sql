CREATE TABLE bd_siger.tb_task (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    status VARCHAR(100) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    due_date TIMESTAMP NOT NULL
);
