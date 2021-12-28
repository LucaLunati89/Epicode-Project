package it.epicode.be05.ees.service.services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.epicode.be05.ees.model.dto.InvoiceDTO;
import it.epicode.be05.ees.model.entity.BusinessClient;
import it.epicode.be05.ees.model.entity.Invoice;
import it.epicode.be05.ees.model.util.Filter;
import it.epicode.be05.ees.model.util.Finder;
import it.epicode.be05.ees.repo.InvoiceRepo;
import it.epicode.be05.ees.service.dto.InvoiceServiceDTO;
import it.epicode.be05.ees.service.interfaces.BusinessClientService;
import it.epicode.be05.ees.service.interfaces.InvoiceService;
import it.epicode.be05.ees.service.interfaces.derivate.InvoiceStateService;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	InvoiceRepo repo;
	
	@Autowired
	InvoiceStateService isService;

	@Autowired
	BusinessClientService bcService;

	@Autowired
	InvoiceServiceDTO iServiceDTO;

	private Page<Invoice> invoices = null;

	@Override
	public void create(Invoice entity) {
		repo.save(entity);

	}


	@Override
	public Invoice readById(long id) {

		return repo.findById(id).orElseThrow();
	}

	@Override
	public List<Invoice> readAll() {
		return (List<Invoice>) repo.findAll();
	}

	@Override
	public Page<Invoice> readAll(Pageable pageable) {
		return repo.findAll(pageable);
	}

	@Override
	public Invoice update(long id, Invoice entity) {
		
		var state = readById(id).getState();
		var idState = readById(id).getState().getId();
		
		isService.update(idState, state);
		var invoice = readById(id)
		.setAmount(entity.getAmount())
		.setDate(entity.getDate())
		.setNumber(entity.getNumber())
		.setState(entity.getState())
		.setYear(entity.getYear())
		.setBusinessClient(entity.getBusinessClient());
		isService.delete(idState);
		
		return repo.save(invoice);

	}

	@Override
	public void delete(long id) {
		var idState = readById(id).getState().getId();
		repo.deleteById(id);
		isService.delete(idState);

	}

	@Override
	public void createInvoice(Invoice invoice, long idClient) {
		invoice.setBusinessClient(bcService.readById(idClient));
		create(invoice);
	}


	@Override
	public List<InvoiceDTO> findByBusinessClientName(Pageable pageable, String businessClientName) {
		invoices = repo.findByBusinessClientBusinessName(pageable, businessClientName);
		return iServiceDTO.buildJSON(invoices);
	}


	@Override
	public List<InvoiceDTO> findByDate(Finder finder) {

		switch(finder.getSwitcher()) {
		case AFTER: {
			invoices = repo.findByDateGreaterThanEqual(finder.getPageable(), (LocalDate)finder.getFinded());
			break;
		}
		case BEFORE: {
			invoices = repo.findByDateLessThanEqual(finder.getPageable(), (LocalDate)finder.getFinded());
			break;
		}
		default:
			break;
		}
		return iServiceDTO.buildJSON(invoices);
	}


	@Override
	public List<InvoiceDTO> findByYear(Finder finder) {

		switch(finder.getSwitcher()) {
		case AFTER: {
			invoices = repo.findByYearGreaterThanEqual(finder.getPageable(), (Integer)finder.getFinded());
			break;
		}
		case BEFORE: {
			invoices = repo.findByYearLessThanEqual(finder.getPageable(), (Integer)finder.getFinded());
			break;
		}
		default:
			break;
		}

		return iServiceDTO.buildJSON(invoices);


	}

	@Override
	public List<InvoiceDTO> findByAmountRange(Finder finder) {

		var filter = (Filter) finder.getFinded();
		var from = new BigDecimal((String)filter.getFrom());
		var to = new BigDecimal((String)filter.getTo());

		switch(finder.getSwitcher()) {
		case IN_BETWEEN : {
			invoices = repo.findByAmountBetween(finder.getPageable(),from, to);
			break;
		}
		default:
			break;
		}

		return iServiceDTO.buildJSON(invoices);

	}


	@Override
	public List<Invoice> findByBusinessClient(BusinessClient bc) {
		return repo.findByBusinessClient(bc);
	}

}
