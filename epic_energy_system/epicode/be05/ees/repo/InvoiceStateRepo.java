package it.epicode.be05.ees.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import it.epicode.be05.ees.model.entity.InvoiceState;

@Repository
public interface InvoiceStateRepo extends PagingAndSortingRepository<InvoiceState, Long>{

}
