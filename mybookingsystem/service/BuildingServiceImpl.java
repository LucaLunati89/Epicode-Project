package it.mybookingsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.mybookingsystem.model.Building;
import it.mybookingsystem.repo.BuildingRepository;
import it.mybookingsystem.service.interfaces.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService {

	@Autowired
	BuildingRepository repo;
	
	@Override
	public void create(Building entity) {
		repo.save(entity);
	}

	@Override
	public Building readById(long id) {
		return repo.findById(id).orElseThrow();
	}

	@Override
	public Page<Building> readAll(Pageable pageable) {
		return repo.findAll(pageable);
	}
	
	

	@Override
	public void update(long id, Building entity) {
		var building =readById(id)
		.setAddress(entity.getAddress())
		.setCity(entity.getCity())
		.setCode(entity.getCode())
		.setName(entity.getName());
		repo.save(building);
	}

	@Override
	public void delete(long id) {
		repo.deleteById(id);
	}

	@Override
	public List<Building> readAll() {
		return repo.findAll();
	}


}
