package com.stackroute.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.demo.model.Food;
import com.stackroute.demo.model.Foods;
import com.stackroute.demo.service.FoodRecommendationService;

@RestController
@RequestMapping("/api/v1")
public class FoodRecommendationController {

	@Autowired
	FoodRecommendationService foodRecommendationService;
	
	public FoodRecommendationController(FoodRecommendationService foodRecommendationService)
	{
		this.foodRecommendationService=foodRecommendationService;
	}
	
	@GetMapping("/recommendation")
	public ResponseEntity<?> getRecommendation()
	{
		List<Foods> foods=foodRecommendationService.getRecommendation();
		System.out.println(foods);
		return new ResponseEntity<>(foods,HttpStatus.OK);
	}
}
