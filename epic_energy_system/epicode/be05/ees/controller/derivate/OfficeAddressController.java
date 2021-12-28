package it.epicode.be05.ees.controller.derivate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.epicode.be05.ees.model.entity.OfficeAddress;
import it.epicode.be05.ees.service.interfaces.derivate.OfficeAddressService;

//GESTITO IN TABELLA DIVERSA PERMETTO SOLO UPDATE, LA CANCELLAZIONE, CREAZIONE E LETTURA E' GARANTITA DAL CONTROLLER GENERALE
@RestController
@RequestMapping("officeAddress")
public class OfficeAddressController {

	@Autowired
	OfficeAddressService service;
	
	@PutMapping("/{id}")
	public ResponseEntity<OfficeAddress> updateOfficeAddress(
			@PathVariable("id") long id, 
			@RequestBody OfficeAddress officeAddress) throws Exception{
		try {
			var result = service.update(id, officeAddress);

			if(result != null) return new ResponseEntity<>(HttpStatus.OK);
			else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			 
			}catch (Exception e) {
				throw new Exception("indirizzo non modificato");
			} 
	}
}
