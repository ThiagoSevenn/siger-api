CREATE TABLE tb_topics(
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    meeting_minutes_id UUID,
    priority VArCHAR(100) NOT NULL,
    timer INTEGER,
    concluded BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (meeting_minutes_id) REFERENCES tb_meeting_minutes(id) ON DELETE CASCADE
);