package it.epicode.be05.ees.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import it.epicode.be05.ees.model.util.Constant;

@Entity
@Table(name = Constant.TABLE_NAME_4)
public class Invoice {
	
	/*PROPERTY*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bc_generator")
	@SequenceGenerator(name = "bc_generator", sequenceName = "invoice_seq")
	private long id;
	
	@Column(name = "anno")
	private int year;
	@Column(name = "data")
	private LocalDate date;
	@Column(name = "importo")
	private BigDecimal amount;
	@Column(name = "numero", unique = true)
	private int number;
	
	@OneToOne//(cascade = CascadeType.ALL)
	private InvoiceState state;
	
	@ManyToOne //(cascade = CascadeType.ALL)
	private BusinessClient businessClient;
	
	/*GETTER AND SETTER*/
	
	public int getYear() {
		return year;
	}
	public Invoice setYear(int year) {
		this.year = year;
		return this;
	}
	public LocalDate getDate() {
		return date;
	}
	public Invoice setDate(LocalDate date) {
		this.date = date;
		return this;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public Invoice setAmount(BigDecimal amount) {
		this.amount = amount;
		return this;
	}
	public int getNumber() {
		return number;
	}
	public Invoice setNumber(int number) {
		this.number = number;
		return this;
	}
	public InvoiceState getState() {
		return state;
	}
	public Invoice setState(InvoiceState state) {
		this.state = state;
		return this;
	}
	
	public BusinessClient getBusinessClient() {
		return businessClient;
	}
	public Invoice setBusinessClient(BusinessClient businessClient) {
		this.businessClient = businessClient;
		return this;
	}
	
	public long getId() {
		return id;
	}
	public Invoice setId(long id) {
		this.id = id;
		return this;
	}
	
	/*METHOD*/
	
	public static Invoice build() {
		return new Invoice();
	}
	
	
	
}
