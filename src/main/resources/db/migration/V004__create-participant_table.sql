CREATE TABLE tb_participant(
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    user_id UUID,
    meeting_id UUID,
    participation SMALLINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES tb_user(id) ON DELETE CASCADE,
    FOREIGN KEY (meeting_id) REFERENCES tb_meeting(id) ON DELETE CASCADE
);