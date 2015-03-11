package com.currencyfair.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.currencyfair.domain.CurrencyTransaction;
import com.currencyfair.service.DataService;

@Controller
public class DataController {

	@Autowired
	DataService dataService; 
	private static final Logger logger = LoggerFactory.getLogger(DataController.class);
	
	@RequestMapping(value ="/sendMoney", method=RequestMethod.POST)
	public @ResponseBody ModelAndView sendMoney(@RequestBody CurrencyTransaction transaction)
	{
		logger.info("Start sendMoney");
		dataService.saveTransaction(transaction);
		return new ModelAndView("redirect:list");
		
	}
	
	@RequestMapping("list")  
	 public ModelAndView getTransactionList() {
		logger.info("Start getTransactionList");
	  List<CurrencyTransaction> transactionList = dataService.getCurrencyTransactions();   
	  return new ModelAndView("list", "transactionList", transactionList);  
	 }

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@RequestMapping("error")
	public ModelAndView handleException(HttpServletRequest req, Exception exception)
	{
		logger.info("Start handleException " + req.toString() + "/n" + exception.getMessage());
		return new ModelAndView("error");
	}
}
