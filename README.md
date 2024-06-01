## Criar Banco de dados

```
CREATE DATABASE biblioteca;

USE biblioteca;

CREATE TABLE Livro (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    categoria ENUM('FICCAO', 'NAO_FICCAO', 'CIENCIA', 'HISTORIA', 'TECNOLOGIA', 'OUTROS') NOT NULL,
    status VARCHAR(20) NOT NULL
);

CREATE TABLE Usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    telefone VARCHAR(20) NOT NULL
);

CREATE TABLE Emprestimo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    livro_id INT,
    usuario_id INT,
    dataEmprestimo DATE NOT NULL,
    dataDevolucao DATE,
    status VARCHAR(20) NOT NULL,
    FOREIGN KEY (livro_id) REFERENCES Livro(id),
    FOREIGN KEY (usuario_id) REFERENCES Usuario(id)
);

```
