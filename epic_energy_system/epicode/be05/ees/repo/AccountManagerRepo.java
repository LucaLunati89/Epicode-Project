package it.epicode.be05.ees.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import it.epicode.be05.ees.model.entity.AccountManager;
import it.epicode.be05.ees.model.entity.BusinessClient;

@Repository
public interface AccountManagerRepo extends PagingAndSortingRepository<AccountManager, Long>{

	public AccountManager findByBusinessClient(BusinessClient bc);
}
