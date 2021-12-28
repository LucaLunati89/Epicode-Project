package it.mypizza.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import it.mypizza.services.MenuPrintService;

@Controller
@RequestMapping("/myPizza")
public class MenuController {

	@GetMapping("menu")
	public ModelAndView printMenu() {
		
		MenuPrintService mpc = new MenuPrintService();
		List<String> menuPizza = mpc.printPizzaItems();
		List<String> menuDrink = mpc.printDrinkItems();
		List<String> menuFranchise = mpc.printFranchiseItems();
		ModelAndView mv = new ModelAndView("menu/myMenu");
		mv.addObject("pizzaItems", menuPizza);
		mv.addObject("drinkItems", menuDrink);
		mv.addObject("franchiseItems", menuFranchise);
		return mv;
		
	}
}
