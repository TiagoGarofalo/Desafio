DROP DATABASE IF EXISTS LISTALIVROS;
CREATE DATABASE LISTALIVROS;
USE LISTALIVROS;

CREATE TABLE LIVRO (
ID_LIVRO INT NOT NULL AUTO_INCREMENT PRIMARY KEY
,TITULO VARCHAR (255)
,AUTOR VARCHAR (255)
,EDICAO VARCHAR(10)
);
        
INSERT INTO LIVRO (TITULO, AUTOR, EDICAO) VALUES ("Java How to Program", "Deitel & Deitel", 2007);
INSERT INTO LIVRO (TITULO, AUTOR, EDICAO) VALUES ("Patterns of Enterprise Application Architecture", "Martin Fowler", 2002);
INSERT INTO LIVRO (TITULO, AUTOR, EDICAO) VALUES ("Head First Design Patterns", "Elisabeth Freeman", 2004);
INSERT INTO LIVRO (TITULO, AUTOR, EDICAO) VALUES ("Internet & World Wide Web: How to Program", "Deitel & Deitel", 2007);
