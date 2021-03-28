package com.stackroute.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.demo.Repository.FoodSearchRepository;
import com.stackroute.demo.model.Foods;
@Service
public class FoodSearchServiceImpl implements FoodSearchService{

	@Autowired
	FoodSearchRepository foodSearchRepository;
	
	@Override
	public boolean addSearch(Foods foods) {
		foodSearchRepository.save(foods);
		return true;
	}

}
