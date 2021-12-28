package it.mybookingsystem.runners;

import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.mybookingsystem.model.Building;
import it.mybookingsystem.model.WorkStation;
import it.mybookingsystem.service.interfaces.BuildingService;
import it.mybookingsystem.service.interfaces.WorkStationService;
import it.mybookingsystem.util.Type;

@Component
public class EnsureWorkStations {

	private static final Logger log = LoggerFactory.getLogger(EnsureWorkStations.class);

	@Autowired
	WorkStationService workStationservice;

	@Autowired
	BuildingService buildingService;


	private List<WorkStation> instanceWorkStations(){
		log.info("%%%CREAZIONE ISTANZE POSTAZIONI%%%");
		List<WorkStation> workStations = new ArrayList<>();
		List<Building> buildings = buildingService.readAll();
		WorkStation w1 = WorkStation.builder()
				.setDescription("postazione singola")
				.setType(Type.PRIVATE)
				.setCapacity(1)
				.setBuilding(buildings.get(0))
				.setState(false);
		WorkStation w2 = WorkStation.builder()
				.setDescription("sala riunioni per 8 persone")
				.setType(Type.MEETING_ROOM)
				.setCapacity(8)
				.setBuilding(buildings.get(1))
				.setState(false);
		WorkStation w3 = WorkStation.builder()
				.setDescription("spazio openspace per 30 persone")
				.setType(Type.OPENSPACE)
				.setCapacity(30)
				.setBuilding(buildings.get(2))
				.setState(false);
		workStations.add(w1);
		workStations.add(w2);
		workStations.add(w3);
		return workStations;

	}

	

	public void ensureWorkStations() {
		for(WorkStation w : instanceWorkStations()) {
			log.debug("STO INSERENDO LA {}", w);
			workStationservice.create(w);
			log.debug("HO INSERITO LA {}", w);
		}
	}


}
