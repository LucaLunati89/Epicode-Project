package it.epicode.be05.ees.service.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.be05.ees.model.dto.AccountManagerDTO;
import it.epicode.be05.ees.model.entity.AccountManager;
import it.epicode.be05.ees.service.services.AccountManagerServiceImpl;

@Service
public class AccountManagerServiceDTO {

	@Autowired
	AccountManagerServiceImpl amService;
	
	//PARSING DA ENTITA' A DATAOBJECTMODEL
	public AccountManagerDTO createAccountManagerDTO(AccountManager am) {
		return AccountManagerDTO.build()
				.setFirstName(am.getFirstName())
				.setLastName(am.getLastName())
				.setEmail(am.getEmail())
				.setPhoneNumber(am.getPhoneNumber());
	}
	
	//PARSING DA DATAOBJECTMODEL A ENTITA'
	public AccountManager parseAccountManager(AccountManagerDTO accountManager) {
		
		var managerEntity = AccountManager.build()
				.setFirstName(accountManager.getFirstName())
				.setLastName(accountManager.getLastName())
				.setPhoneNumber(accountManager.getPhoneNumber())
				.setEmail(accountManager.getEmail());
		return managerEntity;
				
	}
}
