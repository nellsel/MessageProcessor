package com.currencyfair.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.Spring;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.currencyfair.dao.DataDao;
import com.currencyfair.domain.CurrencyTransaction;

@RunWith(SpringJUnit4ClassRunner.class)
public class DataControllerTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	DataDao transactionDao;
	public static final String SERVER_URI = "http://localhost:8080/MessageProccessorWebApp";
	private MockRestServiceServer mockServer;
	private RestTemplate restTemplate;

	@Before
	public void setUp(){
		this.restTemplate = new RestTemplate();
		this.mockServer = MockRestServiceServer.createServer(this.restTemplate);
	}

	@Test
	public void testSaveTransaction() throws ParseException {
		
		CurrencyTransaction transaction = new CurrencyTransaction();
		transaction.setUserId(13);
		transaction.setCurrencyFrom("USD");
		transaction.setCurrencyTo("EUR");
		transaction.setAmountSell(400.10);
		transaction.setAmountBuy(300.05);
		transaction.setRate(0.67);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = dateFormat.parse("1992-01-26 10:27:44");
		transaction.setTimePlaced(date);
		transaction.setOriginatingCountry("AUS");

		ModelAndView response = restTemplate.postForObject(SERVER_URI
				+ "/sendMoney", transaction, ModelAndView.class);
		
		Assert.assertEquals(response.getViewName(), "list");
		
	}
	
	@After
	public void tearDown(){
		
	}
}
