package it.epicode.be05.ees.service.interfaces;

import org.springframework.stereotype.Service;

import it.epicode.be05.ees.model.entity.Province;

@Service
public interface ProvinceService {
	public void create(Province entity);
	public Province findByName(String name);
	
	
}
