package it.mybookingsystem.service;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.mybookingsystem.model.User;
import it.mybookingsystem.model.WorkStation;
import it.mybookingsystem.repo.UserRepository;
import it.mybookingsystem.service.interfaces.TicketService;
import it.mybookingsystem.service.interfaces.UserService;
import it.mybookingsystem.service.interfaces.WorkStationService;
import it.mybookingsystem.util.City;
import it.mybookingsystem.util.Type;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	WorkStationService workStationService;
	
	@Autowired
	TicketService ticketService;
	
	@Override
	public void create(User entity) {
		userRepo.save(entity);		
	}

	@Override
	public User readById(long id) {
		return userRepo.findById(id).orElseThrow();
	}

	@Override
	public Page<User> readAll(Pageable pageable) {
		return userRepo.findAll(pageable);
	}

	@Override
	public void update(long id, User entity) {
		var user = readById(id)
		.setFirstName(entity.getFirstName())
		.setLastName(entity.getLastName())
		.setPassword(entity.getPassword())
		.setRoles(entity.getRoles())
		.setUserName(entity.getUserName())
		.setEmail(entity.getEmail());
		userRepo.save(user);
	}

	@Override
	public void delete(long id) {
		userRepo.deleteById(id);			
	}

	@Override
	public List<User> readAll() {
		return userRepo.findAll();
	}

	/**@note un utente prenota una postazione*/
	@Override
	public boolean bookWorkStation(long userId, long workStationId, LocalDate date) {
		
		if(workStationService.isFree(workStationId) && workStationService.isAPrenotableDay(date) && hasNoPrenotationForThisDate(userId, date)) {
			log.info("***CAMBIO DI STATO DELLA POSTAZIONE***");
			workStationService.changeState(workStationId);
			log.info("***SALVATAGGIO UTENTE ALLA POSTAZIONE***");
			workStationService.setUserToWorkStation(userId, workStationId);
			log.info("***CREAZIONE DEL BIGLIETTO***");
			ticketService.createTicket(userId, workStationId, date);
			return true;
		}
		else return false;
	}
	/**@note un utente ricerca delle postazioni*/
	@Override
	public List<WorkStation> findWorkStations(Type type, City city) {
		return workStationService.readByTypeAndCity(type, city);
	}

	@Override
	public boolean hasNoPrenotationForThisDate(long udserId, LocalDate date) {
		if(ticketService.checkifCanBook(udserId, date)) return true;
		return false;
	}

}
