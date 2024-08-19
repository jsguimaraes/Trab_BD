DROP DATABASE IF EXISTS anotacao;

CREATE DATABASE anotacao;

\c anotacao;


CREATE TABLE anotacao(
    id serial primary key,
    titulo text not null,
    data_hora date,
    descricao text,
    cor text
);

INSERT INTO anotacao (titulo, data_hora, descricao, cor) VALUES
('anotação 1', '2024-02-10 18:00', 'anotacoes do primeiro dia fazendo a tarefa', 'azul');