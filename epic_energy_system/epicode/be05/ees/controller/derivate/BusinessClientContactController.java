package it.epicode.be05.ees.controller.derivate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.epicode.be05.ees.model.entity.BusinessClientContact;
import it.epicode.be05.ees.service.interfaces.derivate.BusinessClientContactService;

//GESTITO IN TABELLA DIVERSA PERMETTO SOLO UPDATE, LA CANCELLAZIONE, CREAZIONE E LETTURA E' GARANTITA DAL CONTROLLER GENERALE
@RestController
@RequestMapping("businessClientContact")
public class BusinessClientContactController {

	@Autowired
	BusinessClientContactService service;
	
	@PutMapping("/{id}")
	public ResponseEntity<BusinessClientContact> updateBusinessClientContact(
			@PathVariable("id") long id, 
			@RequestBody BusinessClientContact businessClientContact
			) throws Exception {
		
		try {
			var result = service.update(id, businessClientContact);

			if(result != null) return new ResponseEntity<>(HttpStatus.OK);
			else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			 
			}catch (Exception e) {
				throw new Exception("contatto cliente business non modificato");
			} 
	}
}
