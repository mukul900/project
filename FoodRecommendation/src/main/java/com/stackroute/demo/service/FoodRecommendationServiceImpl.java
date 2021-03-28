package com.stackroute.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.demo.model.Food;
import com.stackroute.demo.model.Foods;
import com.stackroute.demo.repository.FoodRecommendationRepository;

@Service
public class FoodRecommendationServiceImpl implements FoodRecommendationService {


	@Autowired
	FoodRecommendationRepository foodRecommendationRepository;
	public FoodRecommendationServiceImpl(FoodRecommendationRepository foodRecommendationRepository)
	{
		this.foodRecommendationRepository=foodRecommendationRepository;
	}
	
	@Override
	public List<Foods> getRecommendation() {
		List<Foods> foods=   foodRecommendationRepository.findAll();
		return foods;
	}

}
