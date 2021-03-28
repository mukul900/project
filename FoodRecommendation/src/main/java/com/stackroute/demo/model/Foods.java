package com.stackroute.demo.model;

import java.util.List;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Foods {

	@Id
	public List<Food> foods;
	Foods(){
		
	}
	public Foods(List<Food> foods) {
		super();
		this.foods = foods;
	}
	public List<Food> getFoods() {
		return foods;
	}
	public void setFoods(List<Food> foods) {
		this.foods = foods;
	}
	@Override
	public String toString() {
		return "Foods [foods=" + foods + "]";
	}
	
}
