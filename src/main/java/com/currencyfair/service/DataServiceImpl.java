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
	
	@Override
	public int saveTransaction(CurrencyTransaction transaction){
		return transactionDao.saveTransaction(transaction);
	}
	
	@Override
	public List<CurrencyTransaction> getCurrencyTransactions()
	{
		return transactionDao.getCurrencyTransactions();
	}
	
	@Override
	public int deleteTransaction(int id)
	{
		return transactionDao.deleteTransaction(id);
	}
	
}
