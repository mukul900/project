package com.stackroute.demo.model;

public class Nutrients {

	public String number;
	public String name;
	public String amount;
	public Nutrients()
	{
		
	}
	public Nutrients(String number, String name, String amount) {
		super();
		this.number = number;
		this.name = name;
		this.amount = amount;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Nutrients [number=" + number + ", name=" + name + ", amount=" + amount + "]";
	}

}
