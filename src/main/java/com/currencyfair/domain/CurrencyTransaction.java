package com.currencyfair.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "transaction")
public class CurrencyTransaction{

	@Id
	@GeneratedValue
	private int id;

	@JsonFormat(shape=JsonFormat.Shape.STRING)
	private int userId;

	@JsonFormat(shape=JsonFormat.Shape.STRING)
	@Size(max = 3)
	private String currencyFrom;

	@JsonFormat(shape=JsonFormat.Shape.STRING)
	@Size(max = 3)
	private String currencyTo;

	@JsonFormat(shape=JsonFormat.Shape.STRING)
	private double amountSell;

	@JsonFormat(shape=JsonFormat.Shape.STRING)
	private double amountBuy;

	@JsonFormat(shape=JsonFormat.Shape.STRING)
	private double rate;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MMM-yyyy HH:mm:ss")
	private Date timePlaced;

	@JsonFormat(shape=JsonFormat.Shape.STRING)
	@Size(max = 3)
	private String originatingCountry;

	public void setId(int id) {
		this.id = id;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setAmountSell(double amountSell) {
		this.amountSell = amountSell;
	}

	public void setAmountBuy(double amountBuy) {
		this.amountBuy = amountBuy;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public void setTimePlaced(Date timePlaced) {
		this.timePlaced = timePlaced;
	}

	public void setOriginatingCountry(String originatingCountry) {
		this.originatingCountry = originatingCountry;
	}

	public int getId() {
		return id;
	}

	public void SetId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public String getCurrencyFrom() {
		return currencyFrom;
	}

	public void setCurrencyFrom(String currencyFrom) {
		this.currencyFrom = currencyFrom;
	}

	public String getCurrencyTo() {
		return currencyTo;
	}

	public void setCurrencyTo(String currencyTo) {
		this.currencyTo = currencyTo;
	}

	public double getAmountSell() {
		return amountSell;
	}

	public double getAmountBuy() {
		return amountBuy;
	}

	public double getRate() {
		return rate;
	}


	public Date getTimePlaced() {
		return timePlaced;
	}

	public String getOriginatingCountry() {
		return originatingCountry;
	}
}
