package it.epicode.be05.ees.repo;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import it.epicode.be05.ees.model.entity.BusinessClient;
import it.epicode.be05.ees.model.entity.OfficeAddress;
import it.epicode.be05.ees.model.util.OfficeType;

@Repository
public interface OfficeAddressRepo extends PagingAndSortingRepository<OfficeAddress, Long>{
	public List<OfficeAddress> findByBusinessClient(BusinessClient bc);
	public List<OfficeAddress> findByType(Pageable pageable, OfficeType type);
	
	public List<OfficeAddress> findByCommuneProvinceName(Pageable pageable, String name);
}
