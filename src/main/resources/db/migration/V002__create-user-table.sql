CREATE TABLE tb_user(
    id BIGSERIAL PRIMARY KEY,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP,
    last_login TIMESTAMP,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    cpf VARCHAR(11) NOT NULL UNIQUE,
    phone VARCHAR(11),
    status VARCHAR(100) NOT NULL,
    type VARCHAR(100) NOT NULL,
    created_by VARCHAR(100) NOT NULL,
    updated_by VARCHAR(100)
);
