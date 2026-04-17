CREATE TABLE tb_meeting(
    id BIGSERIAL PRIMARY KEY,
    organizer_id BIGSERIAL NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP,
    title VARCHAR(100) NOT NULL,
    description VARCHAR (255) NOT NULL,
    meeting_date TIMESTAMP NOT NULL,
    duration INTEGER NOT NULL,
    status VARCHAR(100) NOT NULL,
    location VARCHAR(100) NOT NULL,
    FOREIGN KEY (organizer_id) REFERENCES tb_user(id) ON DELETE CASCADE
);