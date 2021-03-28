package com.stackroute.UserAuth.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.UserAuth.model.User;


@Repository
public interface UserRepository extends CrudRepository<User, String>{

	User findByUsernameAndPassword(String username,String password);
}
