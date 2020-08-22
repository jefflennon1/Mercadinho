CREATE TABLE categoria(
	id BIGINT(10) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL
	
)ENGINE=innoDB  DEFAULT CHARSET=utf8;

INSERT INTO categoria(nome) VALUES ("Laticínios");
INSERT INTO categoria(nome) VALUES ("Enlatados");
INSERT INTO categoria(nome) VALUES ("Limpeza");
INSERT INTO categoria(nome) VALUES ("Grãos");
INSERT INTO categoria(nome) VALUES ("Frios");
INSERT INTO categoria(nome) VALUES ("Fast Food");
INSERT INTO categoria(nome) VALUES ("Bebidas em Geral");
INSERT INTO categoria(nome) VALUES ("Bebidas Alcoólicas");
INSERT INTO categoria(nome) VALUES ("Higiene Pessoal");



