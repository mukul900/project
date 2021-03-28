package com.stackroute.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.stackroute.demo.Repository.FoodSearchRepository;
import com.stackroute.demo.model.Foods;
import com.stackroute.demo.services.FoodSearchService;

@RestController
@RequestMapping("api/v1")
public class FoodSearchServiceController {

	@Autowired
	RestTemplate restTemplate;
	FoodSearchService foodSearchService;
	public FoodSearchServiceController(FoodSearchService foodSearchService)
	{
		this.foodSearchService=foodSearchService;
	}
	
	@PostMapping("/search/{name}")
	public ResponseEntity<?> getFood(@PathVariable String name)
	{	
		String url="https://api.nal.usda.gov/fdc/v1/foods/search?api_key=mePgL9SZb9oVIiGtjvgbkRbojo1URDdNUbZcokuA&query="+name;
		System.out.println(url);
		Foods foods= restTemplate.getForObject(url,Foods.class);
		foodSearchService.addSearch(foods);
		return new ResponseEntity<>(foods,HttpStatus.OK);
	}
}
