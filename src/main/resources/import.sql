INSERT INTO `USER` (`ID`, `EMAIL`, `SENHA`, `NOME`, `SOBRENOME`, `CPF`, `CNH`, `APROVADO`, `USER`) VALUES (1, 'matheusb95@gmail.com', '$2a$10$xge0W5Ifz4nU33U0geXn4OG0BUrtvA363OK9i5ts6rpxoyv8OJ4/G','Matheus', 'Soares', '436771768/24', '0000000000', 1, 'Matheus' );

/*ENDERECOS*/
INSERT INTO `ENDERECO` (`ID`, `CEP`, `LOGRADOURO`, `CIDADE`, `ESTADO`, `BAIRRO`, `USER_ID`) VALUES (1, '04841250', 'Rua Joaquim Antonio Alves', 'Sao Paulo', 'SP', 'Parque Planalto', 1);
INSERT INTO `ENDERECO` (`ID`, `CEP`, `LOGRADOURO`, `CIDADE`, `ESTADO`, `BAIRRO`, `USER_ID`) VALUES (2, '04556758', 'Rua Quintana', 'Sao Paulo', 'SP', 'Brooklin', 1);

/*ENDERECOS USUARIO*/
INSERT INTO `ENDERECO_USUARIO` (`USER_ID`, ENDERECO_ID) VALUES (1, 1);
INSERT INTO `ENDERECO_USUARIO` (`USER_ID`, ENDERECO_ID) VALUES (1, 2);

INSERT INTO `MARCA`(`ID`, `NOME`, `LOGO`, `MARCAS_PRINCIPAIS`) VALUES (1, 'Ferrari', 'http://localhost/cebolutions/ferrari-logo.jpg', 1);
INSERT INTO `MARCA`(`ID`, `NOME`, `LOGO`, `MARCAS_PRINCIPAIS`) VALUES (2, 'Audi', 'http://localhost/cebolutions/audi.jpg', 1);
INSERT INTO `MARCA`(`ID`, `NOME`, `LOGO`, `MARCAS_PRINCIPAIS`) VALUES (3, 'Mustang', 'http://localhost/cebolutions/mustang.jpg', 0);
INSERT INTO `MARCA`(`ID`, `NOME`, `LOGO`, `MARCAS_PRINCIPAIS`) VALUES (4, 'Mercedes', 'http://localhost/cebolutions/mercedes.jpg', 0);
INSERT INTO `MARCA`(`ID`, `NOME`, `LOGO`, `MARCAS_PRINCIPAIS`) VALUES (5, 'BMW', 'http://localhost/cebolutions/bmw.jpg', 1);
INSERT INTO `MARCA`(`ID`, `NOME`, `LOGO`, `MARCAS_PRINCIPAIS`) VALUES (6, 'Porsche', 'http://localhost/cebolutions/porsche.jpg', 1);
INSERT INTO `MARCA`(`ID`, `NOME`, `LOGO`, `MARCAS_PRINCIPAIS`) VALUES (7, 'Lamborghini', 'http://localhost/cebolutions/lamborghini.jpg', 1);
INSERT INTO `MARCA`(`ID`, `NOME`, `LOGO`, `MARCAS_PRINCIPAIS`) VALUES (8, 'Ford', 'http://localhost/cebolutions/ford.jpeg', 0);
INSERT INTO `MARCA`(`ID`, `NOME`, `LOGO`, `MARCAS_PRINCIPAIS`) VALUES (9, 'Aston Martin', 'http://localhost/cebolutions/aston.jpg', 0);
INSERT INTO `MARCA`(`ID`, `NOME`, `LOGO`, `MARCAS_PRINCIPAIS`) VALUES (10, 'Dodge', '', 0);
INSERT INTO `MARCA`(`ID`, `NOME`, `LOGO`, `MARCAS_PRINCIPAIS`) VALUES (11, 'McLaren', '', 0);


