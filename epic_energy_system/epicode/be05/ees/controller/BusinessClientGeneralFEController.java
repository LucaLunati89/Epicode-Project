package it.epicode.be05.ees.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.epicode.be05.ees.model.dto.BusinessClientGeneralDTO;
import it.epicode.be05.ees.model.entity.BusinessClient;
import it.epicode.be05.ees.model.util.Filter;
import it.epicode.be05.ees.service.dto.BusinessClientGeneralServiceDTO;
import it.epicode.be05.ees.service.interfaces.BusinessClientService;

/*
 * CONTROLLER GENERALE: CREAZIONE, MODIFICA, CANCELLAZIONE E LETTURA IMPLICANO LA CREAZIONE DELLE 3
SOTTOENTITA'(ACCOUNT MANAGER, OFFICE ADDRESS, BUSINESSCLIENTCONTA)*/
@RestController
@RequestMapping("Client")
public class BusinessClientGeneralFEController {

	@Autowired
	BusinessClientGeneralServiceDTO service;
	
	@Autowired
	BusinessClientService s;
	
	//CONTROLLER PER LA CREAZIONE DEL CLIENTE BUSINESS
	@PostMapping("/businessClient/create")
	public ResponseEntity<BusinessClient> createBusinessClientEntity(@RequestBody BusinessClientGeneralDTO bc)throws Exception{
		try {
			 service.create(bc);
			 return new ResponseEntity<>(HttpStatus.CREATED);
		} catch(Exception e) {
			throw new Exception("cliente non creato");
			
		}
	}
	
	//CONTROLLER PER LA CANCELLAZIONE DEL CLIENTE BUSINESS
	//TODO: SOSITUIRE CON NOME IN INPUT
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> deleteClient(@PathVariable("id") long id)throws Exception{
		try {
			s.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch(Exception e) {
			throw new Exception("cliente non cancellato");
		}
	}
	
	//CONTROLLER PER LA LETTURA DEI CLIENTI BUSINESS IN BASE AL PARAMETRO(ATTRIBUTO) SCELTO
	@GetMapping("/businessClients")
	//@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
	public ResponseEntity<List<BusinessClientGeneralDTO>> getAllBusinessClient( 
			@RequestParam(name = "page", required = false, defaultValue= "0") int pageNo, 
			@RequestParam(name = "size", required = false, defaultValue = "5") int size,
			@RequestParam(name = "sortBy", defaultValue = "id") String sortBy,
			@RequestParam(name = "direction", defaultValue = "asc") String direction
			)
	{
	List<BusinessClientGeneralDTO> list = service.order(pageNo, size, sortBy, direction);
		return new ResponseEntity<List<BusinessClientGeneralDTO>>(list, HttpStatus.OK);
		
	}
	
	//CONTROLLER PER LA LETTURA DEI CLIENTI BUSINESS IN BASE AL NOME DELLA PROVINCIA
	@GetMapping("filter/byProvince")
	public ResponseEntity<List<BusinessClientGeneralDTO>> filterByProvince( 
			Pageable pageable,
			@RequestParam(name = "province") String name)
	{
	List<BusinessClientGeneralDTO> list = service.byProvince(pageable, name);
		return new ResponseEntity<List<BusinessClientGeneralDTO>>(list, HttpStatus.OK);
		
	}
	
	//CONTROLLER PER LA LETTURA DEI CLIENTI BUSINESS IN BASE AL FATTURATO, PUOI SCEGLIERE DUE FATTURATI
	//PER I RISULTATI COMPRESI, OPPURE UN FATTURATO E UNA DIREZIONE PER I RISULTATI MAGGIORI O MINORI 
	//DEL FATTURATO(COMPRESO)
	@GetMapping("filter/byRevenue")
	@CrossOrigin
	public ResponseEntity<List<BusinessClientGeneralDTO>> filterByRevenue(
			@RequestParam(name = "page", required = false, defaultValue= "0") int pageNo,
			@RequestParam(name = "size", required = false, defaultValue = "5") int size,
			@RequestBody Filter filter){
		if(filter.getTo() == null)
			return new ResponseEntity<List<BusinessClientGeneralDTO>>(service.byRevenue(pageNo, size, (String) filter.getFrom(), filter.isDirection()), HttpStatus.OK);
			else 
				return new ResponseEntity<List<BusinessClientGeneralDTO>>(service.betweenRevenue(pageNo, size, (String) filter.getFrom(), (String) filter.getTo()), HttpStatus.OK);
		
		}
	
	//CONTROLLER PER LA LETTURA DEI CLIENTI BUSINESS IN BASE ALLA DATA DEL PRIMO CONTATTO
	@GetMapping("filter/firstContact")
	public ResponseEntity<List<BusinessClientGeneralDTO>> filterFirstContact( 
			Pageable pageable,
			@RequestParam(name = "date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate firstContact){
		return new ResponseEntity<List<BusinessClientGeneralDTO>>(service.byFirstContact(pageable, firstContact), HttpStatus.OK);
	}
	
	//CONTROLLER PER LA LETTURA DEI CLIENTI BUSINESS IN BASE ALLA DATA DELL'ULTIMO CONTATTO
	@GetMapping("filter/lastContact")
	public ResponseEntity<List<BusinessClientGeneralDTO>> filterLastContact( 
			Pageable pageable,
			@RequestParam(name = "date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate lastContact){
		return new ResponseEntity<List<BusinessClientGeneralDTO>>(service.byLastContact(pageable, lastContact), HttpStatus.OK);
	}
	
	//CONTROLLER PER LA LETTURA DEI CLIENTI BUSINESS IN BASE A PARTE DEL NOME
	@GetMapping("filter/businessNameContains")
	@CrossOrigin
	public ResponseEntity<List<BusinessClientGeneralDTO>> filterByBusinessNameContains(
			Pageable pageable,
		@RequestParam(name = "businessName")String content){
		return new ResponseEntity<List<BusinessClientGeneralDTO>>(service.byName(pageable,content), HttpStatus.OK);
	}
	}

