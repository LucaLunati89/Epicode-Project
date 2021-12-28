package it.epicode.be05.ees.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

/*
 * CLASSE INVOICE DTO: VIENE USATA PER NON AVERE ID, RIPETIZIONE DEL CLIENTE BUSINESS(MA SOLO NOME)
 * ,RIPETIZIONE DI UNO STATO (MA SOLO ATTIRBUTO) IN FASE DI LETTURA*/
public class InvoiceDTO {

	private int year;
	private LocalDate date;
	private BigDecimal amount;
	private int number;
	private String state;
	private String businessClientName;

	public int getYear() {
		return year;
	}
	public InvoiceDTO setYear(int year) {
		this.year = year;
		return this;
	}
	public LocalDate getDate() {
		return date;
	}
	public InvoiceDTO setDate(LocalDate date) {
		this.date = date;
		return this;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public InvoiceDTO setAmount(BigDecimal amount) {
		this.amount = amount;
		return this;
	}
	public int getNumber() {
		return number;
	}
	public InvoiceDTO setNumber(int number) {
		this.number = number;
		return this;
	}

	public static InvoiceDTO build() {
		return new InvoiceDTO();
	}
	public String getState() {
		return state;
	}
	public InvoiceDTO setState(String state) {
		this.state = state;
		return this;
	}
	public String getBusinessClientName() {
		return businessClientName;
	}
	public InvoiceDTO setBusinessClientName(String businessClientName) {
		this.businessClientName = businessClientName;
		return this;

	}
}
