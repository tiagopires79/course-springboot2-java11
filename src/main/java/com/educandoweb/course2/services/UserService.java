package com.educandoweb.course2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course2.entities.User;
import com.educandoweb.course2.repositories.UserRepository;
import com.educandoweb.course2.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User user) {
		return repository.save(user); // por padrão já retorna o objeto salvo
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public User update(Long id, User userUpdated) {
	    User entity = (repository.findById(id)).orElseThrow(() -> new ResourceNotFoundException(id)); // Retorna um Optional, e, portanto, precisa ser convertido em User com o .get
		updateData(entity,userUpdated);
		return repository.save(entity);	
	}

	private void updateData(User entity, User userUpdated) {
		entity.setName(userUpdated.getName());
		entity.setEmail(userUpdated.getEmail());
		entity.setPhone(userUpdated.getPhone());
	}
}
