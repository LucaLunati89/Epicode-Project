package it.mypizza.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import it.mypizza.model.impl.orders.Order;
import it.mypizza.services.OrderPrintService;


@Controller
public class OrdersController {

	//presenta dati da modificare all'utente
	@GetMapping
	@RequestMapping("/CheckOrders")
	public ModelAndView OrderForm() {
		ModelAndView mv = new ModelAndView("menu/ordersForm");
		Order order = new Order();
		mv.addObject("orderNumb", order);
		return mv;
	}
	
	//elaborare dati modificati
	@GetMapping("orderNumb")
	public ModelAndView getOrder(@ModelAttribute Order model) {
		ModelAndView mv = new ModelAndView("menu/ordersNumb");
		OrderPrintService ops =new OrderPrintService();
		List<Order> orders = ops.myOrders();
		for(Order o :orders) {
			if(o.getOrderId() == model.getOrderId()) {
				mv.addObject("test", o);
			}
			else {
				mv.addObject("test", "Non sono presenti ordini con questo Id");
			}
		}
		return mv;
	}
	
}
