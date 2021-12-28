package it.epicode.be05.ees.controller.derivate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.epicode.be05.ees.model.entity.AccountManager;
import it.epicode.be05.ees.service.interfaces.derivate.AccountManagerService;

//GESTITO IN TABELLA DIVERSA PERMETTO SOLO UPDATE, LA CANCELLAZIONE, CREAZIONE E LETTURA E' GARANTITA DAL CONTROLLER GENERALE
@RestController
@RequestMapping("accountManager")
public class AccountManagerController {

	@Autowired
	AccountManagerService service;

	@PutMapping("/{id}")
	public ResponseEntity<AccountManager> updateAccountManager(
			@PathVariable("id") long id, 
			@RequestBody AccountManager accountManager) throws Exception {
		try {
			var result = service.update(id, accountManager);

			if(result != null) return new ResponseEntity<>(HttpStatus.OK);
			else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			 
			}catch (Exception e) {
				throw new Exception("account manager non modificato");
			} 
	}
	

	
}
