package it.epicode.be05.ees.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import it.epicode.be05.ees.model.entity.BusinessClient;
import it.epicode.be05.ees.model.entity.BusinessClientContact;
@Repository
public interface BusinessClientContactRepo extends PagingAndSortingRepository<BusinessClientContact, Long> {

	public BusinessClientContact findByBusinessClient(BusinessClient bc);
}
