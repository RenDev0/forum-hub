CREATE TABLE topicos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(100) NOT NULL,
    mensagem VARCHAR(255) NOT NULL,
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    autor VARCHAR(100) NOT NULL,
    status VARCHAR(50),
    curso VARCHAR(100),
    PRIMARY KEY (id)
);
