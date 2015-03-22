package com.cbm.bean;

public class Transaction {
	private int tranxId;
	private int tranxType;
	private int amount;
	private User user;
	private Item item;
	private String tranxSummary;
	
	public String getTranxSummary() {
		return tranxSummary;
	}
	public void setTranxSummary(String tranxSummary) {
		this.tranxSummary = tranxSummary;
	}
	public int getTranxId() {
		return tranxId;
	}
	public void setTranxId(int tranxId) {
		this.tranxId = tranxId;
	}
	public int getTranxType() {
		return tranxType;
	}
	public void setTranxType(int tranxType) {
		this.tranxType = tranxType;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	
}
