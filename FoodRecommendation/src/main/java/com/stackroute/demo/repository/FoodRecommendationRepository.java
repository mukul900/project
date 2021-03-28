package com.stackroute.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.demo.model.Food;
import com.stackroute.demo.model.Foods;
@Repository
public interface FoodRecommendationRepository extends MongoRepository<Foods, String> {

}
