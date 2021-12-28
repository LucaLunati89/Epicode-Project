package it.epicode.be05.ees.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import it.epicode.be05.ees.model.util.Constant;

@Entity
@Table(name = Constant.TABLE_NAME_2)
public class AccountManager {

	/*PROPERTY*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "am_generator")
	@SequenceGenerator(name = "am_generator", sequenceName = "am_seq")
	private long id;
	
	@Column(name = "nome")
	private String firstName;
	
	@Column(name = "cognome")
	private String lastName;
	
	@Column(name = "numero_di_telefono")
	private String phoneNumber;
	
	@Column(name = "email")
	private String email;
	
	@OneToOne//(cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	private BusinessClient businessClient;
	
	/*GETTER AND SETTER*/
	
	public long getId() {
		return id;
	}
	public AccountManager setId(long id) {
		this.id = id;
		return this;
	}
	public String getFirstName() {
		return firstName;
	}
	public AccountManager setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	public String getLastName() {
		return lastName;
	}
	public AccountManager setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public AccountManager setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}

	public String getEmail() {
		return email;
	}
	public AccountManager setEmail(String email) {
		this.email = email;
		return this;
	}
	
	public BusinessClient getBusinessClient() {
		return businessClient;
	}
	public AccountManager setBusinessClient(BusinessClient businessClient) {
		this.businessClient = businessClient;
		return this;
	}
	
	/*METHOD*/
	
	public static AccountManager build() {
		return new AccountManager();
	}
	@Override
	public String toString() {
		return "AccountManager [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber="
				+ phoneNumber + ", email=" + email + ", businessClient=" + businessClient + "]";
	}
	
	
	
}
