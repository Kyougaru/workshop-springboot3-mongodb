package com.kyougaru.workshopmongo.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kyougaru.workshopmongo.domain.User;

@Service
public class UserService {
	
	public List<User> findAll() {
		List<User> users = new ArrayList<>();
		User maria = new User("1", "Maria Brown", "maria@gmail.com");
		User alex = new User("2", "Alex Green", "alex@gmail.com");
		users.addAll(Arrays.asList(maria, alex));
		return users;
	}
}
