package it.epicode.be05.ees.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.be05.ees.model.entity.Province;
import it.epicode.be05.ees.repo.ProvinceRepo;
import it.epicode.be05.ees.service.interfaces.ProvinceService;

@Service
public class ProvinceServiceImpl implements ProvinceService{

	@Autowired
	ProvinceRepo repo;
	
	@Override
	public void create(Province entity) {
		repo.save(entity);
		
	}

	@Override
	public Province findByName(String name) {
		return repo.findByName(name);
	}


}
