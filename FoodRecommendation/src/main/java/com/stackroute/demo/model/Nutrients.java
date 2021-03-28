package com.stackroute.demo.model;

public class Nutrients {

	public String nutrientName;
	public String nutrientNumber;
	public String value;
	
	
	public Nutrients()
	{
		
	}


	public Nutrients(String nutrientName, String nutrientNumber, String value) {
		super();
		this.nutrientName = nutrientName;
		this.nutrientNumber = nutrientNumber;
		this.value = value;
	}


	public String getNutrientName() {
		return nutrientName;
	}


	public void setNutrientName(String nutrientName) {
		this.nutrientName = nutrientName;
	}


	public String getNutrientNumber() {
		return nutrientNumber;
	}


	public void setNutrientNumber(String nutrientNumber) {
		this.nutrientNumber = nutrientNumber;
	}


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}


	@Override
	public String toString() {
		return "Nutrients [nutrientName=" + nutrientName + ", nutrientNumber=" + nutrientNumber + ", value=" + value
				+ "]";
	}


}
