package it.mypizza.model.impl.food;

public class PizzaHawaiian extends PizzaBase{

	public PizzaHawaiian() {
		super("Pizza Hawaiian (tomato, cheese, ham, pineapple)", 6.49, 1024d);
	}

	@Override
	public String toString() {
		return "PizzaHawaiian [calories=" + getCalories() + ", name=" + getName() + ", price="
				+ getPrice() + "]";
	}
	
	
}
