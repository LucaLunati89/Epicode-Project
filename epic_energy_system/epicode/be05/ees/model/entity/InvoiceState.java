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
@Table(name = Constant.TABLE_NAME_5)
public class InvoiceState {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bc_generator")
	@SequenceGenerator(name = "bc_generator", sequenceName = "invoice_state_seq")
	private long id;
	
	@Column(name = "stato")
	private String type;
	
	

	public String getType() {
		return type;
	}

	public InvoiceState setType(String type) {
		this.type = type;
		return this;
	}

	public long getId() {
		return id;
	}

	public InvoiceState setId(long id) {
		this.id = id;
		return null;
	}
	
	public static InvoiceState build() {
		return new InvoiceState();
	}

}
