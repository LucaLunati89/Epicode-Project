package it.epicode.be05.ees.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import it.epicode.be05.ees.model.util.Constant;

@Entity
@Table(name = Constant.TABLE_NAME_7)
public class Province {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "commune_generator")
	@SequenceGenerator(name = "commune_generator", sequenceName = "commune_seq")
	private long id;
	
	@Column(name = "nome_provincia")
	private String name;
	
	@Column(name = "sigla_provincia")
	private String abbr;

	public long getId() {
		return id;
	}

	public Province setId(long id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Province setName(String name) {
		this.name = name;
		return this;
	}

	public String getAbbr() {
		return abbr;
	}

	public Province setAbbr(String abbr) {
		this.abbr = abbr;
		return this;
	}
	
	public static Province build() {
		return new Province();
	}
	
}
