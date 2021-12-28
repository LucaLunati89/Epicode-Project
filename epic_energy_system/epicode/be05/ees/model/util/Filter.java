package it.epicode.be05.ees.model.util;

//OGGETTO FILTRO !POTEVI EVITARLO SE USAI SUBITO I METODI DI PAGEBALE
public class Filter {
	private String name;
	private Object from;
	private Object to;
	private boolean direction;
	
	public Object getFrom() {
		return from;
	}
	public Filter setFrom(String from) {
		this.from = from;
		return this;
	}
	public Object getTo() {
		return to;
	}
	public Filter setTo(Object to) {
		this.to = to;
		return this;
	}
	public boolean isDirection() {
		return direction;
	}
	public Filter setDirection(boolean direction) {
		this.direction = direction;
		return this;
	}
	public String getName() {
		return name;
	}
	public Filter setName(String name) {
		this.name = name;
		return this;
	}
	
	public static Filter build() {
		return new Filter();
	}
	
}
