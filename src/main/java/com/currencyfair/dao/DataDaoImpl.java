package com.currencyfair.dao;

import java.io.Serializable;  
import java.util.List;  

import javax.transaction.Transactional;  

import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.springframework.beans.factory.annotation.Autowired;  

import com.currencyfair.domain.CurrencyTransaction;

public class DataDaoImpl implements DataDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<CurrencyTransaction> getCurrencyTransactions() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<CurrencyTransaction> transactionList = session.createQuery("from").list();
		session.close();
		return transactionList;
	}
	
	@Override
	@Transactional
	public int saveTransaction(CurrencyTransaction transaction) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(transaction);
		tx.commit();
		Serializable id = session.getIdentifier(transaction);
		session.close();
		
		return (Integer)id;
	}
}
