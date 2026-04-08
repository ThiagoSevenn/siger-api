CREATE TABLE tb_topic(
    id BIGSERIAL PRIMARY KEY,
    meeting_minutes_id BIGINT NOT NULL,
    responsible_id BIGINT NOT NULL,
    title VARCHAR(100) NOT NULL,
    priority VARCHAR(100) NOT NULL,
    timer INTEGER,
    order_index INTEGER,
    concluded BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (responsible_id) REFERENCES tb_participant(id) ON DELETE CASCADE,
    FOREIGN KEY (meeting_minutes_id) REFERENCES tb_meeting_minutes(id) ON DELETE CASCADE
);