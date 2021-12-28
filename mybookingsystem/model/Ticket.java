package it.mybookingsystem.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "tickets")
@Table(name = "tickets")
public class Ticket {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@Column(name = "emission_date")
	private LocalDate emissionDate;
	
	@Column(name = "expiration_date")
	private LocalDate expirationDate;
	
	@ManyToOne
	private User user;
	
	@OneToOne
	private WorkStation workStation;

	public long getId() {
		return id;
	}

	public Ticket setId(long id) {
		this.id = id;
		return this;
	}

	public LocalDate getEmissionDate() {
		return emissionDate;
	}

	public Ticket setEmissionDate(LocalDate emissionDate) {
		this.emissionDate = emissionDate;
		return this;
	}

	public LocalDate getExpirationDate() {
		return expirationDate;
	}

	public Ticket setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
		return this;
	}

	public User getUser() {
		return user;
	}

	public Ticket setUser(User user) {
		this.user = user;
		return this;
	}
	
	public WorkStation getWorkStation() {
		return workStation;
	}

	public Ticket setWorkStation(WorkStation workStation) {
		this.workStation = workStation;
		return this;
	}
	
	public static Ticket builder() {
		return new Ticket();
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", emissionDate=" + emissionDate + ", expirationDate=" + expirationDate + ", user="
				+ user + ", workStation=" + workStation + "]";
	}
	
	
	
}
