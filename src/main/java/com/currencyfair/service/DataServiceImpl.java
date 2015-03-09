package com.currencyfair.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.currencyfair.dao.DataDao;
import com.currencyfair.domain.CurrencyTransaction;

@Service
public class DataServiceImpl implements DataService{

	@Autowired
	DataDao transactionDao;
	
	@Autowired
	public int saveTransaction(CurrencyTransaction transaction){
		return transactionDao.saveTransaction(transaction);
	}
	
	@Autowired
	public List<CurrencyTransaction> getCurrencyTransactions()
	{
		return transactionDao.getCurrencyTransactions();
	}
	
}
