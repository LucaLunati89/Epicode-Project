package it.epicode.be05.ees.service.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import it.epicode.be05.ees.model.dto.InvoiceDTO;
import it.epicode.be05.ees.model.entity.Invoice;
import it.epicode.be05.ees.model.entity.InvoiceState;
import it.epicode.be05.ees.service.interfaces.BusinessClientService;
import it.epicode.be05.ees.service.interfaces.derivate.InvoiceStateService;

@Service
public class InvoiceServiceDTO {
	
	@Autowired
	BusinessClientService bcService;
	
	@Autowired
	InvoiceStateService isService;

	//PARSING DA ENTITA' A DATAOBJECTMODEL
	public List<InvoiceDTO> buildJSON(Page<Invoice> invoices){
		List<InvoiceDTO> invoicesDTO = new ArrayList<>();

		for(var i : invoices) {
			var invoiceDTO = InvoiceDTO.build()
					.setAmount(i.getAmount())
					.setDate(i.getDate())
					.setNumber(i.getNumber())
					.setYear(i.getYear())
					.setState(i.getState().getType())
					.setBusinessClientName(i.getBusinessClient().getBusinessName());
			invoicesDTO.add(invoiceDTO);

		}
		return invoicesDTO;
	}
	
	//PARSING DA DATAOBJECTMODEL A ENTITA'
	public Invoice parseInvoice(InvoiceDTO invoice) {
	 var invoiceState =	InvoiceState.build().setType(invoice.getState());
	 
		var invoiceEntity = Invoice.build()
				.setDate(invoice.getDate())
				.setYear(invoice.getYear())
				.setAmount(invoice.getAmount())
				.setNumber(invoice.getNumber())
				.setBusinessClient(bcService.findByName(invoice.getBusinessClientName()))
				.setState(isService.createInvoiceState(invoiceState));
		return invoiceEntity;
		
				
	}

}
