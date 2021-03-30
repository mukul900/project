package com.stackroute.demo.model;

public class Nutrients {

	public String nutrientNumber;
	public String nutrientName;
	public String value;
	public String unitName;
	
	public Nutrients()
	{
		
	}
	

	public Nutrients(String nutrientNumber, String nutrientName, String value, String unitName) {
		super();
		this.nutrientNumber = nutrientNumber;
		this.nutrientName = nutrientName;
		this.value = value;
		this.unitName = unitName;
	}


	public String getNutrientNumber() {
		return nutrientNumber;
	}

	public void setNutrientNumber(String nutrientNumber) {
		this.nutrientNumber = nutrientNumber;
	}

	public String getNutrientName() {
		return nutrientName;
	}

	public void setNutrientName(String nutrientName) {
		this.nutrientName = nutrientName;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	
	
	

}
