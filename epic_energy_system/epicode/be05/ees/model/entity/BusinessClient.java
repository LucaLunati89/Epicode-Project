package it.epicode.be05.ees.model.entity;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import it.epicode.be05.ees.model.util.ClientType;
import it.epicode.be05.ees.model.util.Constant;

@Entity
@Table(name = Constant.TABLE_NAME_1)
public class BusinessClient {

	/*PROPERTY*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bc_generator")
	@SequenceGenerator(name = "bc_generator", sequenceName = "bc_seq")
	private long id;
	
	@Column(name = "ragione_sociale", length = 50)
	private String businessName;
	
	@Column(name = "tipologia_azienda")
	@Enumerated (EnumType.STRING)
	private ClientType type;
	
	@Column(name = "partita_iva", length = 11)
	private long VATNumber;
	
	@Column(name = "data_inserimento")
	private LocalDate firstContact;
	
	@Column(name = "data_ultimo_contatto")
	private LocalDate lastContact;
	
	@Column(name = "fatturato_annuo")
	private long annualRevenue;
	
	
	/*GETTER AND SETTER*/
	
	public long getId() {
		return id;
	}
	public BusinessClient setId(long id) {
		this.id = id;
		return this;
	}
	
	public String getBusinessName() {
		return businessName;
	}

	public BusinessClient setBusinessName(String businessName) {
		this.businessName = businessName;
		return this;
	}
	
	public ClientType getType() {
		return type;
	}
	
	public BusinessClient setType(ClientType type) {
		this.type = type;
		return this;
	}
	
	public long getVATNumber() {
		return VATNumber;
	}
	
	public BusinessClient setVATNumber(long vATNumber) {
		VATNumber = vATNumber;
		return this;
	}
	
	public LocalDate getFirstContact() {
		return firstContact;
	}
	public BusinessClient setFirstContact(LocalDate firsContact) {
		this.firstContact = firsContact;
		return this;
		
	}
	public LocalDate getLastContact() {
		return lastContact;
	}
	public BusinessClient setLastContact(LocalDate lastContact) {
		this.lastContact = lastContact;
		return this;
	}
	public long getAnnualRevenue() {
		return annualRevenue;
	}
	public BusinessClient setAnnualRevenue(long annualRevenue) {
		this.annualRevenue = annualRevenue;
		return this;
	}

	/*METHOD*/
	
	public static BusinessClient build(){
		return new BusinessClient();
	}
	@Override
	public String toString() {
		return "BusinessClient [id=" + id + ", businessName=" + businessName + ", type=" + type + ", VATNumber="
				+ VATNumber + ", firstContact=" + firstContact + ", lastContact=" + lastContact + ", annualRevenue="
				+ annualRevenue + "]";
	}
	
	
	
	
}
