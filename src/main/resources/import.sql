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

/*PORSCHE*/
INSERT INTO `CARRO`(`ID`, `MARCA_ID`, `MODELO`, `PRECO`, `COR_ID`, `QUANTIDADE`) VALUES (8, 6, 'CARRERA', 90000, 2, 5);

/*LAMBO*/
INSERT INTO `CARRO`(`ID`, `MARCA_ID`, `MODELO`, `PRECO`, `COR_ID`, `QUANTIDADE`) VALUES (9, 7, 'DIABLO', 300000, 2, 5);

/*BMW*/
INSERT INTO `CARRO`(`ID`, `MARCA_ID`, `MODELO`, `PRECO`, `COR_ID`, `QUANTIDADE`) VALUES (10, 5, 'X1', 70000, 2, 5);

/*MERCEDES*/
INSERT INTO `CARRO`(`ID`, `MARCA_ID`, `MODELO`, `PRECO`, `COR_ID`, `QUANTIDADE`) VALUES (11, 4, 'BENZ', 70000, 2, 5);



INSERT INTO `IMAGENS`(`CARRO_ID`, `IMAGENS`) VALUES(1, 'http://localhost/marcas/ferrari.jpg')
INSERT INTO `IMAGENS`(`CARRO_ID`, `IMAGENS`) VALUES(5, 'http://localhost/marcas/audi.jpg')
INSERT INTO `IMAGENS`(`CARRO_ID`, `IMAGENS`) VALUES(8, 'http://localhost/marcas/porsche.jpg')
INSERT INTO `IMAGENS`(`CARRO_ID`, `IMAGENS`) VALUES(9, 'http://localhost/marcas/lamborghini.jpg')
INSERT INTO `IMAGENS`(`CARRO_ID`, `IMAGENS`) VALUES(10, 'http://localhost/marcas/bmw.jpg')

INSERT INTO `CARRO_VENDA`(`ID`, `COR_ID`, `CARRO_ID`) VALUES (1, 1, 1);
