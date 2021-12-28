package it.epicode.be05.ees.service.interfaces.derivate;


import it.epicode.be05.ees.model.entity.AccountManager;
import it.epicode.be05.ees.model.entity.BusinessClient;
import it.epicode.be05.ees.service.interfaces.CrudService;


public interface AccountManagerService extends CrudService<AccountManager>{
	
	void createAccountManager(AccountManager accountManager, long idClient);
	public AccountManager findByBusinessClient(BusinessClient bc);

}
