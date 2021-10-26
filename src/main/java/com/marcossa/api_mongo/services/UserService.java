package com.marcossa.api_mongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcossa.api_mongo.domain.User;
import com.marcossa.api_mongo.repository.UserRepository;

@Service
public class UserService  {
	
	@Autowired
	private UserRepository repository;
	
	 public List<User> findAll(){
		 return repository.findAll();
	 }
}
