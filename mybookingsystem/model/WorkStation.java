package it.mybookingsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import it.mybookingsystem.util.Type;

@Entity(name = "workstations")
@Table(name = "workstations")
public class WorkStation {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@Column(name = "description")
	private String description;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	private Type type;
	
	@Column(name = "capacity")
	private int capacity;
	
	@ManyToOne
	private Building building;
	
	@Column(name = "state")
	private boolean state;
	
	@OneToOne
	private User user;

	public long getId() {
		return id;
	}

	public WorkStation setId(long id) {
		this.id = id;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public WorkStation setDescription(String description) {
		this.description = description;
		return this;
	}

	public Type getType() {
		return type;
	}

	public WorkStation setType(Type type) {
		this.type = type;
		return this;
	}

	public int getCapacity() {
		return capacity;
	}

	public WorkStation setCapacity(int capacity) {
		this.capacity = capacity;
		return this;
	}

	public Building getBuilding() {
		return building;
	}

	public WorkStation setBuilding(Building building) {
		this.building = building;
		return this;
	}

	public boolean isState() {
		return state;
	}

	public WorkStation setState(boolean state) {
		this.state = state;
		return this;
	}
	
	public static WorkStation builder() {
		return new WorkStation();
	}

	public User getUser() {
		return user;
	}

	public WorkStation setUser(User user) {
		this.user = user;
		return this;
	}

	@Override
	public String toString() {
		return "WorkStation [id=" + id + ", description=" + description + ", type=" + type + ", capacity=" + capacity
				+ ", building=" + building + ", state=" + state + ", user=" + user + "]";
	}


	
	
	
}
