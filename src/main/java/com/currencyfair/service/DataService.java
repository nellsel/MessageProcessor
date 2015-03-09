package com.currencyfair.service;

import java.util.List;

import com.currencyfair.domain.CurrencyTransaction;

public interface DataService {

	public int saveTransaction(CurrencyTransaction transaction);

	public List<CurrencyTransaction> getCurrencyTransactions();
}
