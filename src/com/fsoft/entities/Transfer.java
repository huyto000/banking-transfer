package com.fsoft.entities;

public class Transfer {
	
	private int id;
	private long amount;
	private String transactionNote;
	private String accountReceive;
	private String accountTransfer;
	
	
	public Transfer(int id, long amount, String transactionNote, String accountReceive, String accountTransfer) {
		this.id = id;
		this.amount = amount;
		this.transactionNote = transactionNote;
		this.accountReceive = accountReceive;
		this.accountTransfer = accountTransfer;
	}
	
	public Transfer( long amount, String transactionNote, String accountReceive, String accountTransfer) {	
		this.amount = amount;
		this.transactionNote = transactionNote;
		this.accountReceive = accountReceive;
		this.accountTransfer = accountTransfer;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public String getTransactionNote() {
		return transactionNote;
	}
	public void setTransactionNote(String transactionNote) {
		this.transactionNote = transactionNote;
	}
	public String getAccountReceive() {
		return accountReceive;
	}
	public void setAccountReceive(String accountReceive) {
		this.accountReceive = accountReceive;
	}
	public String getAccountTransfer() {
		return accountTransfer;
	}
	public void setAccountTransfer(String accountTransfer) {
		this.accountTransfer = accountTransfer;
	}
	
}
