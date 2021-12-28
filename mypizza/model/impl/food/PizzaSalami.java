package it.mypizza.model.impl.food;

public class PizzaSalami extends PizzaBase {
	
	public PizzaSalami() {
		super("Pizza Salami (tomato, cheese, salami)", 5.99, 1160d);
	}

	@Override
	public String toString() {
		return "PizzaSalami [calories=" + getCalories() + ", name=" + getName() + ", price=" + getPrice()
				+ "]";
	}
	
	
}
