CREATE TABLE tb_meeting_minutes(
    id BIGSERIAL PRIMARY KEY,
    meeting_id BIGINT NOT NULL,
    objectives VARCHAR(100) NOT NULL,
    notes VARCHAR(255) NOT NULL,
    decision VARCHAR(255) NOT NULL,
    FOREIGN KEY (meeting_id) REFERENCES tb_meeting(id) ON DELETE CASCADE
);