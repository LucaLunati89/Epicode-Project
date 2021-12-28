package it.mybookingsystem.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.mybookingsystem.model.WorkStation;
import it.mybookingsystem.repo.WorkStationRepository;
import it.mybookingsystem.service.interfaces.UserService;
import it.mybookingsystem.service.interfaces.WorkStationService;
import it.mybookingsystem.util.City;
import it.mybookingsystem.util.Type;

@Service
public class WorkStationServiceImpl implements WorkStationService {

	@Autowired
	WorkStationRepository workStationRepo;
	
	@Autowired
	UserService userService;
	
	@Override
	public void create(WorkStation entity) {
			workStationRepo.save(entity);
	}

	@Override
	public WorkStation readById(long id) {
		return workStationRepo.findById(id).orElseThrow();
	}

	@Override
	public Page<WorkStation> readAll(Pageable pageable) {
		return workStationRepo.findAll(pageable);
	}

	@Override
	public void update(long id, WorkStation entity) {
		var workStation = readById(id)
		.setDescription(entity.getDescription())
		.setType(entity.getType())
		.setCapacity(entity.getCapacity())
		.setBuilding(entity.getBuilding());
		workStationRepo.save(workStation);
		
	}

	@Override
	public void delete(long id) {
		workStationRepo.deleteById(null);		
	}

	@Override
	public List<WorkStation> readAll() {
		return workStationRepo.findAll();
	}

	/**@note cambia lo stato di una postazione*/
	@Override
	public void changeState(long id) {
		WorkStation w = readById(id);
		if(!w.isState()) {
			w.setState(true);
			workStationRepo.save(w);
		}
		else {
			readById(id).setState(false);
			workStationRepo.save(w);
		}
	}

	/**@note controlla se la postazione è libera*/
	@Override
	public boolean isFree(long id) {
		if(!readById(id).isState())
		return true;
		else return true;
	}

	/**@note associa un utente alla postazione*/
	@Override
	public void setUserToWorkStation(long userId, long workStationId) {
		workStationRepo.save(readById(workStationId).setUser(userService.readById(userId)));
		
	}

	/**@note ritorna una lista di postazioni dal tipo scelto e città selezionata*/
	@Override
	public List<WorkStation> readByTypeAndCity(Type type, City city) {
		return workStationRepo.findWorkStationByTypeAndBuildingCity(type, city);
	}

	@Override
	public boolean isAPrenotableDay(LocalDate date) {
		if(date.getDayOfYear() <= LocalDate.now().getDayOfYear()+1)
			return false;
		else
			return true;
	}

	

}
