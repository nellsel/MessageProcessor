DROP sequence currencyfair_message_processor_db IF EXISTS;
CREATE sequence currencyfair_message_processor_db;

CREATE TABLE transaction (  
  id int(11) not NULL AUTO_INCREMENT,  
  userId int(11) not NULL,  
  currencyFrom varchar(3) not NULL,  
  currencyTo varchar(3)  not NULL,  
  amountSell double  not NULL,
  amountBuy double  not NULL,
  rate double  not NULL,
  timePlaced timestamp not NULL,
  originatingCountry varchar(3) not NULL,
  PRIMARY KEY (id)) 