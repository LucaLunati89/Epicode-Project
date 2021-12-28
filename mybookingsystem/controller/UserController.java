package it.mybookingsystem.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


import it.mybookingsystem.model.User;
import it.mybookingsystem.service.interfaces.UserService;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	UserService service;
	
	@RequestMapping("create")
	@PostMapping
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<User> create(@RequestBody User user){
		service.create(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@GetMapping("read/users")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
	public ResponseEntity<Page<User>> readPage(
			@RequestParam(name="page", required = false, defaultValue = "0")int pageNumber
			,@RequestParam(required = false, defaultValue = "3")int size){
		var page = PageRequest.of(pageNumber, size);
		return new ResponseEntity<Page<User>>(service.readAll(page), HttpStatus.OK);
		
	}
	
	@GetMapping("read/user/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<User> getById(@PathVariable(required = true) Long id){
		Optional<User> result = Optional.ofNullable(service.readById(id));
		if(result.isPresent()) {
			return new ResponseEntity<>(result.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@DeleteMapping("delete/user/{id}")
	public ResponseEntity<HttpStatus> deleteById(@PathVariable(required = true) Long id){
		//try {
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		//}catch(Exception e) {
			//throw new ResponseEntity<>(HttpStatus.METHOD_FAILURE);
		//}
	}
}
