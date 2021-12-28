package it.mypizza.model.impl.orders;

import it.mypizza.model.MenuItem;

public class OrderItem {

	private MenuItem orderItem;
	private Note note;
	
	public MenuItem getOrder() {
		return orderItem;
	}
	public OrderItem setOrder(MenuItem order) {
		this.orderItem = order;
		return this;
	}
	public Note getNote() {
		return note;
	}
	public OrderItem setNote(Note note) {
		this.note = note;
		return this;
	}
	@Override
	public String toString() {
		return "OrderItem [orderItem=" + orderItem + ", note=" + note + "]";
	}
	
	
}