/*CORES*/
INSERT INTO `COR` (`ID`, `NOME`, `VALOR`, `COR_PADRAO`, `HEXADECIMAL`) VALUES(1, 'Vermelho', 100, false, '#FF0000');
INSERT INTO `COR` (`ID`, `NOME`, `VALOR`, `COR_PADRAO`, `HEXADECIMAL`) VALUES(2, 'Branco', 50, true, '#ffffff');
INSERT INTO `COR` (`ID`, `NOME`, `VALOR`, `COR_PADRAO`, `HEXADECIMAL`) VALUES(3, 'Amarelo', 200, false, '#FFFF00');
INSERT INTO `COR` (`ID`, `NOME`, `VALOR`, `COR_PADRAO`, `HEXADECIMAL`) VALUES(4, 'Azul', 300, false, '#000099');
INSERT INTO `COR` (`ID`, `NOME`, `VALOR`, `COR_PADRAO`, `HEXADECIMAL`) VALUES(5, 'Preto', 100, false, '#000000');
INSERT INTO `COR` (`ID`, `NOME`, `VALOR`, `COR_PADRAO`, `HEXADECIMAL`) VALUES(6, 'Verde', 100, false, '#00FF00');


/*FERRARI*/
INSERT INTO `CARRO`(`ID`, `MARCA_ID`, `MODELO`, `PRECO`, `COR_ID`, `QUANTIDADE`) VALUES (1, 1, 'f12 Berlinetta', 700000, 1, 5);
INSERT INTO `CARRO`(`ID`, `MARCA_ID`, `MODELO`, `PRECO`, `COR_ID`, `QUANTIDADE`) VALUES (2, 1, '458', 600000, 1, 5);
INSERT INTO `CARRO`(`ID`, `MARCA_ID`, `MODELO`, `PRECO`, `COR_ID`, `QUANTIDADE`) VALUES (3, 1, 'LaFerrari', 800000, 1, 5);
INSERT INTO `CARRO`(`ID`, `MARCA_ID`, `MODELO`, `PRECO`, `COR_ID`, `QUANTIDADE`) VALUES (4, 1, 'Italia', 500000, 2, 5);
INSERT INTO `CARRO`(`ID`, `MARCA_ID`, `MODELO`, `PRECO`, `COR_ID`, `QUANTIDADE`) VALUES (16, 1, 'Enzo', 500000, 1, 5);

/*AUDI*/
INSERT INTO `CARRO`(`ID`, `MARCA_ID`, `MODELO`, `PRECO`, `COR_ID`, `QUANTIDADE`, `DESCRICAO`, `ANO`, `CV`, `MOTOR`, `TOP_SPEED`) VALUES (5, 2, 'R8', 100000, 2, 5, 'Arte performatica. o R8 tenues os limites entre a arte e performance com um estilo exotico e desempenho de manipulacao para corresponder. Com a escolha de 3 motores potentes, é excelente em "borrar" os arredores também.', 2014, 430, 4.0, 168 );

INSERT INTO `CARRO`(`ID`, `MARCA_ID`, `MODELO`, `PRECO`, `COR_ID`, `QUANTIDADE`) VALUES (6, 2, 'A4', 90000, 2, 5);
INSERT INTO `CARRO`(`ID`, `MARCA_ID`, `MODELO`, `PRECO`, `COR_ID`, `QUANTIDADE`) VALUES (7, 2, 'Q7', 50000, 4, 5);
INSERT INTO `CARRO`(`ID`, `MARCA_ID`, `MODELO`, `PRECO`, `COR_ID`, `QUANTIDADE`) VALUES (13, 2, 'SPYDER', 50000, 1, 5);
INSERT INTO `CARRO`(`ID`, `MARCA_ID`, `MODELO`, `PRECO`, `COR_ID`, `QUANTIDADE`) VALUES (14, 2, 'TT', 50000, 2, 5);
INSERT INTO `CARRO`(`ID`, `MARCA_ID`, `MODELO`, `PRECO`, `COR_ID`, `QUANTIDADE`) VALUES (15, 2, 'TT CONVERSIVEL', 50000, 4, 5);

/*PORSCHE*/
INSERT INTO `CARRO`(`ID`, `MARCA_ID`, `MODELO`, `PRECO`, `COR_ID`, `QUANTIDADE`) VALUES (8, 6, 'CARRERA', 90000, 2, 5);

/*LAMBO*/
INSERT INTO `CARRO`(`ID`, `MARCA_ID`, `MODELO`, `PRECO`, `COR_ID`, `QUANTIDADE`) VALUES (9, 7, 'DIABLO', 300000, 5, 5);

/*BMW*/
INSERT INTO `CARRO`(`ID`, `MARCA_ID`, `MODELO`, `PRECO`, `COR_ID`, `QUANTIDADE`) VALUES (10, 5, 'X1', 70000, 2, 5);

