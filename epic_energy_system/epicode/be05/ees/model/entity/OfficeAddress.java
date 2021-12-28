package it.epicode.be05.ees.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import it.epicode.be05.ees.model.util.Constant;
import it.epicode.be05.ees.model.util.OfficeType;

@Entity
@Table(name = Constant.TABLE_NAME_3)
public class OfficeAddress {
	
	/*PROPERTY*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bc_generator")
	@SequenceGenerator(name = "bc_generator", sequenceName = "address_seq")
	private long id;
	
	@Column(name = "indirizzo")
	private String nameAddress;
	
	@Column(name = "numero_civico")
	private int civicNumber;
	
	@Column(name = "località")
	private String place;
	
	@Column(name = "cap")
	private int ZIPCode;
	
	@ManyToOne
	private Commune commune;
	
	@Column(name = "tipologia_sede")
	@Enumerated (EnumType.STRING)
	private OfficeType type;
	

	@ManyToOne//(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private BusinessClient businessClient;
	
	/*GETTER AND SETTER*/
	
	public long getId() {
		return id;
	}
	public OfficeAddress setId(long id) {
		this.id = id;
		return this;
	}
	
	public String getNameAddress() {
		return nameAddress;
	}
	public OfficeAddress  setNameAddress(String nameAddress) {
		this.nameAddress = nameAddress;
		return this;
	}
	public int getCivicNumber() {
		return civicNumber;
	}
	public OfficeAddress  setCivicNumber(int civicNumber) {
		this.civicNumber = civicNumber;
		return this;
	}
	public String getPlace() {
		return place;
	}
	public OfficeAddress  setPlace(String place) {
		this.place = place;
		return this;
	}
	public int getZIPCode() {
		return ZIPCode;
	}
	public OfficeAddress  setZIPCode(int zIPCode) {
		ZIPCode = zIPCode;
		return this;
	}
	public OfficeType getType() {
		return type;
	}
	public OfficeAddress setType(OfficeType type) {
		this.type = type;
		return this;
	}

	public Commune getCommune() {
		return commune;
	}
	public OfficeAddress setCommune(Commune commune) {
		this.commune = commune;
		return this;
	}
	public BusinessClient getBusinessClient() {
		return businessClient;
	}
	public OfficeAddress setBusinessClient(BusinessClient businessClient) {
		this.businessClient = businessClient;
		return this;
	}
	
	/*METHOD*/
	
	public static OfficeAddress build() {
		return new OfficeAddress();
	}
	@Override
	public String toString() {
		return "OfficeAddress [id=" + id + ", nameAddress=" + nameAddress + ", civicNumber=" + civicNumber + ", place="
				+ place + ", ZIPCode=" + ZIPCode + ", commune=" + commune + ", type=" + type + ", businessClient="
				+ businessClient + "]";
	}
	
	
	
}
