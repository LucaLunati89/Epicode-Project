package it.epicode.be05.ees.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.be05.ees.model.entity.Commune;
import it.epicode.be05.ees.repo.CommuneRepo;
import it.epicode.be05.ees.service.interfaces.CommuneService;

@Service
public class CommuneServiceImpl implements CommuneService{

	@Autowired
	CommuneRepo repo;
	
	@Override
	public void create(Commune entity) {
		repo.save(entity);
		
	}

	@Override
	public Commune findByName(String name) {
		var sb = new StringBuilder();
		var s = sb.append(name.substring(0, 1).toUpperCase()).append(name.substring(1)).toString();
		return repo.findByName(s);
	}

	

	
}
