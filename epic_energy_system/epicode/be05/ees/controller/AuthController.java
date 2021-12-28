package it.epicode.be05.ees.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.epicode.be05.ees.config.JwtUtils;


@RestController
@RequestMapping("/api")
public class AuthController {
	@Autowired
	private AuthenticationManager auth;
	
	@Autowired
	JwtUtils jwt;
	
	@PostMapping("login")
	public ResponseEntity<?> login(@RequestBody LoginRequest login){
		var a = auth.authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));
		a.getAuthorities();
		SecurityContextHolder.getContext().setAuthentication(a);
		var token = jwt.generateJwtToken(a);
		return new ResponseEntity<>(new LoginResponse().setToken(token), HttpStatus.OK);
	}
}
