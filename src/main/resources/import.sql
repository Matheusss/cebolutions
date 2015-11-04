INSERT INTO `USER` (`ID`, `EMAIL`, `SENHA`, `NOME`, `SOBRENOME`, `CPF`, `CNH`) VALUES (1, 'matheusb95@gmail.com', '$2a$10$xge0W5Ifz4nU33U0geXn4OG0BUrtvA363OK9i5ts6rpxoyv8OJ4/G','Matheus', 'Soares', '436771768/24', '0000000000' );

INSERT INTO `MARCA`(`ID`, `NOME`, `LOGO`, `MARCAS_PRINCIPAIS`) VALUES (1, 'Ferrari', 'http://localhost/cebolutions/ferrari-logo.jpg', 1);
INSERT INTO `MARCA`(`ID`, `NOME`, `LOGO`, `MARCAS_PRINCIPAIS`) VALUES (2, 'Audi', 'http://localhost/cebolutions/audi.jpg', 1);
INSERT INTO `MARCA`(`ID`, `NOME`, `LOGO`, `MARCAS_PRINCIPAIS`) VALUES (3, 'Mustang', 'http://localhost/cebolutions/mustang.jpg', 0);
INSERT INTO `MARCA`(`ID`, `NOME`, `LOGO`, `MARCAS_PRINCIPAIS`) VALUES (4, 'Mercedes', 'http://localhost/cebolutions/mercedes.jpg', 0);
INSERT INTO `MARCA`(`ID`, `NOME`, `LOGO`, `MARCAS_PRINCIPAIS`) VALUES (5, 'BMW', 'http://localhost/cebolutions/bmw.jpg', 1);
INSERT INTO `MARCA`(`ID`, `NOME`, `LOGO`, `MARCAS_PRINCIPAIS`) VALUES (6, 'Porsche', 'http://localhost/cebolutions/porsche.jpg', 1);
INSERT INTO `MARCA`(`ID`, `NOME`, `LOGO`, `MARCAS_PRINCIPAIS`) VALUES (7, 'Lamborghini', 'http://localhost/cebolutions/lamborghini.jpg', 1);
INSERT INTO `MARCA`(`ID`, `NOME`, `LOGO`, `MARCAS_PRINCIPAIS`) VALUES (8, 'Ford', 'http://localhost/cebolutions/ford.jpeg', 0);
INSERT INTO `MARCA`(`ID`, `NOME`, `LOGO`, `MARCAS_PRINCIPAIS`) VALUES (9, 'Aston Martin', 'http://localhost/cebolutions/aston.jpg', 0);

/*CORES*/
INSERT INTO `COR` (`ID`, `NOME`, `VALOR`, `COR_PADRAO`) VALUES(1, 'Vermelho', 100, false);
INSERT INTO `COR` (`ID`, `NOME`, `VALOR`, `COR_PADRAO`) VALUES(2, 'Branco', 50, true);
INSERT INTO `COR` (`ID`, `NOME`, `VALOR`, `COR_PADRAO`) VALUES(3, 'Amarelo', 200, false);


/*FERRARI*/
INSERT INTO `CARRO`(`ID`, `MARCA_ID`, `MODELO`, `PRECO`, `COR_ID`, `QUANTIDADE`) VALUES (1, 1, 'Enzo', 700000, 1, 5);
INSERT INTO `CARRO`(`ID`, `MARCA_ID`, `MODELO`, `PRECO`, `COR_ID`, `QUANTIDADE`) VALUES (2, 1, '458', 600000, 1, 5);
INSERT INTO `CARRO`(`ID`, `MARCA_ID`, `MODELO`, `PRECO`, `COR_ID`, `QUANTIDADE`) VALUES (3, 1, 'LaFerrari', 800000, 1, 5);
INSERT INTO `CARRO`(`ID`, `MARCA_ID`, `MODELO`, `PRECO`, `COR_ID`, `QUANTIDADE`) VALUES (4, 1, 'Italia', 500000, 1, 5);

