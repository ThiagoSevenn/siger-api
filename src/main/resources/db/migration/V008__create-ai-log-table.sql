CREATE TABLE bd_siger.tb_ai_log (
    id BIGSERIAL PRIMARY KEY,
    input VARCHAR(255) NOT NULL,
    output VARCHAR(1000) NOT NULL,
    usefull BOOLEAN DEFAULT FALSE
);
