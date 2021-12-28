package it.mybookingsystem.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.mybookingsystem.model.Ticket;
import it.mybookingsystem.model.User;
import it.mybookingsystem.model.WorkStation;
import it.mybookingsystem.repo.TicketRepository;
import it.mybookingsystem.service.interfaces.TicketService;
import it.mybookingsystem.service.interfaces.UserService;
import it.mybookingsystem.service.interfaces.WorkStationService;

@Service
public class TicketServiceImpl implements TicketService{

	@Autowired
	TicketRepository ticketRepo;
	
	@Autowired
	UserService userService;
	
	@Autowired
	WorkStationService workStationService;
	
	
	@Override
	public void create(Ticket entity) {
		ticketRepo.save(entity);
	}

	@Override
	public Ticket readById(long id) {
		return ticketRepo.findById(id).orElseThrow();

	}

	@Override
	public Page<Ticket> readAll(Pageable pageable) {
		return ticketRepo.findAll(pageable);
	}

	@Override
	public void update(long id, Ticket entity) {
		var ticket = readById(id)
		.setUser(entity.getUser())
		.setWorkStation(entity.getWorkStation())
		.setEmissionDate(entity.getEmissionDate())
		.setExpirationDate(entity.getExpirationDate());
		ticketRepo.save(ticket);
	}

	@Override
	public void delete(long id) {
		ticketRepo.deleteById(null);		
	}

	@Override
	public List<Ticket> readAll() {
		return ticketRepo.findAll();
	}

	/**@note imposta la validità del biglietto */
	@Override
	public List<LocalDate> setValidityTime(LocalDate date) {
		List<LocalDate> dates = new ArrayList<>();
		dates.add(date);
		dates.add(date.plusDays(1));
		return dates;
	}

	/**@note ritorna l'Utente che sta prenotando*/
	@Override
	public User checkWhoIsBooking(long id) {
		return userService.readById(id);
	}
	/**@note ritorna la Postazione che l'Utente sta prenotando*/
	@Override
	public WorkStation checkWichWorkStation(long id) {
		return workStationService.readById(id);
	}

	
	@Override
	public void createTicket(long idUser, long idWorkStation, LocalDate date) {
		List<LocalDate> dates = setValidityTime(date);
		Ticket t = Ticket.builder()
				.setEmissionDate(dates.get(0))
				.setExpirationDate(dates.get(1))
				.setUser(checkWhoIsBooking(idUser))
				.setWorkStation(checkWichWorkStation(idWorkStation));
		ticketRepo.save(t);
	}

	@Override
	public boolean checkifCanBook(long userId, LocalDate emissionDate) {
		if (ticketRepo.findByUserIdAndEmissionDate(userId, emissionDate).isEmpty()) return true;
		return false;
	}
	
	

}
