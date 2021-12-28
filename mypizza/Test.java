package it.mypizza;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;


import it.mypizza.config.MenuConfig;
import it.mypizza.model.MenuItem;
import it.mypizza.model.impl.menu.Menu;
import it.mypizza.model.impl.orders.Note;
import it.mypizza.model.impl.orders.OrderItem;
import it.mypizza.services.OrderService;

@Component
public class Test implements CommandLineRunner {
	
	private static final Logger log = LoggerFactory.getLogger(Test.class);

	private Menu menu;
	private AnnotationConfigApplicationContext ctx;
	

	@Override
	public void run(String... args) throws Exception {
		
		ctx = new AnnotationConfigApplicationContext(MenuConfig.class);
		menu = (Menu) ctx.getBean("menu");
	
		log.info("*************");
		log.info(menu.getMenuPizza().toString());
		
		
		
		MenuItem item1 = menu.getMenuPizza().get(0);
		MenuItem item2 = menu.getMenuPizza().get(1);
		MenuItem item3 = menu.getMenuPizza().get(2);
		Note note1 = new Note().setDescription("Nota1");
		
		List<OrderItem> orderItems = new ArrayList<>();
		
		OrderItem orderItem1 = new OrderItem().setNote(note1).setOrder(item1);
		OrderItem orderItem2 = new OrderItem().setOrder(item2);
		OrderItem orderItem3 = new OrderItem().setOrder(item3);
		
		orderItems.add(orderItem1);
		orderItems.add(orderItem2);
		orderItems.add(orderItem3);
		
		OrderService order1 = new OrderService();
		order1.setnumbPlaceSettings(4);
		order1.setOrderId(0);
		order1.setTable(1, 4);
		order1.setOrderItems(orderItems);
		order1.buildOrder();
		
		OrderService order2 = new OrderService();
		order1.setnumbPlaceSettings(2);
		order1.setOrderId(1);
		order1.setTable(2, 3);
		order1.setOrderItems(orderItems);
		order1.buildOrder();
		
		List<OrderService> orders = new ArrayList<>();
		orders.add(order1);
		orders.add(order2);
	}

}
