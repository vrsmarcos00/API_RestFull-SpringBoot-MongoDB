package com.marcossa.api_mongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcossa.api_mongo.domain.Post;
import com.marcossa.api_mongo.repository.PostRepository;
import com.marcossa.api_mongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;
	
	public List<Post> findAll(){
		return repository.findAll();
	}
	
	public Post findById(String id) {
		Optional<Post> posts = repository.findById(id);
		return posts.orElseThrow(() -> new ObjectNotFoundException(id));
	}
	
	public List<Post> findByTitle(String text){
		return repository.findByTitleContainingIgnoreCase(text);
	}

}
