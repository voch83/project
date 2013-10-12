package com.pb.project.entity.impl;

import java.util.Date;
import com.pb.project.entity.Entity;

public class Credit implements Entity {
	
	private Integer id;
	private Currency currency;
	private Bank bank;
	private Client client;
	private double creditAmount;
	private double unpaidAmount;
	private Date dateStart;
	private Date dateEnd;
	private Boolean isDelay;
	
	public Credit() {
	}

	public Credit(Integer id, Currency currency, Bank bank, Client client,
			double creditAmount, double unpaidAmount, Date dateStart,
			Date dateEnd, Boolean isDelay) {
		super();
		this.id = id;
		this.currency = currency;
		this.bank = bank;
		this.client = client;
		this.creditAmount = creditAmount;
		this.unpaidAmount = unpaidAmount;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.isDelay = isDelay;
	}
        public Credit(Integer id, Currency currency, Bank bank, Client client,
			double creditAmount, double unpaidAmount, Date dateStart, Boolean isDelay) {
		super();
		this.id = id;
		this.currency = currency;
		this.bank = bank;
		this.client = client;
		this.creditAmount = creditAmount;
		this.unpaidAmount = unpaidAmount;
		this.dateStart = dateStart;
		this.isDelay = isDelay;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Currency getCurrency() {
		return currency;
	}
	
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	
	public Bank getBank() {
		return bank;
	}
	
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	
	public Client getClient() {
		return client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}

	public double getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(double creditAmount) {
		this.creditAmount = creditAmount;
	}

	public double getUnpaidAmount() {
		return unpaidAmount;
	}

	public void setUnpaidAmount(double unpaidAmount) {
		this.unpaidAmount = unpaidAmount;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public Boolean getIsDelay() {
		return isDelay;
	}

	public void setIsDelay(Boolean isDelay) {
		this.isDelay = isDelay;
	}

	@Override
	public String toString() {
		return "Credit [id=" + id + ", currency=" + currency + ", bank=" + bank
				+ ", client=" + client + ", creditAmount=" + creditAmount
				+ ", unpaidAmount=" + unpaidAmount + ", dateStart=" + dateStart
				+ ", dateEnd=" + dateEnd + ", isDelay=" + isDelay + "]";
	}
}
