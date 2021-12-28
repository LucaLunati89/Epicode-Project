package it.mypizza.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import it.mypizza.model.impl.orders.Order;
import it.mypizza.model.impl.table.Table;

/**
 * @note Container per la creazione di un ordine*/
@Configuration
public class OrderConfig {
	
	/**
	 * @note ritorna un oggetto (Order)*/
	@Bean
	@Scope("prototype")
	public Order order() {
		Order order = new Order();
		return order;
	}
	
	/**
	 * @note ritorna un oggetto (Table)*/
	@Bean
	@Scope("prototype")
	public Table table() {
		Table table = new Table();
		return table;
	}
	
	
}
