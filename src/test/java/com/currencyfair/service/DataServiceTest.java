package com.currencyfair.service;

import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.transaction.Transactional;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.currencyfair.dao.DataDao;
import com.currencyfair.dao.DataDaoTest;
import com.currencyfair.domain.CurrencyTransaction;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/test/resources/test-spring-config.xml")
@TransactionConfiguration(defaultRollback = true)
public class DataServiceTest extends
		AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	DataService dataService;

	@Autowired
	JdbcTemplate jdbcTemplate;
	private ResourceBundle resourceBundle;
	private static final Logger logger = LoggerFactory
			.getLogger(DataDaoTest.class);

	@Before
	public void setUp() {
	}

	@Test
	public void testGetCurrencyTransactions() {
		List<CurrencyTransaction> list = dataService
				.getCurrencyTransactions();
		Assert.assertEquals(3, list.size());
	}

	@Test
	public void testSaveTransaction() {
		int initNRows = dataService.getCurrencyTransactions().size();

		CurrencyTransaction transaction = new CurrencyTransaction();
		transaction.setUserId(14);
		transaction.setCurrencyFrom("USD");
		transaction.setCurrencyTo("EUR");
		transaction.setAmountSell(400.10);
		transaction.setAmountBuy(300.05);
		transaction.setRate(0.67);
		transaction.setTimePlaced(new Date());
		transaction.setOriginatingCountry("AUS");

		dataService.saveTransaction(transaction);

		Assert.assertEquals(dataService.getCurrencyTransactions().size(),
				initNRows + 1);
	}

	@Test
	public void testDeleteTransaction() {
		List<CurrencyTransaction> transactionList = dataService
				.getCurrencyTransactions();
		dataService.deleteTransaction(transactionList.get(0).getId());
		List<CurrencyTransaction> transactionListFinal = dataService
				.getCurrencyTransactions();

		Assert.assertEquals(transactionListFinal.size() + 1,
				transactionList.size());
	}

	@After
	public void tearDown() {

	}
}
