package it.epicode.be05.ees.model.dto;

/*
 * CLASSE ACCOUNT BUSINESS CLIENT DTO: VIENE USATA PER NON AVERE ID IN FASE DI LETTURA*/
import java.time.LocalDate;

import it.epicode.be05.ees.model.util.ClientType;

public class BusinessClientDTO {

	private String businessName;
	private ClientType type;
	private long VATNumber;
	private LocalDate firstContact;
	private LocalDate lastContact;
	private long annualRevenue;
	
	public String getBusinessName() {
		return businessName;
	}
	public BusinessClientDTO setBusinessName(String businessName) {
		this.businessName = businessName;
		return this;
	}
	public ClientType getType() {
		return type;
	}
	public BusinessClientDTO setType(ClientType type) {
		this.type = type;
		return this;
	}
	public long getVATNumber() {
		return VATNumber;
	}
	public BusinessClientDTO setVATNumber(long vATNumber) {
		VATNumber = vATNumber;
		return this;
	}
	public LocalDate getFirstContact() {
		return firstContact;
	}
	public BusinessClientDTO setFirstContact(LocalDate firstContact) {
		this.firstContact = firstContact;
		return this;
	}
	public LocalDate getLastContact() {
		return lastContact;
	}
	public BusinessClientDTO setLastContact(LocalDate lastContact) {
		this.lastContact = lastContact;
		return this;
	}
	public long getAnnualRevenue() {
		return annualRevenue;
	}
	public BusinessClientDTO setAnnualRevenue(long annualRevenue) {
		this.annualRevenue = annualRevenue;
		return this;
	}
	
	public static BusinessClientDTO build() {
		return new BusinessClientDTO();
	}
	
}
