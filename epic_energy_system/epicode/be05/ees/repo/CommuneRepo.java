package it.epicode.be05.ees.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import it.epicode.be05.ees.model.entity.Commune;

@Repository
public interface CommuneRepo extends PagingAndSortingRepository<Commune, Long>{

	public Commune findByName(String name);
	
}
