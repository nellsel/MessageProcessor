CREATE TABLE IF NOT EXISTS `transaction` (  
  `id` int(11) NOT NULL AUTO_INCREMENT,  
  `user_id` int(11) NOT NULL,  
  `currency_from` varchar(45) NOT NULL,  
  `currency_to` varchar(45)  NOT NULL,  
  `amount_sell` DOUBLE PRECISION(10,2) NOT NULL,
  `amount_buy` DOUBLE PRECISION(10,2) NOT NULL,
  `rate` DOUBLE PRECISION(10,4) NOT NULL,
  `time_placed` TIMESTAMP NOT NULL,
  `originating_country` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)  
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;  