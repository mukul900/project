package com.stackroute.demo.service;

import java.util.List;

import com.stackroute.demo.model.Food;
import com.stackroute.demo.model.Foods;

public interface FoodRecommendationService {
	List<Foods> getRecommendation();
}
