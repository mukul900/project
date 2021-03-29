package com.stackroute.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.demo.exception.FavFoodAlreadyExistsException;
import com.stackroute.demo.exception.FavFoodAlreadyNotFoundException;
import com.stackroute.demo.model.FavFood;
import com.stackroute.demo.repository.FavFoodRepository;
@Service
public class FavFoodServiceImpl implements FavFoodService {

	@Autowired
	FavFoodRepository favFoodRepository;
	
	
	public FavFoodServiceImpl(FavFoodRepository favFoodRepository)
	{
		this.favFoodRepository=favFoodRepository;
	}
	
	@Override
	public boolean addFood(FavFood favFood) {
//		if(favFoodRepository.findByfdcId(favFood.getFdcId())!=null && favFoodRepository.findByuserId(favFood.getUserId())!=null)
//		{
//			throw new FavFoodAlreadyExistsException("fav food already exists");
//		}
		FavFood found=favFoodRepository.findByfdcIdAndUserId(favFood.getFdcId(), favFood.getUserId());
		if(found!=null) {
			return false;
		}
		favFoodRepository.save(favFood);
		return true;
	}

	@Override
	public boolean deleteFavFood(String fdcId,String userId) {
		// TODO Auto-generated method stub
//		if(favFoodRepository.findByfdcIdAndUserId(fdcId, userId)==null)
//		{
//			throw new FavFoodAlreadyNotFoundException("no such food found in the fav item");
//		}
		FavFood found=favFoodRepository.findByfdcIdAndUserId(fdcId, userId);
		System.out.println(found);
	//	favFoodRepository.delete(found);
		favFoodRepository.deleteByFdcIdAndUserId(fdcId, userId);
		return true;
	}

	@Override
	public List<FavFood> getAllFavouriteFoods(String userId) {
		// TODO Auto-generated method stub
		return favFoodRepository.findAllByUserId(userId);
		
	}



}
