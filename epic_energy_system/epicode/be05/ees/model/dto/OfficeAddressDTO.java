package it.epicode.be05.ees.model.dto;

import it.epicode.be05.ees.model.util.OfficeType;

/*
 * CLASSE OFFICE ADDRESS DTO: VIENE USATA PER NON AVERE ID O RIPETIZIONE DEL CLIENTE BUSINESS IN FASE DI LETTURA*/
public class OfficeAddressDTO {

	private String nameAddress;
	private int civicNumber;
	private String place;
	private int ZIPCode;
	private String communeName;
	private String provinceName;
	private OfficeType type;
	public String getNameAddress() {
		return nameAddress;
	}
	public OfficeAddressDTO setNameAddress(String nameAddress) {
		this.nameAddress = nameAddress;
		return this;
	}
	public int getCivicNumber() {
		return civicNumber;
	}
	public OfficeAddressDTO setCivicNumber(int civicNumber) {
		this.civicNumber = civicNumber;
		return this;
	}
	public String getPlace() {
		return place;
	}
	public OfficeAddressDTO setPlace(String place) {
		this.place = place;
		return this;
	}
	public int getZIPCode() {
		return ZIPCode;
	}
	public OfficeAddressDTO setZIPCode(int zIPCode) {
		ZIPCode = zIPCode;
		return this;
	}
	public String getCommuneName() {
		return communeName;
	}
	public OfficeAddressDTO setCommuneName(String communeName) {
		this.communeName = communeName;
		return this;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public OfficeAddressDTO setProvinceName(String provinceName) {
		this.provinceName = provinceName;
		return this;
	}
	
	public OfficeType getType() {
		return type;
	}
	public OfficeAddressDTO setType(OfficeType type) {
		this.type = type;
		return this;
	}
	
	public static OfficeAddressDTO build() {
		return new OfficeAddressDTO();
	}
	
	
	
}
