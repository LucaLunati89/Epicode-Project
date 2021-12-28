package it.mybookingsystem.service.interfaces;

import java.time.LocalDate;
import java.util.List;

import it.mybookingsystem.model.WorkStation;
import it.mybookingsystem.util.City;
import it.mybookingsystem.util.Type;

public interface WorkStationService extends CrudService<WorkStation> {
	
	/**@note cambia lo stato dell'occupazione*/
	public void changeState(long id); 
	public boolean isFree(long id);
	public boolean isAPrenotableDay(LocalDate date);
	public void setUserToWorkStation(long userId, long workStationId);
	public List<WorkStation> readByTypeAndCity(Type type, City city);
}
