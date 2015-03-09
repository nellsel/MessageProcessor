package com.currencyfair.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.currencyfair.domain.CurrencyTransaction;
import com.currencyfair.service.DataService;

@Controller
@ComponentScan("com.currencyfair.service")
public class DataController {

	@Autowired
	DataService dataService; 
	
	@RequestMapping("sendMoney")
	public ModelAndView sendMoney(@ModelAttribute CurrencyTransaction transaction)
	{
		dataService.saveTransaction(transaction);
		return new ModelAndView("redirect:list");
	}
	
	@RequestMapping("list")  
	 public ModelAndView getTransactionList() {  
	  List<CurrencyTransaction> transactionList = dataService.getCurrencyTransactions();   
	  return new ModelAndView("list", "transactionList", transactionList);  
	 }
	
}
