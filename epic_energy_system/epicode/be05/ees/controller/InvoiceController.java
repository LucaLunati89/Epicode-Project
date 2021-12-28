package it.epicode.be05.ees.controller;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.epicode.be05.ees.model.dto.InvoiceDTO;
import it.epicode.be05.ees.model.entity.Invoice;
import it.epicode.be05.ees.model.util.Filter;
import it.epicode.be05.ees.model.util.Finder;
import it.epicode.be05.ees.service.dto.InvoiceServiceDTO;
import it.epicode.be05.ees.service.interfaces.InvoiceService;

/*
 * CONTROLLER PER LA GESTIONE DELLE FATTURE DEI CLIENTI*/
@RestController
@RequestMapping("Invoice")
public class InvoiceController {

	@Autowired
	InvoiceService service;
	
	@Autowired
	InvoiceServiceDTO serviceDTO;
	
	@Autowired
	Finder finder;

	
	//CONTROLLER PER LA CREAZIONE DI UNA FATTURA
	@PostMapping("/createInvoice")
	public ResponseEntity<Invoice> createInvoiceDTO(
			@RequestBody InvoiceDTO invoice)throws Exception {
		try {
			service.create(serviceDTO.parseInvoice(invoice));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			throw new Exception("fattura non creata");
		} 
	}
	
	//CONTROLLER PER LA LETTURA GENERALE DI FATTURE
	@GetMapping("/readAll")
	public ResponseEntity<Page<Invoice>> getAllInvoices(Pageable pageable)throws Exception{

		try {
			Page<Invoice> result =  service.readAll(pageable);

			if (result.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			else return new ResponseEntity<>(result, HttpStatus.OK);
		}
		catch (Exception e) {
			throw new Exception("fatture non trovate");
		}

	}

	//CONTROLLER PER LA MODIFICA DI UNA FATTURA
	//TODO: SOSTITUISCI IL NUMERO DELL'ID CON LA FATTURA, SE NEL BODY DELLA MODIFICA C'E' UN NUOVO NUMERO
	//LO SOSTITUISCI ALTRIMENTI LASCI QUELLO DEL PATH VARIABLE
	@PutMapping("/update/{id}")
	public ResponseEntity<Invoice> updateInvoiceDTO(
			@PathVariable("id") long id, 
			@RequestBody InvoiceDTO invoice) throws Exception {

		try {
			var result = service.update(id, serviceDTO.parseInvoice(invoice));

			if(result != null) return new ResponseEntity<>(HttpStatus.OK);
			else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			 
			}catch (Exception e) {
				throw new Exception("fatture non modificate");
			} 
		
	}
	
	//CONTROLLER PER LA CANCELLAZIONE DI UNA FATTURA
	//TODO: SOSTITUISCI L'ID CON IL NUMERO DELLA FATTURA
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> deleteInvoice(@PathVariable("id") long id)throws Exception{
		try {
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch(Exception e) {
			throw new Exception("fattura non cancellata");
		}
	}
	
	//CONTROLLER PER LA LETTURA DELLE FATTURE IN BASE AL NOME DEL CLIENTE
	@GetMapping("/filter/businessClient/{name}")
	public ResponseEntity<List<InvoiceDTO>> findByBusinessClient(
			@PathVariable("name") String businessClientName,
			Pageable pageable)throws Exception{
		try {
			List<InvoiceDTO> result = service.findByBusinessClientName(pageable, businessClientName);
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch(Exception e) {
			throw new Exception("fatture non trovate");
		}
	}
	
	//CONTROLLER PER LA LETTURA DELLE FATTURE IN BASE ALLA DATA DI EMISSIONE
	@GetMapping("/filter/emissionDate")
	public ResponseEntity<List<InvoiceDTO>> findByDate(
			@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			Pageable pageable,
			@RequestParam(name = "which", required = false, defaultValue = "NONE")String switcher )throws Exception{
		try {
			
			List<InvoiceDTO> result = service.findByDate(Finder.build()
														.setPageable(pageable) 
														.setFinded(date)
														.setSwitcher(finder.switching(switcher)));
			return new ResponseEntity<> (result, HttpStatus.OK);
		} catch (Exception e) {
			throw new Exception("fatture non trovate");
		}
	}
	
	//CONTROLLER PER LA LETTURA DELLE FATTURE IN BASE ALL'ANNO
	@GetMapping("/filter/year")
	public ResponseEntity<List<InvoiceDTO>> findByYear(
			@RequestParam("year")Integer year,
			Pageable pageable,
			@RequestParam(name = "which", required = false, defaultValue = "NONE")String switcher )throws Exception{
		try {
			
			List<InvoiceDTO> result = service.findByYear(Finder.build()
														.setPageable(pageable) 
														.setFinded(year)
														.setSwitcher(finder.switching(switcher)));
			return new ResponseEntity<> (result, HttpStatus.OK);
		} catch (Exception e) {
			throw new Exception("fatture non trovate");
		}
	}
	

	//CONTROLLER PER LA LETTURA DELLE FATTURE IN BASE AL RANGE DI IMPORTI
	@GetMapping("/filter/amountRange")
	public ResponseEntity<List<InvoiceDTO>> findByAmountRange(
			@RequestParam("from")String from,
			@RequestParam("to")String to,
			Pageable pageable,
			@RequestParam(name = "which", required = false, defaultValue = "NONE")String switcher )throws Exception{
		try {
			
			var filter = Filter.build().setFrom(from).setTo(to);
			List<InvoiceDTO> result = service.findByAmountRange(Finder.build()
														.setPageable(pageable) 
														.setFinded(filter)
														.setSwitcher(finder.switching(switcher)));
			return new ResponseEntity<> (result, HttpStatus.OK);
		} catch (Exception e) {
			throw new Exception("fatture non trovate");
		}
	}
	
}
