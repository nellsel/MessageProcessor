package com.currencyfair.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="transaction")
public class CurrencyTransaction {

	private static final String DATE_FORMAT_DATABASE = "yyyy-MM-dd HH:mm:ss";
	
	@Id
	@GeneratedValue
	private int id;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "currency_from")
	private String currencyFrom;

	@Column(name = "currency_to")
	private String currencyTo;

	@Column(name = "amount_sell", precision=10, scale=2)
	private double amountSell;

	@Column(name = "amount_buy", precision=10, scale=2)
	private double amountBuy;

	@Column(precision=10, scale=4)
	private double rate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "time_placed")
	private Date timePlaced;

	@Column(name = "originating_country")
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