/*MERCEDES-BENZ*/
INSERT INTO `CARRO`(`ID`, `MARCA_ID`, `MODELO`, `PRECO`, `COR_ID`, `QUANTIDADE`) VALUES (11, 4, 'AMG', 70000, 2, 5);

/*MUSTANG*/
INSERT INTO `CARRO`(`ID`, `MARCA_ID`, `MODELO`, `PRECO`, `COR_ID`, `QUANTIDADE`) VALUES (12, 3, 'COUPE', 50000, 2, 5);

/*ASTON MARTIN*/
INSERT INTO `CARRO`(`ID`, `MARCA_ID`, `MODELO`, `PRECO`, `COR_ID`, `QUANTIDADE`) VALUES (17, 9, 'DB9', 96000, 2, 5);

/*DODGE*/
INSERT INTO `CARRO`(`ID`, `MARCA_ID`, `MODELO`, `PRECO`, `COR_ID`, `QUANTIDADE`) VALUES (18, 10, 'CHALLENGER', 48000, 6, 5);

/*FORD*/
INSERT INTO `CARRO`(`ID`, `MARCA_ID`, `MODELO`, `PRECO`, `COR_ID`, `QUANTIDADE`) VALUES (19, 8, 'GT', 110000, 2, 5);

/*MCLAREN*/
INSERT INTO `CARRO`(`ID`, `MARCA_ID`, `MODELO`, `PRECO`, `COR_ID`, `QUANTIDADE`) VALUES (20, 11, '675LT', 350000, 6, 5);

/*IMAGENS FERRARI*/
INSERT INTO `IMAGENS`(`CARRO_ID`, `IMAGENS`) VALUES(1, 'http://localhost/marcas/ferrari.jpg')
INSERT INTO `IMAGENS`(`CARRO_ID`, `IMAGENS`) VALUES(2, 'http://localhost/ferrari/458.jpg')
INSERT INTO `IMAGENS`(`CARRO_ID`, `IMAGENS`) VALUES(3, 'http://localhost/ferrari/laFerrari.jpg')
INSERT INTO `IMAGENS`(`CARRO_ID`, `IMAGENS`) VALUES(4, 'http://localhost/ferrari/italia.jpg')
INSERT INTO `IMAGENS`(`CARRO_ID`, `IMAGENS`) VALUES(16, 'http://localhost/ferrari/enzo.jpg')

/*IMAGENS AUDI*/
INSERT INTO `IMAGENS`(`CARRO_ID`, `IMAGENS`) VALUES(5, 'http://localhost/marcas/audi.jpg');
INSERT INTO `IMAGENS`(`CARRO_ID`, `IMAGENS`) VALUES(5, 'http://localhost/audi/r8/r82.png');
INSERT INTO `IMAGENS`(`CARRO_ID`, `IMAGENS`) VALUES(5, 'http://localhost/audi/r8/r83.png');
INSERT INTO `IMAGENS`(`CARRO_ID`, `IMAGENS`) VALUES(6, 'http://localhost/audi/a4.jpg');
INSERT INTO `IMAGENS`(`CARRO_ID`, `IMAGENS`) VALUES(7, 'http://localhost/audi/q7.jpg');
INSERT INTO `IMAGENS`(`CARRO_ID`, `IMAGENS`) VALUES(13, 'http://localhost/audi/spyder.jpg');
INSERT INTO `IMAGENS`(`CARRO_ID`, `IMAGENS`) VALUES(14, 'http://localhost/audi/tt.jpg');
INSERT INTO `IMAGENS`(`CARRO_ID`, `IMAGENS`) VALUES(15, 'http://localhost/audi/ttConversivel.jpg');


/*IMAGENS ASTON MARTIN*/
INSERT INTO `IMAGENS`(`CARRO_ID`, `IMAGENS`) VALUES(17, 'http://localhost/aston%20martin/db9.jpg');

/*IMAGENS MACLAREN*/
INSERT INTO `IMAGENS`(`CARRO_ID`, `IMAGENS`) VALUES(20, 'http://localhost/MCLAREN/675lt.jpg');

/*IMAGENS FORD*/
INSERT INTO `IMAGENS`(`CARRO_ID`, `IMAGENS`) VALUES(19, 'http://localhost/ford/gt.jpg');

/*IMAGENS DODGE*/
INSERT INTO `IMAGENS`(`CARRO_ID`, `IMAGENS`) VALUES(18, 'http://localhost/dodge/challenger.jpg');


