package it.mybookingsystem.controller;

public class LoginResponse {

	private String token;

	public String getToken() {
		return token;
	}

	
	public LoginResponse() {
		super();
	}


	public LoginResponse(String token) {
		super();
		this.token = token;
	}


	public LoginResponse setToken(String token) {
		this.token = token;
		return this;
	}
	
	
}
