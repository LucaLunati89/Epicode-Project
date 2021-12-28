package it.mypizza.model.impl.food;

import it.mypizza.model.FoodItem;

public class Drink implements FoodItem {

	private String name;
	private Double price;
	private Double calories;
	
	

	public Drink(String name, Double price, Double calories) {
		this.name = name;
		this.price = price;
		this.calories = calories;
	}

	public String getMenuItemLine() {
		return this.name + " - calories: " + calories + " - price: " + price;	
	}

	public Drink setName(String name) {
		this.name = name;
		return this;
	}


	public Drink setPrice(Double price) {
		this.price = price;
		return this;
	}


	public Drink setCalories(Double calories) {
		this.calories = calories;
		return this;
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
	public Double getCalories() {
		return this.calories;
	}

	@Override
	public String toString() {
		return "Drink [name=" + name + ", price=" + price + ", calories=" + calories + "]";
	}


	
}
