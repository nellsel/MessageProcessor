package com.currencyfair.dao;

import java.util.List;
import com.currencyfair.domain.CurrencyTransaction;

public interface DataDao {

	public int saveTransaction(CurrencyTransaction transaction);
	
	public List<CurrencyTransaction> getCurrencyTransactions();
}
