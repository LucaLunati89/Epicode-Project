package it.mybookingsystem.runners;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import it.mybookingsystem.repo.TicketRepository;
import it.mybookingsystem.service.interfaces.TicketService;
import it.mybookingsystem.service.interfaces.UserService;
import it.mybookingsystem.service.interfaces.WorkStationService;
import it.mybookingsystem.util.City;
import it.mybookingsystem.util.Type;

@Component
public class AppRunner implements CommandLineRunner{

	private static final Logger log = LoggerFactory.getLogger(EnsureBuildings.class);
	
	@Autowired
	EnsureBuildings buildings;
	
	@Autowired
	EnsureWorkStations workstations;
	
	@Autowired
	EnsureUsers users;
	
	@Autowired
	UserService userService;
	
	@Autowired
	WorkStationService workStationService;
	

	@Autowired
	TicketService ticketService;
	

	@Autowired
	TicketRepository repo;
	
	
	
	@Override
	public void run(String... args) throws Exception {
		
		buildings.ensureBuildings();
		workstations.ensureWorkStations();
		users.ensureUsers();
		
		
		
		/**@note dal 2 in su OK*/
		LocalDate bookingDay = LocalDate.now().plusDays(3);
		LocalDate bookingDay2 = LocalDate.now().plusDays(4);
		
		log.debug("---LETTURA UTENTE DA ID---");
		log.debug(userService.readById(3).toString());
		
		log.info("---RICERCA POSTAZIONE PER TIPOLOGIA E CITTA'---");
		log.info(userService.findWorkStations(Type.OPENSPACE, City.TURIN).toString());
		
		log.info("---PRENOTAZIONE DELLA POSTAZIONE---");
		userService.bookWorkStation(3,5,bookingDay); 
		
		log.info("---VERIFICA CAMBIO DI STATO---");
		log.debug(userService.findWorkStations(Type.OPENSPACE, City.TURIN).toString());
		
		log.info("---PRENOTAZIONE DELLA SECONDA POSTAZIONE---");
		userService.bookWorkStation(3,6,bookingDay2); 
		
		log.info("---VERIFICA DEI BIGLIETTI---");
		log.info(ticketService.readAll().toString());
		
		
	
		
	}

	
}
