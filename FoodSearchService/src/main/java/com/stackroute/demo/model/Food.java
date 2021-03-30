package com.stackroute.demo.model;

import java.util.List;




public class Food {
	
	public String fdcId;
    public String description;
    public String brandOwner;
    public String ingredients;
    public String score;
    public String getBrandOwner() {
		return brandOwner;
	}

	public void setBrandOwner(String brandOwner) {
		this.brandOwner = brandOwner;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public List<Nutrients> foodNutrients;

    public Food()
    {
    	
    }

	public Food(String fdcId, String description, String ingredients, List<Nutrients> foodNutrients) {
		super();
		this.fdcId = fdcId;
		this.description = description;
		this.ingredients = ingredients;
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

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public List<Nutrients> getFoodNutrients() {
		return foodNutrients;
	}

	public void setFoodNutrients(List<Nutrients> foodNutrients) {
		this.foodNutrients = foodNutrients;
	}

	@Override
	public String toString() {
		return "Food [fdcId=" + fdcId + ", description=" + description + ", ingredients=" + ingredients + ", foodNutrients="
				+ foodNutrients + "]";
	}
    
    


}
