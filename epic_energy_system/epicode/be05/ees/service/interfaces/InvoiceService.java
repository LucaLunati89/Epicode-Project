package it.epicode.be05.ees.service.interfaces;

import java.util.List;

import org.springframework.data.domain.Pageable;

import it.epicode.be05.ees.model.dto.InvoiceDTO;
import it.epicode.be05.ees.model.entity.BusinessClient;
import it.epicode.be05.ees.model.entity.Invoice;
import it.epicode.be05.ees.model.util.Finder;

public interface InvoiceService extends CrudService<Invoice>{

void createInvoice(Invoice invoice, long idClient);
public List<InvoiceDTO> findByBusinessClientName(Pageable pageable, String businessClientName);
public List<InvoiceDTO> findByDate(Finder finder);
public List<InvoiceDTO> findByYear(Finder finder);
List<InvoiceDTO> findByAmountRange(Finder finder);
public List<Invoice> findByBusinessClient(BusinessClient bc);


}
