INSERT INTO `hotel`.`Estado` (`nome`) VALUES ('Tocatins');
INSERT INTO `hotel`.`Cidade` (`nome`, `estado_id`) VALUES ('Palmas', '1');
INSERT INTO `hotel`.`Bairro` (`nome`, `cidade_id`) VALUES ('104 Sul', '1');

INSERT INTO `hotel`.`Hotel` (`nome`, `bairro_id`) VALUES ('Graciosa Hotel', '1');
INSERT INTO `hotel`.`Andar` (`hotel_id`) VALUES ('1');
INSERT INTO `hotel`.`Quarto` (`banheiros`, `camas`, `numero`, `preco`, `andar_quarto_id`) VALUES ('2', '2', '101', '200', '1');
