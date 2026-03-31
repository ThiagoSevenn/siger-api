CREATE TABLE tb_log(
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    operation VARCHAR(100) NOT NULL,
    user_name VARCHAR(100) NOT NULL,
    date TIMESTAMP NOT NULL
);