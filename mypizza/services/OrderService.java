package it.mypizza.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import it.mypizza.config.OrderConfig;
import it.mypizza.model.impl.orders.Order;
import it.mypizza.model.impl.orders.OrderItem;
import it.mypizza.model.impl.orders.OrderStatus;
import it.mypizza.model.impl.table.Table;


public class OrderService {
	
	
	
	private static final Logger log = LoggerFactory.getLogger(OrderService.class);
	private Order order;
	private final double IMPORT_SINGLE_PLACE_SETTING = 1.50d;
	
	
	@Autowired
	private OrderConfig orderConfig = new OrderConfig();
	
	
	private Table table;
	
	/**
	 * @note costruisce un oggetto (Order)*/
	public OrderService() {
		this.order = this.orderConfig.order();
		}
	
	/**
	 * @note registra Id all'oggetto (Order)*/
	public OrderService setOrderId(int orderdId) {
		this.order.setOrderId(orderdId);
		return this;
	}
	
	/**
	 * @note posiziono il numero di coperti all'oggetto (Order)*/
	public OrderService setnumbPlaceSettings(int numbPlaceSettings) {
		this.order.setNumbPlaceSettings(numbPlaceSettings);
		return this;
	};
	
	/**
	 * @note creo un tavolo e l'associo all'oggetto(Order).
	 * Lo stato del tavolo viene impostato come occupato.*/
	public OrderService setTable(int idTable, int maxPlaceSettings) {
		this.table = this.orderConfig.table();
		this.table.setIdTable(idTable)
		.setMaxPlaceSettings(maxPlaceSettings)
		.setState(true);
	
		this.order.setTable(this.table);
		
		return this;
	}
	
	/**
	 * @note creo una lista di (OrderItem) che ha
	 * mandato il "cameriere"*/
	public OrderService setOrderItems(List<OrderItem> orderItems){
		List<OrderItem> order = new ArrayList<>();
		for(OrderItem o : orderItems) {
			order.add(o);
		}
		this.order.setOrderItems(order);
		return this;
	}
	
	/**
	 * @note una volta presi tutti gli (OrderItems)
	 * (Order) è pronto per essere inviato alla "cucina": cambia 
	 * (Order) cambia lo stato e acquisice l'ora di Invio*/
	public void buildOrder() {
		
		this.order.setTotalImport(totalImport());
		this.order.setStatus(OrderStatus.IN_PENDING);
		this.order.setAcquisitionTime(LocalDate.now());
		this.order.setCostForPlaceSetting(IMPORT_SINGLE_PLACE_SETTING);
		log.info("***************************************************");
		log.info("=> L'ordine " + this.order.getOrderId() + " è stato inviato alla Cucina");
		log.info(this.order.toString());
		
	}

	/**
	 * @note calcolo importo totale sull (Order) quando
	 * richiamo il metodo .buildOrder()*/
	private double totalImport() {
		double partialImport = 0;
		double costForPlaceSettings = this.order.getNumbPlaceSettings() * IMPORT_SINGLE_PLACE_SETTING;
		
		for(OrderItem o : this.order.getOrderItems()) {
			partialImport += o.getOrder().getPrice();
		}
		
		double totalImport = partialImport + costForPlaceSettings;
		
		return totalImport;
		
	}
	
	/**
	 * @note questo metodo serve per testare il TH web*/
	public Order buildforTH() {
		
		this.order.setTotalImport(totalImport());
		this.order.setStatus(OrderStatus.IN_PENDING);
		this.order.setAcquisitionTime(LocalDate.now());
		this.order.setCostForPlaceSetting(IMPORT_SINGLE_PLACE_SETTING);
		return this.order;
		
	}
	
	
	
	
	
	
}