/*AUDI*/
INSERT INTO `CARRO`(`ID`, `MARCA_ID`, `MODELO`, `PRECO`, `COR_ID`, `QUANTIDADE`) VALUES (5, 2, 'R8', 100000, 2, 5);
INSERT INTO `CARRO`(`ID`, `MARCA_ID`, `MODELO`, `PRECO`, `COR_ID`, `QUANTIDADE`) VALUES (6, 2, 'A4', 90000, 2, 5);
INSERT INTO `CARRO`(`ID`, `MARCA_ID`, `MODELO`, `PRECO`, `COR_ID`, `QUANTIDADE`) VALUES (7, 2, 'Q7', 50000, 1, 5);
INSERT INTO `CARRO`(`ID`, `MARCA_ID`, `MODELO`, `PRECO`, `COR_ID`, `QUANTIDADE`) VALUES (13, 2, 'SPYDER', 50000, 1, 5);
INSERT INTO `CARRO`(`ID`, `MARCA_ID`, `MODELO`, `PRECO`, `COR_ID`, `QUANTIDADE`) VALUES (14, 2, 'TT', 50000, 1, 5);
INSERT INTO `CARRO`(`ID`, `MARCA_ID`, `MODELO`, `PRECO`, `COR_ID`, `QUANTIDADE`) VALUES (15, 2, 'TT CONVERSIVEL', 50000, 1, 5);

/*PORSCHE*/
INSERT INTO `CARRO`(`ID`, `MARCA_ID`, `MODELO`, `PRECO`, `COR_ID`, `QUANTIDADE`) VALUES (8, 6, 'CARRERA', 90000, 2, 5);

/*LAMBO*/
INSERT INTO `CARRO`(`ID`, `MARCA_ID`, `MODELO`, `PRECO`, `COR_ID`, `QUANTIDADE`) VALUES (9, 7, 'DIABLO', 300000, 2, 5);

/*BMW*/
INSERT INTO `CARRO`(`ID`, `MARCA_ID`, `MODELO`, `PRECO`, `COR_ID`, `QUANTIDADE`) VALUES (10, 5, 'X1', 70000, 2, 5);

/*MERCEDES*/
INSERT INTO `CARRO`(`ID`, `MARCA_ID`, `MODELO`, `PRECO`, `COR_ID`, `QUANTIDADE`) VALUES (11, 4, 'BENZ', 70000, 2, 5);

/*MUSTANG*/
INSERT INTO `CARRO`(`ID`, `MARCA_ID`, `MODELO`, `PRECO`, `COR_ID`, `QUANTIDADE`) VALUES (12, 3, 'COUPÉ', 50000, 1, 5);


/*IMAGENS FERRARI*/
INSERT INTO `IMAGENS`(`CARRO_ID`, `IMAGENS`) VALUES(1, 'http://localhost/marcas/ferrari.jpg')

/*IMAGENS AUDI*/
INSERT INTO `IMAGENS`(`CARRO_ID`, `IMAGENS`) VALUES(5, 'http://localhost/marcas/audi.jpg');
INSERT INTO `IMAGENS`(`CARRO_ID`, `IMAGENS`) VALUES(5, 'http://localhost/audi/r8/r82.png');
INSERT INTO `IMAGENS`(`CARRO_ID`, `IMAGENS`) VALUES(5, 'http://localhost/audi/r8/r83.png');
INSERT INTO `IMAGENS`(`CARRO_ID`, `IMAGENS`) VALUES(6, 'http://localhost/audi/a4.jpg');
INSERT INTO `IMAGENS`(`CARRO_ID`, `IMAGENS`) VALUES(7, 'http://localhost/audi/q7.jpg');
INSERT INTO `IMAGENS`(`CARRO_ID`, `IMAGENS`) VALUES(13, 'http://localhost/audi/spyder.jpg');
INSERT INTO `IMAGENS`(`CARRO_ID`, `IMAGENS`) VALUES(14, 'http://localhost/audi/tt.jpg');
INSERT INTO `IMAGENS`(`CARRO_ID`, `IMAGENS`) VALUES(15, 'http://localhost/audi/ttConversivel.jpg');


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
INSERT INTO `CARRO_VENDA`(`ID`, `COR_ID`, `CARRO_ID`) VALUES (2, 1, 1);
INSERT INTO `CARRO_VENDA`(`ID`, `COR_ID`, `CARRO_ID`) VALUES (3, 2, 1);
INSERT INTO `CARRO_VENDA`(`ID`, `COR_ID`, `CARRO_ID`) VALUES (4, 3, 2);
INSERT INTO `CARRO_VENDA`(`ID`, `COR_ID`, `CARRO_ID`) VALUES (5, 3, 2);
INSERT INTO `CARRO_VENDA`(`ID`, `COR_ID`, `CARRO_ID`) VALUES (6, 2, 3);
INSERT INTO `CARRO_VENDA`(`ID`, `COR_ID`, `CARRO_ID`) VALUES (7, 1, 3);
INSERT INTO `CARRO_VENDA`(`ID`, `COR_ID`, `CARRO_ID`) VALUES (8, 1, 4);

