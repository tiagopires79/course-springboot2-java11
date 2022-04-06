package com.educandoweb.course2.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.educandoweb.course2.entities.User;
import com.educandoweb.course2.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResourse {
	
	@Autowired
	UserService service;

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
	@PostMapping//(value = "/{user}")
	public ResponseEntity<User> insert(@RequestBody User user){
		user = service.insert(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest() // para retornar http 201 de criação de novo recurso
				  .path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).body(user); // retornando novo recurso criado
	}
}
