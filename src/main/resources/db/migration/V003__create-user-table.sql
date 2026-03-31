CREATE TABLE tb_user(
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY
    registration_date TIMESTAMP NOT NULL,
    modification_date TIMESTAMP,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL,
    cpf VARCHAR(11) NOT NULL,
    status VARCHAR(100) NOT NULL,
    type VARCHAR(100) NOT NULL,
    registration_user VARCHAR(100) NOT NULL,
    modification_user VARCHAR(100)
);
