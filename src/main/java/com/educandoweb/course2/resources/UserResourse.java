package com.educandoweb.course2.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.educandoweb.course2.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResourse {

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
	//public ResponseEntity<User> findAll() {
		List<User> list = new ArrayList<>();
		
		User u = new User(1L, "Maria", "maria@gmail.com", "62991762954", "12345");
		User us = new User(2L, "Maria", "maria@gmail.com", "62991762954", "12345");
		User use = new User(3L, "Maria", "maria@gmail.com", "62991762954", "12345");
		User u2 = new User(1L, "Maria", "maria@gmail.com", "62991762954", "12345");
		User us2 = new User(2L, "Maria", "maria@gmail.com", "62991762954", "12345");
		User use2 = new User(3L, "Maria", "maria@gmail.com", "62991762954", "12345");
		
		list.add(u);
		list.add(us);
		list.add(use);
		list.add(u2);
		list.add(us2);
		list.add(use2);
		
		//return ResponseEntity.ok().body(u);
		return ResponseEntity.ok().body(list);
	}
}
