package it.mypizza.model.impl.food;

public class PizzaMargherita extends PizzaBase {
	
	public PizzaMargherita() {
		super("Pizza Margherita (tomato, cheese)", 4.99, 1104d);
	}

	@Override
	public String toString() {
		return "PizzaMargherita [calories=" + getCalories() + ", name=" + getName() + ", price()="
				+ getPrice() + "]";
	}
	
	
}
