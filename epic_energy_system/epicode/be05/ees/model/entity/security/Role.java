package it.epicode.be05.ees.model.entity.security;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import it.epicode.be05.ees.model.util.Constant;


@Entity
@Table(name = Constant.TABLE_NAME_10)
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roles_generator")
	@SequenceGenerator(name = "roles_generator", sequenceName = "roles_seq")
	private long id;
	
	@Enumerated(EnumType.STRING)
	private RoleType roleType;
	
	
	public long getId() {
		return id;
	}

	public Role setId(long id) {
		this.id = id;
		return this;
	}

	public RoleType getRoleType() {
		return roleType;
	}

	public Role setRoleType(RoleType roleType) {
		this.roleType = roleType;
		return this;
	}
	

	public enum RoleType{
		USER, ADMIN;
	}
}
