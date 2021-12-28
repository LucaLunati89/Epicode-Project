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

import it.epicode.be05.ees.model.util.Constant;



@Entity(name = Constant.TABLE_NAME_8)
public class BusinessClientContact{

	/*PROPERTY*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bc_generator")
	@SequenceGenerator(name = "bc_generator", sequenceName = "bc_contact_seq")
	private long id;
	
	@Column(name = "numero_di_telefono")
	private String phoneNumber;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "pec")
	private String pec;
	
	@OneToOne//(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private BusinessClient businessClient;

	/*GETTER AND SETTER*/
	public long getId() {
		return id;
	}
	public BusinessClientContact setId(long id) {
		this.id = id;
		return this;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public BusinessClientContact setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}
	
	public String getEmail() {
		return email;
	}
	public BusinessClientContact setEmail(String email) {
		this.email = email;
		return this;
	}
	
	public String getPec() {
		return pec;
	}

	public BusinessClientContact setPec(String pec) {
		this.pec = pec;
		return this;
	}
	public BusinessClient getBusinessClient() {
		return businessClient;
	}
	public BusinessClientContact setBusinessClient(BusinessClient businessClient) {
		this.businessClient = businessClient;
		return this;
	}
	/*METHOD*/
	
	public static BusinessClientContact build() {
		return new BusinessClientContact();
	}
	
	@Override
	public String toString() {
		return "BusinessClientContact [id=" + id + ", phoneNumber=" + phoneNumber + ", email=" + email + ", pec=" + pec
				+ ", businessClient=" + businessClient + "]";
	}
	
	

}
