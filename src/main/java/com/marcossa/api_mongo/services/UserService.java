package com.marcossa.api_mongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcossa.api_mongo.domain.User;
import com.marcossa.api_mongo.dto.UserDTO;
import com.marcossa.api_mongo.repository.UserRepository;
import com.marcossa.api_mongo.services.exception.ObjectNotFoundException;

@Service
public class UserService  {
	
	@Autowired
	private UserRepository repository;
	
	 public List<User> findAll(){
		 return repository.findAll();
	 }
	 
	 public User findById(String id) {
		 Optional<User> user = repository.findById(id);
		 return user.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));
	 }
	 
	 public User insert(User obj) {
		 return repository.insert(obj);
	 }
	 
	 public User fromDTO(UserDTO objDto) {
		 return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	 }
}
