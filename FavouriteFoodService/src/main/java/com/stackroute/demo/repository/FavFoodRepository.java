package com.stackroute.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.demo.model.FavFood;
@Repository
public interface FavFoodRepository extends MongoRepository<FavFood,String>{
	FavFood findByfdcId(String fdcId);
	FavFood findByuserId(String userId);
	FavFood findByfdcIdAndUserId(String fdcId,String userId);
//	FavFood FindByuserIdandfdcId(String userId,String fdcId);
//	FavFood findByuserIdAndfdcId(String userId,String fdcId);
	void deleteByFdcIdAndUserId(String fdcId,String userId);
	List<FavFood> findAllByUserId(String userId);
}