INSERT INTO `IMAGENS`(`CARRO_ID`, `IMAGENS`) VALUES(8, 'http://localhost/marcas/porsche.jpg');
INSERT INTO `IMAGENS`(`CARRO_ID`, `IMAGENS`) VALUES(9, 'http://localhost/marcas/lamborghini.jpg');
INSERT INTO `IMAGENS`(`CARRO_ID`, `IMAGENS`) VALUES(10, 'http://localhost/marcas/bmw.jpg');

/*IMAGENS MUSTANG*/
INSERT INTO `IMAGENS`(`CARRO_ID`, `IMAGENS`) VALUES(12, 'http://localhost/img/mustang/red/redFront.png');
INSERT INTO `IMAGENS`(`CARRO_ID`, `IMAGENS`) VALUES(12, 'http://localhost/img/mustang/red/redSide.png');
INSERT INTO `IMAGENS`(`CARRO_ID`, `IMAGENS`) VALUES(12, 'hthttp://localhost/img/mustang/red/redBack.png');
INSERT INTO `IMAGENS`(`CARRO_ID`, `IMAGENS`) VALUES(12, 'http://localhost/img/mustang/yellow/yellowFront.png');
INSERT INTO `IMAGENS`(`CARRO_ID`, `IMAGENS`) VALUES(12, 'http://localhost/img/mustang/yellow/yellowSide.png');
INSERT INTO `IMAGENS`(`CARRO_ID`, `IMAGENS`) VALUES(12, 'http://localhost/img/mustang/yellow/yellowBack.png');
INSERT INTO `IMAGENS`(`CARRO_ID`, `IMAGENS`) VALUES(12, 'http://localhost/img/mustang/gray/grayFront.png');
INSERT INTO `IMAGENS`(`CARRO_ID`, `IMAGENS`) VALUES(12, 'http://localhost/img/mustang/gray/graySide.png');
INSERT INTO `IMAGENS`(`CARRO_ID`, `IMAGENS`) VALUES(12, 'http://localhost/img/mustang/gray/grayBack.png');
INSERT INTO `IMAGENS`(`CARRO_ID`, `IMAGENS`) VALUES(12, 'http://localhost/img/mustang/white/whiteFront.png');
INSERT INTO `IMAGENS`(`CARRO_ID`, `IMAGENS`) VALUES(12, 'http://localhost/img/mustang/white/whiteSide.png');
INSERT INTO `IMAGENS`(`CARRO_ID`, `IMAGENS`) VALUES(12, 'http://localhost/img/mustang/white/whiteBack.png');
INSERT INTO `IMAGENS`(`CARRO_ID`, `IMAGENS`) VALUES(12, 'http://localhost/img/mustang/black/blackFront.png');
INSERT INTO `IMAGENS`(`CARRO_ID`, `IMAGENS`) VALUES(12, 'http://localhost/img/mustang/black/blackSide.png');
INSERT INTO `IMAGENS`(`CARRO_ID`, `IMAGENS`) VALUES(12, 'http://localhost/img/mustang/black/blackBack.png');
INSERT INTO `IMAGENS`(`CARRO_ID`, `IMAGENS`) VALUES(12, 'http://localhost/img/mustang/blue/blueFront.png');
INSERT INTO `IMAGENS`(`CARRO_ID`, `IMAGENS`) VALUES(12, 'http://localhost/img/mustang/blue/blueSide.png');
INSERT INTO `IMAGENS`(`CARRO_ID`, `IMAGENS`) VALUES(12, 'http://localhost/img/mustang/blue/blueBack.png');




/*CARROS PERSONALIZADOS PARA VENDA (FERRARI)*/
INSERT INTO `CARRO_VENDA`(`ID`, `COR_ID`, `CARRO_ID`) VALUES (1, 1, 1);


/*CARROS PERSONALIZADOS PARA VENDA (AUDI)*/
INSERT INTO `CARRO_VENDA`(`ID`, `COR_ID`, `CARRO_ID`) VALUES (2, 2, 5);

/*VENDAS*/

INSERT INTO `VENDA`(`ID`, `CARRO_ID`, `VALOR_TOTAL`,  `VENDA_COMPLETA`, `USUARIO_ID`) VALUES(14, 1, 887000,  1, 1);
INSERT INTO `VENDA`(`ID`, `CARRO_ID`, `VALOR_TOTAL`, `VENDA_COMPLETA`, `USUARIO_ID`) VALUES(15, 2, 800000,  1, 1);


