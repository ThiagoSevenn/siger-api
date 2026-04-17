CREATE TABLE tb_participant(
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    meeting_id BIGINT NOT NULL,
    role VARCHAR(100) NOT NULL,
    participation VARCHAR(100) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES tb_user(id) ON DELETE CASCADE,
    FOREIGN KEY (meeting_id) REFERENCES tb_meeting(id) ON DELETE CASCADE
);