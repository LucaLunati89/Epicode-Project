package it.epicode.be05.ees.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import it.epicode.be05.ees.model.entity.Province;

@Repository
public interface ProvinceRepo extends PagingAndSortingRepository<Province, Long>{

	public Province findByName(String name);
	
}
