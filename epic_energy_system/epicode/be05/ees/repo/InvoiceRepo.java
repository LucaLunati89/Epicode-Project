package it.epicode.be05.ees.repo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import it.epicode.be05.ees.model.entity.AccountManager;
import it.epicode.be05.ees.model.entity.BusinessClient;
import it.epicode.be05.ees.model.entity.Invoice;

@Repository
public interface InvoiceRepo extends PagingAndSortingRepository<Invoice, Long>{

	public Page<Invoice> findByBusinessClientBusinessName(Pageable pageable, String businessClientName);
	
	public Page<Invoice> findByDateGreaterThanEqual(Pageable pageable, LocalDate date);
	public Page<Invoice> findByDateLessThanEqual(Pageable pageable, LocalDate date);
	
	public Page<Invoice> findByYearGreaterThanEqual(Pageable pageable, Integer  year);
	public Page<Invoice> findByYearLessThanEqual(Pageable pageable, Integer year);
	
	public Page<Invoice> findByAmountBetween(Pageable pageable, BigDecimal from, BigDecimal to);
	
	public List<Invoice> findByBusinessClient(BusinessClient bc);
}
