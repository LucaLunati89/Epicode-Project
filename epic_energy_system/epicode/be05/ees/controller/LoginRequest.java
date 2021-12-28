package it.epicode.be05.ees.controller;



public class LoginRequest {

	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public LoginRequest setUsername(String username) {
		this.username = username;
		return this;
	}
	public String getPassword() {
		return password;
	}
	public LoginRequest setPassword(String password) {
		this.password = password;
		return this;
	}
}
