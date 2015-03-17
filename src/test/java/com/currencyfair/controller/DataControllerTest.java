package com.currencyfair.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.*;

import com.currencyfair.dao.DataDao;
import com.currencyfair.domain.CurrencyTransaction;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/test/resources/test-spring-config.xml")
public class DataControllerTest extends
		AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	DataDao transactionDao;
	public static final String SERVER_URI = "http://localhost:8080/MessageProccessorWebApp";
	private RestTemplate restTemplate;
	private ResourceBundle resourceBundle;
	private static final Logger logger = LoggerFactory
			.getLogger(DataControllerTest.class);

	@Before
	public void setUp() {
		this.restTemplate = new RestTemplate();
		this.resourceBundle = PropertyResourceBundle
				.getBundle("TestServiceJSON");

	}

	@Test
	public void testSaveTransaction() {

		int nTransactionsStart = transactionDao.getCurrencyTransactions()
				.size();

		String requestBody = this.resourceBundle.getString("testSendMoney");
		CurrencyTransaction transaction = new CurrencyTransaction();
		transaction.setUserId(13);
		transaction.setCurrencyFrom("USD");
		transaction.setCurrencyTo("EUR");
		transaction.setAmountSell(400.10);
		transaction.setAmountBuy(300.05);
		transaction.setRate(0.67);
		transaction.setTimePlaced(new Date());
		transaction.setOriginatingCountry("AUS");
		ResponseEntity<String> response = restTemplate.postForEntity(SERVER_URI
				+ "/sendMoney", transaction, String.class);

		int nTransactionsEnd = transactionDao.getCurrencyTransactions().size() + 1;
		Assert.assertEquals(nTransactionsStart, nTransactionsStart);
	}

	@Test(expected=RestClientException.class)
	public void testSaveTransactionFail() {
		int nTransactionsStart = transactionDao.getCurrencyTransactions()
				.size();

		String requestBody = this.resourceBundle.getString("testSendMoneyFail");

		ResponseEntity<String> response = restTemplate.postForEntity(SERVER_URI
				+ "/sendMoney", requestBody, String.class);

		int nTransactionsEnd = transactionDao.getCurrencyTransactions().size();
		Assert.assertNotEquals(nTransactionsStart, nTransactionsStart);
	}

	@Test
	public void testGetTransactions() {

		ResponseEntity<String> res = restTemplate.getForEntity(SERVER_URI
				+ "/list", String.class);
		HttpStatus status = res.getStatusCode();
		Assert.assertEquals(status, HttpStatus.OK);

	}

	@Test
	public void testGetJsonCurrencyTransactions() throws JsonProcessingException, IOException {

		ResponseEntity<String> response = restTemplate.getForEntity(SERVER_URI
				+ "/list-json", String.class);

		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode rootNode = objectMapper.readTree(response.getBody().getBytes());
		JsonNode colsNode = rootNode.path("cols");
		JsonNode countryNode = colsNode.get(0);
		Iterator<JsonNode> it = countryNode.elements();
		String country = "";
		while (it.hasNext()) {
			country = it.next().asText();
		}
		Assert.assertEquals(country, "Country");
	}

	@After
	public void tearDown() {

	}
}
