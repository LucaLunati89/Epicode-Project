package it.epicode.be05.ees.repo;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import it.epicode.be05.ees.model.entity.BusinessClient;

@Repository
public interface BusinessClientRepo extends PagingAndSortingRepository<BusinessClient, Long> {

	
	/*QUERY FILTER REVENUE*/
	
	@Query("SELECT bc FROM BusinessClient bc WHERE bc.annualRevenue >= :from")
	public List<BusinessClient> byRevenueMax (Pageable pageable, Long from);
	
	@Query("SELECT bc FROM BusinessClient bc WHERE bc.annualRevenue <= :from")
	public List<BusinessClient> byRevenueMin (Pageable pageable, Long from);
	
	@Query("SELECT bc FROM BusinessClient bc WHERE bc.annualRevenue >= :from AND bc.annualRevenue <= :to")
	public List<BusinessClient> betweenRevenue(Pageable pageable, Long from, Long to);
	
	@Query("SELECT bc FROM BusinessClient bc WHERE bc.firstContact >= :from")
	public List<BusinessClient> byFirstContact(Pageable pageable, LocalDate from);
	
	@Query("SELECT bc FROM BusinessClient bc WHERE bc.lastContact >= :from")
	public List<BusinessClient> byLastContact(Pageable pageable, LocalDate from);
	
	public List<BusinessClient> findByBusinessNameContaining(Pageable pageable, String content);
	
	@Query("SELECT bc FROM BusinessClient bc WHERE bc.businessName = :name")
	public BusinessClient findByBusinessName(String name);
	
	
}
