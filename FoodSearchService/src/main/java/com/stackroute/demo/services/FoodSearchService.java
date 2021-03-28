package com.stackroute.demo.services;

import org.springframework.stereotype.Service;

import com.stackroute.demo.model.Foods;



public interface FoodSearchService {
	
	boolean addSearch(Foods foods);
}
