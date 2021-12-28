package it.epicode.be05.ees.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import it.epicode.be05.ees.model.util.Constant;

@Entity
@Table(name = Constant.TABLE_NAME_6)
public class Commune {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "commune_generator")
	@SequenceGenerator(name = "commune_generator", sequenceName = "commune_seq")
	private long id;
	
	@Column(name = "nome_comune")
	private String name;
	
	@ManyToOne
	private Province province;
	
	public long getId() {
		return id;
	}
	public Commune setId(long id) {
		this.id = id;
		return this;
	}
	
	
	public String getCommune() {
		return name;
	}
	public Commune setCommune(String name) {
		this.name = name;
		return this;
	}
	public Province getProvince() {
		return province;
	}
	public Commune setProvince(Province province) {
		this.province = province;
		return this;
	}
	
	public static Commune build() {
		return new Commune();
	}
	
	
	@Override
	public String toString() {
		return "Commune [id=" + id + ", name=" + name + ", province=" + province + "]";
	}
	
}
