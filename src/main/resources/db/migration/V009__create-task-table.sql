CREATE TABLE bd_siger.tb_task (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    status VARCHAR(100) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    due_date TIMESTAMP NOT NULL,
    assignee_id BIGSERIAL NOT NULL,
    meeting_id BIGSERIAL NOT NULL,
    FOREIGN KEY (assignee_id) REFERENCES tb_user(id) ON DELETE CASCADE,
    FOREIGN KEY (meeting_id) REFERENCES tb_meeting(id) ON DELETE CASCADE
);
