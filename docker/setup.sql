USE pahtoo;

-- pahtoo.classe definition

-- pahtoo.classe definition

CREATE TABLE `classe` (
  `classe_id` int NOT NULL AUTO_INCREMENT,
  `classe_nome` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`classe_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;


-- pahtoo.passageiro definition

CREATE TABLE `passageiro` (
  `passageiro_id` int NOT NULL AUTO_INCREMENT,
  `passageiro_nome` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `passageiro_dtnasc` date NOT NULL,
  `passageiro_documento` varchar(15) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `passageiro_telefone` varchar(11) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `passageiro_email` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`passageiro_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;


-- pahtoo.statusvoo definition

CREATE TABLE `statusvoo` (
  `statusvoo_id` int NOT NULL AUTO_INCREMENT,
  `statusvoo_descricao` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`statusvoo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;


-- pahtoo.uf definition

CREATE TABLE `uf` (
  `uf_id` int NOT NULL AUTO_INCREMENT,
  `uf_nome` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `uf_sigla` varchar(2) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`uf_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb3;


-- pahtoo.cidade definition

CREATE TABLE `cidade` (
  `cidade_id` int NOT NULL AUTO_INCREMENT,
  `cidade_nome` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `uf_id` int NOT NULL,
  PRIMARY KEY (`cidade_id`),
  KEY `cidade_uf_idx` (`uf_id`),
  CONSTRAINT `cidade_uf` FOREIGN KEY (`uf_id`) REFERENCES `uf` (`uf_id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb3;


-- pahtoo.aeroporto definition

CREATE TABLE `aeroporto` (
  `aeroporto_id` int NOT NULL AUTO_INCREMENT,
  `aeroporto_descricao` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `aeroporto_iata` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `aeroporto_cidade_id` int NOT NULL,
  PRIMARY KEY (`aeroporto_id`),
  UNIQUE KEY `aeroporto_iata_UNIQUE` (`aeroporto_iata`),
  KEY `aeroporto_cidade_fk_idx` (`aeroporto_cidade_id`),
  CONSTRAINT `aeroporto_cidade_fk` FOREIGN KEY (`aeroporto_cidade_id`) REFERENCES `cidade` (`cidade_id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb3;


-- pahtoo.voo definition

CREATE TABLE `voo` (
  `voo_id` int NOT NULL AUTO_INCREMENT,
  `voo_origem` int NOT NULL,
  `voo_destino` int NOT NULL,
  `voo_datahora` datetime NOT NULL,
  `voo_totalassentos` int NOT NULL,
  `voo_statusvoo_id` int DEFAULT NULL,
  PRIMARY KEY (`voo_id`),
  KEY `voo_destino_aeroporto_fk_idx` (`voo_destino`),
  KEY `voo_origem_aeroporto_fk_idx` (`voo_origem`),
  KEY `voo_statusvoo_fk_idx` (`voo_statusvoo_id`),
  CONSTRAINT `voo_destino_aeroporto_fk` FOREIGN KEY (`voo_destino`) REFERENCES `aeroporto` (`aeroporto_id`),
  CONSTRAINT `voo_origem_aeroporto_fk` FOREIGN KEY (`voo_origem`) REFERENCES `aeroporto` (`aeroporto_id`),
  CONSTRAINT `voo_statusvoo_fk` FOREIGN KEY (`voo_statusvoo_id`) REFERENCES `statusvoo` (`statusvoo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;


-- pahtoo.vooclasse definition

CREATE TABLE `vooclasse` (
  `vooclasse_id` int NOT NULL,
  `vooclasse_voo_id` int NOT NULL,
  `vooclasse_classe_id` int NOT NULL,
  `vooclasse_qtassentos` int NOT NULL,
  PRIMARY KEY (`vooclasse_voo_id`,`vooclasse_classe_id`),
  KEY `vooclasse_classe_fk_idx` (`vooclasse_classe_id`),
  CONSTRAINT `vooclasse_classe_fk` FOREIGN KEY (`vooclasse_classe_id`) REFERENCES `classe` (`classe_id`),
  CONSTRAINT `vooclasse_voo_fk` FOREIGN KEY (`vooclasse_voo_id`) REFERENCES `voo` (`voo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;


-- pahtoo.passagem definition

CREATE TABLE `passagem` (
  `passagem_id` int NOT NULL AUTO_INCREMENT,
  `passagem_vooclasse_id` int NOT NULL,
  `passagem_numeroassento` int NOT NULL,
  `passagem_passageiro_id` int NOT NULL,
  `passagem_valor` double NOT NULL,
  PRIMARY KEY (`passagem_id`),
  KEY `passagem_vooclasse_fk_idx` (`passagem_vooclasse_id`),
  KEY `passagem_passageiro_fk_idx` (`passagem_passageiro_id`),
  CONSTRAINT `passagem_passageiro_fk` FOREIGN KEY (`passagem_passageiro_id`) REFERENCES `passageiro` (`passageiro_id`),
  CONSTRAINT `passagem_vooclasse_fk` FOREIGN KEY (`passagem_vooclasse_id`) REFERENCES `vooclasse` (`vooclasse_voo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

INSERT INTO uf (uf_nome, uf_sigla)
VALUES
('Acre', 'AC'),
('Alagoas', 'AL'),
('Amapá', 'AP'),
('Amazonas', 'AM'),
('Bahia', 'BA'),
('Ceará', 'CE'),
('Distrito Federal', 'DF'),
('Espírito Santo', 'ES'),
('Goiás', 'GO'),
('Maranhão', 'MA'),
('Mato Grosso', 'MT'),
('Mato Grosso do Sul', 'MS'),
('Minas Gerais', 'MG'),
('Pará', 'PA'),
('Paraíba', 'PB'),
('Paraná', 'PR'),
('Pernambuco', 'PE'),
('Piauí', 'PI'),
('Rio de Janeiro', 'RJ'),
('Rio Grande do Norte', 'RN'),
('Rio Grande do Sul', 'RS'),
('Rondônia', 'RO'),
('Roraima', 'RR'),
('Santa Catarina', 'SC'),
('São Paulo', 'SP'),
('Sergipe', 'SE'),
('Tocantins', 'TO');

INSERT INTO classe (classe_nome)
VALUES
('Econômica'),
('Executiva'),
('Prime');

INSERT INTO cidade (cidade_nome, uf_id) VALUES
('Brasília', 7),
('Congonhas', 25),
('Galeão', 19),
('Salvador', 5),
('Florianópolis', 24),
('Porto Alegre', 21),
('Campinas', 25),
('Recife', 17),
('Curitiba', 16),
('Belém', 14),
('Vitória', 8),
('Santos Dumont', 19),
('Cuiabá', 11),
('Campo Grande', 12),
('Fortaleza', 6),
('Macapá', 3),
('Maringá', 16),
('Goiânia', 9),
('Navegantes', 24),
('Manaus', 4),
('Natal', 20),
('Porto Seguro', 5),
('Maceió', 2),
('Palmas', 27),
('São Luis', 10),
('Guarulhos', 25),
('Londrina', 16),
('Porto Velho', 22),
('Rio Branco', 1),
('Joinville', 24),
('Uberlândia', 13),
('Caxias do Sul', 21),
('Foz do Iguaçu', 16),
('Teresina', 18),
('Aracaju', 26),
('João Pessoa', 15),
('Petrolina', 17),
('Confins', 13),
('Boa Vista', 23),
('Campina Grande', 15),
('Santarém', 14),
('Ilhéus', 5),
('Juazeiro do Norte', 6),
('Imperatriz', 10),
('Chapecó', 24),
('Marabá', 14),
('Cruzeiro do Sul', 1),
('Presidente Prudente', 25),
('Cabo Frio', 19),
('Fernando de Noronha', 17),
('Bauru', 25),
('Montes Claros', 13);

INSERT INTO aeroporto (aeroporto_descricao, aeroporto_iata, aeroporto_cidade_id) VALUES 
('Aeroporto Internacional de Brasília / Presidente Jucelino Kubitschek', 'BSB', 1),
('Aeroporto Internacional de São Paulo / Congonhas', 'CGH', 2),
('Aeroporto Internacional do Rio de Janeiro / Galeão-Antônio Carlos Jobim', 'GIG', 3),
('Aeroporto Internacional de Salvador / Deputado Luis Eduardo Magalhães', 'SSA', 4),
('Aeroporto Internacional de Florianópolis / Hercílio Luz', 'FLN', 5),
('Aeroporto Internacional de Porto Alegre / Salgado Filho', 'POA', 6),
('Aeroporto Internacional de Viracopos / Campinas', 'VCP', 7),
('Aeroporto Internacional do Recife/ Guararapes – Gilberto Freyre', 'REC', 8),
('Aeroporto Internacional de Curitiba / Afonso Pena', 'CWB', 9),
('Aeroporto Internacional de Belém / Val de Cans', 'BEL', 10),
('Aeroporto de Vitória – Eurico de Aguiar Salles', 'VIX', 11),
('Aeroporto Santos Dumont', 'SDU', 12),
('Aeroporto Internacional de Cuiabá / Marechal Rondon', 'CGB', 13),
('Aeroporto Internacional de Campo Grande', 'CGR', 14),
('Aeroporto Internacional de Fortaleza / Pinto Martins', 'FOR', 15),
('Aeroporto Internacional de Macapá', 'MCP', 16),
('Aeroporto Regional de Maringá / Silvio Name Junior', 'MGF', 17),
('Aeroporto de Goiânia / Santa Genoveva', 'GYN', 18),
('Aeroporto Internacional de Navegantes / Ministro Victor Konder', 'NVT', 19),
('Aeroporto Internacional de Manaus / Eduardo Gomes', 'MAO', 20),
('Aeroporto Internacional de Natal / Augusto Severo', 'NAT', 21),
('Aeroporto Internacional de Porto Seguro', 'BPS', 22),
('Aeroporto de Maceió / Zumbi dos Palmares', 'MCZ', 23),
('Aeroporto de Palmas/Brigadeiro Lysias Rodrigues', 'PMW', 24),
('Aeroporto Internacional de São Luís / Marechal Cunha Machado', 'SLZ', 25),
('Aeroporto Internacional de São Paulo/Guarulhos-Governador André Franco Motoro', 'GRU', 26),
('Aeroporto de Londrina / Governador José Richa', 'LDB', 27),
('Aeroporto Internacional de Porto Velho / Governador Jorge Teixeira de Oliveira', 'PVH', 28),
('Aeroporto Internacional de Rio Branco / Plácido de Castro', 'RBR', 29),
('Aeroporto de Joinville / Lauro Carneiro de Loyola', 'JOI', 30),
('Aeroporto de Uberlândia / Ten. Cel. Av. César Bombonato', 'UDI', 31),
('Aeroporto Regional de Caxias do Sul / Hugo Cantergiani', 'CXJ', 32),
('Aeroporto Internacional de Foz do Iguaçu', 'IGU', 33),
('Aeroporto de Teresina – Senador Petrônio Portella', 'THE', 34),
('Aeroporto Internacional de Aracaju / Santa Maria', 'AJU', 35),
('Aeroporto Internacional de João Pessoa / Presidente Castro Pinto', 'JPA', 36),
('Aeroporto de Petrolina / Senador Nilo Coelho', 'PNZ', 37),
('Aeroporto Internacional de Minas Gerais / Confins – Tancredo Neves', 'CNF', 38),
('Aeroporto Internacional de Boa Vista / Atlas Brasil Cantanhede', 'BVB', 39),
('Aeroporto de Campina Grande / Presidente João Suassuna', 'CPV', 40),
('Aeroporto de Santarém / Maestro Wilson Fonseca', 'STM', 41),
('Aeroporto de Ilhéus/Bahia-Jorge Amado', 'IOS', 42),
('Aeroporto de Juazeiro do Norte – Orlando Bezerra', 'JDO', 43),
('Aeroporto de Imperatriz – Prefeito Renato Moreira', 'IMP', 44),
('Aeroporto de Chapecó – Serafin Enoss Bertaso', 'XAP', 45),
('Aeroporto de Marabá', 'MAB', 46),
('Aeroporto Internacional de Cruzeiro do Sul', 'CZS', 47),
('Aeroporto Estadual de Presidente Prudente', 'PPB', 48),
('Aeroporto Internacional de Cabo Frio', 'CFB', 49),
('Aeroporto de Fernando de Noronha', 'FEN', 50),
('Aeroporto Estadual de Bauru/Arealva', 'JTC', 51),
('Aeroporto de Montes Claros/Mário Ribeiro', 'MOC', 52);