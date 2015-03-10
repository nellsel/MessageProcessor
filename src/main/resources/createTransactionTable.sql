CREATE TABLE IF NOT EXISTS `transaction` (  
  `id` int(11) NOT NULL AUTO_INCREMENT,  
  `userId` int(11) NOT NULL,  
  `currencyFrom` varchar(45) NOT NULL,  
  `currencyTo` varchar(45)  NOT NULL,  
  `amountSell` DOUBLE PRECISION(10,2) NOT NULL,
  `amountBuy` DOUBLE PRECISION(10,2) NOT NULL,
  `rate` DOUBLE PRECISION(10,4) NOT NULL,
  `timePlaced` DateTime NOT NULL,
  `originatingCountry` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)  
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;  