/*CARROS PERSONALIZADOS PARA VENDA (AUDI)*/
INSERT INTO `CARRO_VENDA`(`ID`, `COR_ID`, `CARRO_ID`) VALUES (9, 2, 5);
INSERT INTO `CARRO_VENDA`(`ID`, `COR_ID`, `CARRO_ID`) VALUES (10, 2, 5);
INSERT INTO `CARRO_VENDA`(`ID`, `COR_ID`, `CARRO_ID`) VALUES (11, 3, 6);
INSERT INTO `CARRO_VENDA`(`ID`, `COR_ID`, `CARRO_ID`) VALUES (12, 3, 7);
INSERT INTO `CARRO_VENDA`(`ID`, `COR_ID`, `CARRO_ID`) VALUES (13, 3, 7);
INSERT INTO `CARRO_VENDA`(`ID`, `COR_ID`, `CARRO_ID`) VALUES (14, 2, 7);
INSERT INTO `CARRO_VENDA`(`ID`, `COR_ID`, `CARRO_ID`) VALUES (15, 1, 6);

/*VENDAS*/
INSERT INTO `VENDA`(`ID`, `CARRO_ID`, `VALOR_TOTAL`, `VENDA_COMPLETA`) VALUES(1, 1, 800000, 1);
INSERT INTO `VENDA`(`ID`, `CARRO_ID`, `VALOR_TOTAL`, `VENDA_COMPLETA`) VALUES(2, 2, 800000, 1);
INSERT INTO `VENDA`(`ID`, `CARRO_ID`, `VALOR_TOTAL`,`VENDA_COMPLETA`) VALUES(3, 3, 500000, 1);
INSERT INTO `VENDA`(`ID`, `CARRO_ID`, `VALOR_TOTAL`,  `VENDA_COMPLETA`) VALUES(4, 4, 600000,  0);
INSERT INTO `VENDA`(`ID`, `CARRO_ID`, `VALOR_TOTAL`,  `VENDA_COMPLETA`) VALUES(5, 5, 8700000,  1);
INSERT INTO `VENDA`(`ID`, `CARRO_ID`, `VALOR_TOTAL`,  `VENDA_COMPLETA`) VALUES(6, 6, 85000,  1);
INSERT INTO `VENDA`(`ID`, `CARRO_ID`, `VALOR_TOTAL`,  `VENDA_COMPLETA`) VALUES(7, 7, 84000, 1);
INSERT INTO `VENDA`(`ID`, `CARRO_ID`, `VALOR_TOTAL`,`VENDA_COMPLETA`) VALUES(8, 8, 760000, 1);
INSERT INTO `VENDA`(`ID`, `CARRO_ID`, `VALOR_TOTAL`,  `VENDA_COMPLETA`) VALUES(9, 9, 980000,  0);
INSERT INTO `VENDA`(`ID`, `CARRO_ID`, `VALOR_TOTAL`,  `VENDA_COMPLETA`) VALUES(10, 10, 100000, 0);
INSERT INTO `VENDA`(`ID`, `CARRO_ID`, `VALOR_TOTAL`, `VENDA_COMPLETA`) VALUES(11, 11, 1200000,  1);
INSERT INTO `VENDA`(`ID`, `CARRO_ID`, `VALOR_TOTAL`, `VENDA_COMPLETA`) VALUES(12, 12, 850000,  1);
INSERT INTO `VENDA`(`ID`, `CARRO_ID`, `VALOR_TOTAL`, `VENDA_COMPLETA`) VALUES(13, 13, 890000,  1);
INSERT INTO `VENDA`(`ID`, `CARRO_ID`, `VALOR_TOTAL`,  `VENDA_COMPLETA`) VALUES(14, 14, 887000,  1);
INSERT INTO `VENDA`(`ID`, `CARRO_ID`, `VALOR_TOTAL`, `VENDA_COMPLETA`) VALUES(15, 15, 800000,  1);


