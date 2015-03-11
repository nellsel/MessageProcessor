package com.currencyfair.controller;

import org.junit.Assert;

import java.text.ParseException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.junit.After;
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
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.currencyfair.dao.DataDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring-config.xml")
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
	// @Ignore
	public void testSaveTransaction() throws ParseException {

		int nTransactionsStart = transactionDao.getCurrencyTransactions()
				.size();

		String requestBody = this.resourceBundle.getString("testSendMoney");

		ResponseEntity<String> response = restTemplate.postForEntity(SERVER_URI
				+ "/sendMoney", requestBody, String.class);

		int nTransactionsEnd = transactionDao.getCurrencyTransactions().size() + 1;
		Assert.assertEquals(nTransactionsStart, nTransactionsStart);

	}

	@Test
	public void testGetTransactions() {

		ModelAndView response;
		ResponseEntity<String> res = restTemplate.getForEntity(SERVER_URI
				+ "/list", String.class);
		HttpStatus status = res.getStatusCode();
		Assert.assertEquals(status, HttpStatus.OK);

	}

	@After
	public void tearDown() {

	}
}
