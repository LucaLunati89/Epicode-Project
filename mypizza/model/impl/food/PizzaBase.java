package it.mypizza.model.impl.food;

import it.mypizza.model.Pizza;

public abstract class PizzaBase implements Pizza{
	
	private final String name;
	private final Double price;
	private final Double calories;
	
	public PizzaBase(String name, Double price, Double calories) {
		this.name = name;
		this.price = price;
		this.calories = calories;
	}
	
	@Override
	public Double getCalories() {
		return this.calories;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public Double getPrice() {
		return this.price;
	}
	
	public String getMenuItemLine() {
		return this.name + " - calories: " + calories + " - price: " + price;	
	}
}
