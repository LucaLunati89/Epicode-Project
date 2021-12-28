package it.mybookingsystem.runners;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.mybookingsystem.model.Building;
import it.mybookingsystem.service.interfaces.BuildingService;
import it.mybookingsystem.util.City;

@Component
public class EnsureBuildings {

	private static final Logger log = LoggerFactory.getLogger(EnsureBuildings.class);
	
	@Autowired
	BuildingService service;
	
	private List<Building> instanceBuildings(){
		log.info("%%%CREAZIONE ISTANZE BUILDING%%%");
		List<Building> buildings = new ArrayList<>();
		Building b1 = Building.builder().setName("Edificio A")
				.setCity(City.ROME)
				.setAddress("Via Roma 12")
				.setCode("1234");
		Building b2 = Building.builder().setName("Edificio B")
				.setCity(City.NAPLES)
				.setAddress("Via Agostino Fausti 44")
				.setCode("abcd");
		Building b3 = Building.builder().setName("Edificio C")
				.setCity(City.TURIN)
				.setAddress("Via Giuseppe Palazzi 25")
				.setCode("key");
		buildings.add(b1);
		buildings.add(b2);
		buildings.add(b3);
		return buildings;
		
	}
	
	public void ensureBuildings() {
		for(Building b : instanceBuildings()) {
			log.debug("STO INSERENDO IL {}", b);
			service.create(b);
			log.debug("HO INSERITO IL {}", b);
		}
	}
	
	public List<Building> getBuildings(){
		return service.readAll();
	}
	
}
