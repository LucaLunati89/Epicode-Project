package it.epicode.be05.ees.service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.epicode.be05.ees.model.entity.AccountManager;
import it.epicode.be05.ees.model.entity.BusinessClient;
import it.epicode.be05.ees.repo.AccountManagerRepo;
import it.epicode.be05.ees.service.interfaces.BusinessClientService;
import it.epicode.be05.ees.service.interfaces.derivate.AccountManagerService;

@Service
public class AccountManagerServiceImpl implements AccountManagerService {

	@Autowired
	AccountManagerRepo repo;
	
	@Autowired
	BusinessClientService bcService;
	
	@Override
	public void create(AccountManager entity) {
		repo.save(entity);
		
	}

	@Override
	public AccountManager readById(long id) {
		return repo.findById(id).orElseThrow();
	}

	@Override
	public Page<AccountManager> readAll(Pageable pageable) {
		return repo.findAll(pageable);
	}

	@Override
	public List<AccountManager> readAll() {
		return (List<AccountManager>) repo.findAll();
	}

	@Override
	public AccountManager update(long id, AccountManager entity) {
		var am = readById(id);
		am 
		.setFirstName(entity.getFirstName())
		.setLastName(entity.getLastName())
		.setPhoneNumber(entity.getPhoneNumber())
		.setEmail(entity.getEmail());
		
		return repo.save(am);
	}

	@Override
	public void delete(long id) {
		repo.deleteById(id);
		
	}

	@Override
	public AccountManager findByBusinessClient(BusinessClient bc) {
		
		return repo.findByBusinessClient(bc);
	}

	@Override
	public void createAccountManager(AccountManager accountManager, long idClient) {
		accountManager.setBusinessClient(bcService.readById(idClient));
		create(accountManager);
		
	}



	

	

}
