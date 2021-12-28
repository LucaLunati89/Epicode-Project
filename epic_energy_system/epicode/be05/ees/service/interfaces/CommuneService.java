package it.epicode.be05.ees.service.interfaces;

import it.epicode.be05.ees.model.entity.Commune;

public interface CommuneService {
	public void create(Commune entity);
	public Commune findByName(String name);
	
}
