INSERT INTO `USER` (`ID`, `EMAIL`, `SENHA`, `NOME`, `SOBRENOME`, `CPF`, `CNH`) VALUES (1, 'matheusb95@gmail.com', '$2a$10$xge0W5Ifz4nU33U0geXn4OG0BUrtvA363OK9i5ts6rpxoyv8OJ4/G','Matheus', 'Soares', '436771768/24', '0000000000' );
INSERT INTO `MARCA`(`ID`, `NOME`, `LOGO`) VALUES (1, 'Ferrari', 'http://localhost/cebolutions/ferrari-logo.jpg');
INSERT INTO `COR` (`ID`, `NOME`, `VALOR`, `COR_PADRAO`) VALUES(1, 'Vermelho', 100, false);
INSERT INTO `CARRO`(`ID`, `MARCA_ID`, `MODELO`, `PRECO`, `COR_ID`, `QUANTIDADE`) VALUES (1, 1, 'Enzo', 700000, 1, 5);
INSERT INTO `CARRO_VENDA`(`ID`, `COR_ID`, `CARRO_ID`) VALUES (1, 1, 1);
