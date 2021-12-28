package it.epicode.be05.ees.runners;

import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.epicode.be05.ees.model.entity.AccountManager;
import it.epicode.be05.ees.model.entity.BusinessClient;
import it.epicode.be05.ees.service.interfaces.BusinessClientService;
import it.epicode.be05.ees.service.interfaces.derivate.AccountManagerService;

@Component
public class EnsureAccountManager {
	
	private static final Logger log = LoggerFactory.getLogger(EnsureAccountManager.class);
	
	@Autowired
	AccountManagerService amService;
	
	@Autowired
	BusinessClientService bcService;
	
	int[] prefix = {333, 349, 346, 320, 329};
	int minMiddle = 100;
	int maxMiddle = 999;
	
	int minFinal = 1111;
	int maxFinal = 9999;
	Random rand = new Random();
	
	
	
	
	public void createAccountManager(int clients) {
		
		List<BusinessClient> bc = bcService.readAll();
		int j = 0;
		for(int i = 1; i <= clients; i++) {
			
			var am = AccountManager.build()
					.setFirstName("nome" + i)
					.setLastName("cognome" + i)
					.setEmail("nome.cognome" + i + "@email.it")
					.setPhoneNumber(""+
							prefix[rand.nextInt(prefix.length)]+ " " +
							(int) Math.floor(Math.random()*(maxMiddle-minMiddle+1)+minMiddle)+ " " +
							(int) Math.floor(Math.random()*(maxFinal-minFinal+1)+minFinal))
					.setBusinessClient(bc.get(j));
				
			amService.create(am);
			j++;
			log.info(am.toString());
		}
		
	}
}
