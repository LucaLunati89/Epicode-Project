package it.mypizza.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import it.mypizza.config.MenuConfig;
import it.mypizza.model.impl.food.PizzaFamilySize;
import it.mypizza.model.impl.food.PizzaMargherita;
import it.mypizza.model.impl.food.ToppingCheese;
import it.mypizza.model.impl.menu.Menu;



public class MenuPrintService {

	private Menu menu;
	private AnnotationConfigApplicationContext ctx;

	public MenuPrintService() {
		// ctx = new MenuConfig()
		ctx = new AnnotationConfigApplicationContext(MenuConfig.class);
		menu = (Menu) ctx.getBean("menu");

	}

	public void printMenu() {
		System.out.println("******* Menu *******");
		System.out.println("PIZZA");
		menu.getMenuPizza().forEach(p -> System.out.println(p.getMenuItemLine()));
		System.out.println();

		System.out.println("DRINK");
		menu.getMenuDrink().forEach(p -> System.out.println(p.getMenuItemLine()));

		System.out.println();

		System.out.println("FRANCHISE");
		menu.getMenuFranchise().forEach(p -> System.out.println(p.getMenuItemLine()));

	}

	public void testTopping() {

		PizzaMargherita pizza = ctx.getBean(PizzaMargherita.class);
		
		
		ToppingCheese topping1 = new ToppingCheese(pizza);

		System.out.println(topping1.getName());
		
		ToppingCheese topping2 = new ToppingCheese(topping1);

		System.out.println(topping2.getName());
		
		PizzaFamilySize toppingBig = new PizzaFamilySize(topping2);
		System.out.println(toppingBig.getName());
		System.out.println(toppingBig.getPrice());


		
	}
	
	/**
	 * @note servizio per stampare menu pizza su web*/
	public List<String> printPizzaItems() {
		ctx = new AnnotationConfigApplicationContext(MenuConfig.class);
		menu = (Menu) ctx.getBean("menu");
		List<String> myMenu = new ArrayList<>();
		menu.getMenuPizza().forEach(p -> myMenu.add((p.getMenuItemLine())));
		return myMenu;
	}
	
	/**
	 * @note servizio per stampare menu drink su web*/
	public List<String> printDrinkItems() {
		ctx = new AnnotationConfigApplicationContext(MenuConfig.class);
		menu = (Menu) ctx.getBean("menu");
		List<String> myMenu = new ArrayList<>();
		menu.getMenuDrink().forEach(p -> myMenu.add((p.getMenuItemLine())));
		return myMenu;
		
	}
	
	/**
	 * @note servizio per stampare menu franchise su web*/
	public List<String> printFranchiseItems() {
		ctx = new AnnotationConfigApplicationContext(MenuConfig.class);
		menu = (Menu) ctx.getBean("menu");
		List<String> myMenu = new ArrayList<>();
		menu.getMenuFranchise().forEach(p -> myMenu.add((p.getMenuItemLine())));
		return myMenu;
	}
}
