package com.kyougaru.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyougaru.workshopmongo.domain.User;
import com.kyougaru.workshopmongo.dto.UserDTO;
import com.kyougaru.workshopmongo.repositories.UserRepository;
import com.kyougaru.workshopmongo.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(String id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User obj) {
		return repository.insert(obj);
	}
	
	public void delete(String id) {
		if (!repository.existsById(id)) {
			throw new ResourceNotFoundException(id);
		}
		repository.deleteById(id);
	}
	
	public User update(User obj) {
		Optional<User> newObj = repository.findById(obj.getId());
		updateData(newObj.orElseThrow(() -> new ResourceNotFoundException(obj.getId())), obj);
		return repository.save(newObj.get());
	}
	
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}

	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
