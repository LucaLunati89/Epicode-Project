package it.mypizza.model.impl.orders;

import java.time.LocalDate;
import java.util.List;

import it.mypizza.model.impl.table.Table;

public class Order {

	private int orderId;
	private int numbPlaceSettings;
	private Table table;
	private List<OrderItem> orderItems;
	private OrderStatus status;
	private LocalDate acquisitionTime;
	private double totalImport;
	private double costForPlaceSetting;


	public Order(int i) {

	}

	public Order() {

	}
	
	public int getNumbPlaceSettings() {
		return numbPlaceSettings;
	}
	public Order setNumbPlaceSettings(int numbPlaceSettings) {
		this.numbPlaceSettings = numbPlaceSettings;
		return this;
	}
	public Table getTable() {
		return table;
	}
	public Order setTable(Table table) {
		this.table = table;
		return this;
	}
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public Order setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
		return this;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public Order setStatus(OrderStatus status) {
		this.status = status;
		return this;
	}
	LocalDate getAcquisitionTime() {
		return acquisitionTime;
	}
	public Order setAcquisitionTime(LocalDate acquisitionTime) {
		this.acquisitionTime = acquisitionTime;
		return this;
	}
	public double getTotalImport() {
		return totalImport;
	}
	public Order setTotalImport(double totalImport) {
		this.totalImport = totalImport;
		return this;
	}
	public double getCostForPlaceSetting() {
		return costForPlaceSetting;
	}
	public Order setCostForPlaceSetting(double costForPlaceSetting) {
		this.costForPlaceSetting = costForPlaceSetting;
		return this;
	}

	public int getOrderId() {
		return orderId;
	}
	public Order setOrderId(int orderId) {
		this.orderId = orderId;
		return this;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", numbPlaceSettings=" + numbPlaceSettings + ", table=" + table
				+ ", orderItems=" + orderItems + ", status=" + status + ", acquisitionTime=" + acquisitionTime
				+ ", totalImport=" + totalImport + ", costForPlaceSetting=" + costForPlaceSetting + "]";
	}






}
