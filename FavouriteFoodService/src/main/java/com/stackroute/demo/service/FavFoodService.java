package com.stackroute.demo.service;

import java.util.List;

import com.stackroute.demo.exception.FavFoodAlreadyExistsException;
import com.stackroute.demo.exception.FavFoodAlreadyNotFoundException;
import com.stackroute.demo.model.FavFood;

public interface FavFoodService {

	boolean addFood(FavFood favFood) ;
	boolean deleteFavFood(String id,String userId) ;
	List<FavFood> getAllFavouriteFoods(String userId);

}
