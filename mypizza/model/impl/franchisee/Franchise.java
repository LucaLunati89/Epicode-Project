package it.mypizza.model.impl.franchisee;

import it.mypizza.model.MenuItem;

public class Franchise implements MenuItem {

	
	private String name;
	private Double price;
	


	public Franchise(String name, Double price) {
		this.setName(name);
		this.setPrice(price);
	}

	void setName(String name) {
		this.name = name;
	}

	void setPrice(Double price) {
		this.price = price;
	}
	
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public Double getPrice() {
		return this.price;
	}

	@Override
	public String getMenuItemLine() {
		return this.name + " - price: " + this.price;
	}

	@Override
	public String toString() {
		return "Franchise [name=" + name + ", price=" + price + "]";
	}

	
	
}
