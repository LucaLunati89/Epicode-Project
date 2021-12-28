package it.mypizza.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import it.mypizza.model.impl.food.Drink;
import it.mypizza.model.impl.food.DrinkLemonade;
import it.mypizza.model.impl.food.PizzaHawaiian;
import it.mypizza.model.impl.food.PizzaMargherita;
import it.mypizza.model.impl.food.PizzaSalami;
import it.mypizza.model.impl.food.ToppingCheese;
import it.mypizza.model.impl.food.ToppingHam;
import it.mypizza.model.impl.franchisee.Franchise;
import it.mypizza.model.impl.franchisee.FranchiseMug;
import it.mypizza.model.impl.menu.Menu;

/**
 * @note la classe con l'annotazione Configuration dovrebbe rappresentare un contnainer di Bean
 *  * */
@Configuration
public class MenuConfig {
	
	@Bean
	@Scope("singleton")
	public Menu menu() {

		Menu menu = new Menu();

		menu.getMenuPizza().add(pizzaMargherita());
		menu.getMenuPizza().add(pizzaHawaiian());
		menu.getMenuPizza().add(pizzaSalami());

		menu.getMenuTopping().add(new ToppingCheese(null));
		menu.getMenuTopping().add(new ToppingHam(null));


		menu.getMenuDrink().add(drinkLemonade());
		
		menu.getMenuFranchise().add(franchiseMug());

		return menu;

	}
	
	
	
	@Bean
	public PizzaMargherita pizzaMargherita() {
		return new PizzaMargherita();
	}

	@Bean
	public PizzaHawaiian pizzaHawaiian() {
		return new PizzaHawaiian();
	}

	@Bean
	public PizzaSalami pizzaSalami() {
		return new PizzaSalami();
	}

	@Bean
	public Drink drinkLemonade() {
		return new DrinkLemonade();
	}
	
	@Bean
	public Franchise franchiseMug() {
		return new FranchiseMug();
	}
}
