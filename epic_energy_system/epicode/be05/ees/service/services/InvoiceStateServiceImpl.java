package it.epicode.be05.ees.service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.epicode.be05.ees.model.entity.InvoiceState;
import it.epicode.be05.ees.repo.InvoiceStateRepo;
import it.epicode.be05.ees.service.interfaces.derivate.InvoiceStateService;

@Service
public class InvoiceStateServiceImpl implements InvoiceStateService{
	
	@Autowired
	InvoiceStateRepo repo;
	
	@Override
	public void create(InvoiceState entity) {
		repo.save(entity);
		
	}

	@Override
	public InvoiceState readById(long id) {
		return repo.findById(id).orElseThrow();
	}

	@Override
	public List<InvoiceState> readAll() {
		return (List<InvoiceState>) repo.findAll();
	}

	@Override
	public Page<InvoiceState> readAll(Pageable pageable) {
		return repo.findAll(pageable);
	}

	@Override
	public InvoiceState update(long id, InvoiceState entity) {
		var invoiceState = readById(id)
		.setType(entity.getType());
		return repo.save(invoiceState);
	}

	@Override
	public void delete(long id) {
		repo.deleteById(id);
		
	}

	@Override
	public InvoiceState createInvoiceState(InvoiceState entity) {
		return repo.save(entity);
	}

}
