-- Criar a tabela curso
CREATE TABLE curso (
                       iden BIGINT PRIMARY KEY,
                       ano INT,
                       nome VARCHAR(255)
);

-- Criar a tabela disciplina
CREATE TABLE disciplina (
                            nome VARCHAR(255) PRIMARY KEY,
                            ch INT,
                            iden_curso BIGINT,
                            FOREIGN KEY (iden_curso) REFERENCES curso(iden)
);