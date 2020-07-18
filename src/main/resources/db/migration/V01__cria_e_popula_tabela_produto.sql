CREATE TABLE produto (
 	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL,
 	nome VARCHAR(50) NOT NULL,
 	valor DECIMAL(5,2) NOT NULL,
 	descricao VARCHAR(300) NOT NULL,
 	data_validade DATE NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO produto(nome,valor,descricao,data_validade) VALUES ("ARROZ", "3.60", "Arroz branco tipo 1","2020-12-31");
INSERT INTO produto(nome,valor,descricao,data_validade) VALUES ("FEIJÃO", "5.40", "Feijão carioca","2021-03-01");
INSERT INTO produto(nome,valor,descricao,data_validade) VALUES ("BOLACHA RECHEADA", "1.50", "Bolacha recheada oreo, sabor chocolate branco tipo especial óreo", "2020-09-25");
INSERT INTO produto(nome,valor,descricao,data_validade) VALUES ("CHILITO", "0.50", "Chilito de batatinha", "2020-08-10");
INSERT INTO produto(nome,valor,descricao,data_validade) VALUES ("MASSA PARA CUZCUZ", "2.00", "Massa amarela para cuzcuz tradicional","2021-05-30");