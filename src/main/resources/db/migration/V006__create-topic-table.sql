CREATE TABLE tb_topic(
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    meeting_minutes_id UUID,
    priority SMALLINT NOT NULL,
    timer INTEGER,
    concluded BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (meeting_minutes_id) REFERENCES tb_meeting_minutes(id) ON DELETE CASCADE
);