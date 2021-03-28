package com.stackroute.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.stackroute.demo.exception.FavFoodAlreadyExistsException;
import com.stackroute.demo.exception.FavFoodAlreadyNotFoundException;
import com.stackroute.demo.model.FavFood;
import com.stackroute.demo.model.Food;
import com.stackroute.demo.service.FavFoodService;

@RestController
@RequestMapping("/api/v1")
public class FavFoodController {

	@Autowired
	public RestTemplate restTemplate;
	FavFoodService favFoodService;
	public FavFoodController(FavFoodService favFoodService)
	{
		this.favFoodService=favFoodService;
	}
	
	@GetMapping("/list/{userId}")
	public ResponseEntity<?> getFoods(@PathVariable String userId)
	{
//		String url="https://api.nal.usda.gov/fdc/v1/foods/list?api_key=mePgL9SZb9oVIiGtjvgbkRbojo1URDdNUbZcokuA";
//		FavFood[] foods= restTemplate.getForObject(url,FavFood[].class);
//		System.out.println(foods[0].getFoodNutrients().get(0));
//		return Arrays.asList(foods);	
		List<FavFood> favFood=favFoodService.getAllFavouriteFoods(userId);
		return new ResponseEntity<>(favFood,HttpStatus.OK);
	}
	
//	@GetMapping("search/{id}")
//	public ResponseEntity<?> getByIndex(@PathVariable int id)
//	{
//		String url="https://api.nal.usda.gov/fdc/v1/foods/list?api_key=mePgL9SZb9oVIiGtjvgbkRbojo1URDdNUbZcokuA";
//		FavFood[] foods= restTemplate.getForObject(url,FavFood[].class);
//		favFoodService.addFood(foods[id]);
//		return new ResponseEntity<>(foods[id],HttpStatus.OK);
//	}
	@PostMapping("/add/{userId}")
	public ResponseEntity<?> addfood(@PathVariable String userId,@RequestBody FavFood favfood)
	{
		
		FavFood newFood=new FavFood();
		newFood.setFdcId(favfood.getFdcId());
		newFood.setUserId(userId);
		newFood.setBrandOwner(favfood.getBrandOwner());
		newFood.setDescription(favfood.getDescription());
		newFood.setFoodNutrients(favfood.getFoodNutrients());
		newFood.setIngredients(favfood.getIngredients());
		newFood.setScore(favfood.getScore());
	

		favFoodService.addFood(newFood);
		return new ResponseEntity<>(newFood,HttpStatus.CREATED);
		
	}
	
	
	@DeleteMapping("/delete/{fdcId}/{userId}")
	public ResponseEntity<?> delete(@PathVariable String fdcId,@PathVariable String userId) {
		
		boolean b=favFoodService.deleteFavFood(fdcId,userId);
		System.out.println(b);
		return new ResponseEntity<>(b,HttpStatus.OK);
//		}catch(FavFoodAlreadyNotFoundException e)
//		{
//			return new ResponseEntity<>("No record found for this Food",HttpStatus.CONFLICT);
//		}
	}

}
