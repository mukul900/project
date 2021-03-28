package com.stackroute.demo.model;

import java.util.List;

public class Food {

	public String fdcId;
	public String description;
	public String brandOwner;
	public String ingredients;
	public String score;
	public List<Nutrients> foodNutrients;
	
	public Food(){
		
	}

	public Food(String fdcId, String description, String brandOwner, String ingredients, String score,
			List<Nutrients> foodNutrients) {
		super();
		this.fdcId = fdcId;
		this.description = description;
		this.brandOwner = brandOwner;
		this.ingredients = ingredients;
		this.score = score;
		this.foodNutrients = foodNutrients;
	}

	public String getFdcId() {
		return fdcId;
	}

	public void setFdcId(String fdcId) {
		this.fdcId = fdcId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBrandOwner() {
		return brandOwner;
	}

	public void setBrandOwner(String brandOwner) {
		this.brandOwner = brandOwner;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public List<Nutrients> getFoodNutrients() {
		return foodNutrients;
	}

	public void setFoodNutrients(List<Nutrients> foodNutrients) {
		this.foodNutrients = foodNutrients;
	}

	@Override
	public String toString() {
		return "Food [fdcId=" + fdcId + ", description=" + description + ", brandOwner=" + brandOwner + ", ingredients="
				+ ingredients + ", score=" + score + ", foodNutrients=" + foodNutrients + "]";
	}
	
	
}
