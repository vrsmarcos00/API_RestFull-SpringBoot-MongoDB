package com.marcossa.api_mongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.marcossa.api_mongo.domain.Post;
import com.marcossa.api_mongo.domain.User;
import com.marcossa.api_mongo.repository.PostRepository;
import com.marcossa.api_mongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem!", "Vou viajar para São Paulo! Abraços", maria);
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia!", "Acordei feliz hoje!", maria);
		Post post3 = new Post(null, sdf.parse("25/03/2020"), "Boa tarde!", "Estou estudando!", bob);
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		postRepository.saveAll(Arrays.asList(post1, post2, post3));
	}

}
