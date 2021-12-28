package it.epicode.be05.ees.model.dto;

/*
 * CLASSE ACCOUNT MANAGER DTO: VIENE USATA PER NON AVERE ID O RIPETIZIONE DEL CLIENTE BUSINESS IN FASE DI LETTURA*/
public class AccountManagerDTO {

	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	
	
	public String getFirstName() {
		return firstName;
	}
	public AccountManagerDTO setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	public String getLastName() {
		return lastName;
	}
	public AccountManagerDTO setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public AccountManagerDTO setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public AccountManagerDTO setEmail(String email) {
		this.email = email;
		return this;
	}
	
	public static AccountManagerDTO build() {
		return new AccountManagerDTO();
	}
	
	
}
