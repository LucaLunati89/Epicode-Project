package it.mypizza.model.impl.food;

import it.mypizza.model.Pizza;

public class PizzaTopping implements Pizza{

	private Pizza pizza;
	private String name;
	private Double price;
	private Double calories;	
	
	public PizzaTopping(Pizza pizza, String name, Double price, Double calories) {
		this.pizza = pizza;
		this.name = name;
		this.price = price;
		this.calories = calories;
	}
	
	Pizza getPizza() {
		return pizza;
	}


	void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}


	void setName(String name) {
		this.name = name;
	}


	void setPrice(Double price) {
		this.price = price;
	}


	void setCalories(Double calories) {
		this.calories = calories;
	}
	
	@Override
	public String getName() {
		return this.pizza.getName() + " + " + this.name;
	}

	@Override
	public Double getPrice() {
		return this.pizza.getPrice() + this.price;
	}

	@Override
	public Double getCalories() {
		return this.pizza.getCalories() + this.calories;
	}
	
	public String getMenuItemLine() {
		return this.name + " - calories: " + calories + " - price: " + price;	
	}

	@Override
	public String toString() {
		return "PizzaTopping [pizza=" + pizza + ", name=" + name + ", price=" + price + ", calories=" + calories + "]";
	}


	

}
