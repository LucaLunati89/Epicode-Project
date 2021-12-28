package it.epicode.be05.ees.service.interfaces.derivate;



import it.epicode.be05.ees.model.entity.InvoiceState;
import it.epicode.be05.ees.service.interfaces.CrudService;


public interface InvoiceStateService extends CrudService<InvoiceState> {
	public InvoiceState createInvoiceState(InvoiceState entity);
	
	
}
