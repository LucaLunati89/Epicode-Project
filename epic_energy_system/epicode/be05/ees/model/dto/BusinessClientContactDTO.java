package it.epicode.be05.ees.model.dto;

/*
 * CLASSE BUSINESS CLIENT CONTACT DTO: VIENE USATA PER NON AVERE ID O RIPETIZIONE DEL CLIENTE BUSINESS IN FASE DI LETTURA*/
public class BusinessClientContactDTO {

	private String phoneNumber;
	private String email;
	private String pec;
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public BusinessClientContactDTO setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public BusinessClientContactDTO setEmail(String email) {
		this.email = email;
		return this;
	}
	public String getPec() {
		return pec;
	}
	public BusinessClientContactDTO setPec(String pec) {
		this.pec = pec;
		return this;
	}
	
	public static BusinessClientContactDTO build() {
		return new BusinessClientContactDTO();
	}
	
}
