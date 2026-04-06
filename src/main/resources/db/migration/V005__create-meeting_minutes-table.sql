CREATE TABLE tb_meeting_minutes(
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    meeting_id UUID,
    objectives VARCHAR(100) NOT NULL,
    agenda VARCHAR(100) NOT NULL,
    FOREIGN KEY (meeting_id) REFERENCES tb_meeting(id) ON DELETE CASCADE
);