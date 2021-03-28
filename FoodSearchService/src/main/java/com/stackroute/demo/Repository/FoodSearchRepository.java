package com.stackroute.demo.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.demo.model.Foods;
@Repository
public interface FoodSearchRepository extends MongoRepository<Foods,String>{

}
