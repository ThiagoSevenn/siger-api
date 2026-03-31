CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE tb_meeting(
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY
    registration_date TIMESTAMP NOT NULL,
    modification_date TIMESTAMP,
    title VARCHAR(100) NOT NULL,
    description VARCHAR (255) NOT NULL,
    meeting_date TIMESTAMP NOT NULL,
    duration INTEGER NOT NULL,
    status VARCHAR(100) NOT NULL,
    location VARCHAR(100) NOT NULL
);