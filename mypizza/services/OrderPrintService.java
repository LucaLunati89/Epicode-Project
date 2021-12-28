package it.mypizza.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import it.mypizza.config.MenuConfig;
import it.mypizza.config.OrderServiceConfig;
import it.mypizza.model.MenuItem;
import it.mypizza.model.impl.menu.Menu;
import it.mypizza.model.impl.orders.Note;
import it.mypizza.model.impl.orders.Order;
import it.mypizza.model.impl.orders.OrderItem;

public class OrderPrintService {

	
	private Menu menu;
	//private OrderService orderService;
	private AnnotationConfigApplicationContext ctx;
	
	//serve solo per testare TLeaf
	public List<Order> myOrders() {
		
		ctx = new AnnotationConfigApplicationContext(MenuConfig.class);
		menu = (Menu) ctx.getBean("menu");
		
		MenuItem item1 = menu.getMenuPizza().get(0);
		MenuItem item2 = menu.getMenuPizza().get(1);
		MenuItem item3 = menu.getMenuPizza().get(2);
		Note note1 = new Note().setDescription("Nota1");
		
		/*
		ctx = new AnnotationConfigApplicationContext(OrderServiceConfig.class);
		orderService = (OrderService) ctx.getBean("orderService");*/
		
		List<OrderItem> orderItems = new ArrayList<>();
		
		OrderItem orderItem1 = new OrderItem().setNote(note1).setOrder(item1);
		OrderItem orderItem2 = new OrderItem().setOrder(item2);
		OrderItem orderItem3 = new OrderItem().setOrder(item3);
		
		orderItems.add(orderItem1);
		orderItems.add(orderItem2);
		orderItems.add(orderItem3);
		
		/*
		orderService.setnumbPlaceSettings(4);
		orderService.setOrderId(3);
		orderService.setTable(1, 4);
		orderService.setOrderItems(orderItems);
		Order orderNumb3 = orderService.buildforTH();*/
		
		OrderService order1 = new OrderService();
		order1.setnumbPlaceSettings(4);
		order1.setOrderId(1);
		order1.setTable(1, 4);
		order1.setOrderItems(orderItems);
		Order orderNumb1 = order1.buildforTH();
		
		OrderService order2 = new OrderService();
		order2.setnumbPlaceSettings(2);
		order2.setOrderId(2);
		order2.setTable(2, 3);
		order2.setOrderItems(orderItems);
		Order orderNumb2 = order2.buildforTH();
	
		List<Order> orders = new ArrayList<>();
		orders.add(orderNumb1);
		orders.add(orderNumb2);
		
		return orders;
	}
	
}
