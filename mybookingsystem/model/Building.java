package it.mybookingsystem.model;


import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import it.mybookingsystem.config.StringAttributeConverter;
import it.mybookingsystem.util.City;

@Entity(name = "buildings")
@Table(name = "buildings")
public class Building {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "address")
	private String address;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "city")
	private City city;
	
	@Convert(converter = StringAttributeConverter.class)
	private String code;
	
	public long getId() {
		return id;
	}

	public Building setId(long id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Building setName(String name) {
		this.name = name;
		return this;
	}

	public String getAddress() {
		return address;
	}

	public Building setAddress(String address) {
		this.address = address;
		return this;
	}

	public City getCity() {
		return city;
	}

	public Building setCity(City city) {
		this.city = city;
		return this;
	}

	public String getCode() {
		return code;
	}

	public Building setCode(String code) {
		this.code = code;
		return this;
	}
	
	public static Building builder() {
		return new Building();
	}

	@Override
	public String toString() {
		return "Building [id=" + id + ", name=" + name + ", address=" + address + ", city=" + city + ", code=" + code
				+ "]";
	}
	

	
	
	
}
