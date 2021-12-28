package it.mypizza.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import it.mypizza.services.OrderService;

@Configuration
public class OrderServiceConfig {

	@Bean
	@Scope("prototype")
	public OrderService orderService() {
		
		OrderService orderService = new OrderService();
		return orderService;
	}
}
