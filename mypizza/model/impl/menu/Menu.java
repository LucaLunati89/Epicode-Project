package it.mypizza.model.impl.menu;

import java.util.ArrayList;
import java.util.List;

import it.mypizza.model.Pizza;
import it.mypizza.model.impl.food.Drink;
import it.mypizza.model.impl.food.PizzaTopping;
import it.mypizza.model.impl.franchisee.Franchise;



public class Menu {
	private final List<Pizza> menuPizza = new ArrayList<>();
	private final List<PizzaTopping> menuTopping = new ArrayList<>();
	private final List<Drink> menuDrink = new ArrayList<>();
	private final List<Franchise> menuFranchise = new ArrayList<>();
	
	public List<Pizza> getMenuPizza() {
		return menuPizza;
	}
	public List<PizzaTopping> getMenuTopping() {
		return menuTopping;
	}
	public List<Drink> getMenuDrink() {
		return menuDrink;
	}
	public List<Franchise> getMenuFranchise() {
		return menuFranchise;
	}
	@Override
	public String toString() {
		return "Menu [menuPizza=" + menuPizza + ", menuTopping=" + menuTopping + ", menuDrink=" + menuDrink
				+ ", menuFranchise=" + menuFranchise + "]";
	}
	
	
}
