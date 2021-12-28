package it.mybookingsystem.service.interfaces;

import java.time.LocalDate;
import java.util.List;

import it.mybookingsystem.model.Ticket;
import it.mybookingsystem.model.User;
import it.mybookingsystem.model.WorkStation;

public interface TicketService extends CrudService<Ticket>{

	public List<LocalDate> setValidityTime(LocalDate date);
	public User checkWhoIsBooking(long id);
	public WorkStation checkWichWorkStation(long id);
	public void createTicket(long idUser, long idWorkStation, LocalDate date);
	public boolean checkifCanBook(long userId, LocalDate emissionDate);
}
