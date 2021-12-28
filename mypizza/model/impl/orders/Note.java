package it.mypizza.model.impl.orders;

public class Note {

	private String description;

	String getDescription() {
		return description;
	}

	public Note setDescription(String description) {
		this.description = description;
		return this;
	}

	@Override
	public String toString() {
		return "Note [description=" + description + "]";
	}
	
	
	
}
