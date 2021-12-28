package it.epicode.be05.ees.runners;

import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.epicode.be05.ees.model.entity.BusinessClient;
import it.epicode.be05.ees.model.entity.BusinessClientContact;
import it.epicode.be05.ees.service.interfaces.BusinessClientService;
import it.epicode.be05.ees.service.interfaces.derivate.BusinessClientContactService;


@Component
public class EnsureBusinessClientContact {
	

	
	
	private static final Logger log = LoggerFactory.getLogger(EnsureBusinessClientContact.class);
	
	String[] prefix = {"06", "05", "04", "03", "02"};
	int minMiddle = 10;
	int maxMiddle = 99;
	
	int minFinal = 111;
	int maxFinal = 999;
	Random rand = new Random();
	
	
	@Autowired
	BusinessClientService bcService;
	
	@Autowired
	BusinessClientContactService bccService;
	
	public void createBusinessClientContactService(int clients) {
		List<BusinessClient> bc = bcService.readAll();
		int j = 0;
		for(int i = 1; i <= clients; i++) {
			var bcc = BusinessClientContact.build()
					.setEmail("azienda" + i + "@email.it")
					.setPec("azienda" + i + "@pec.it")
					.setPhoneNumber(prefix[rand.nextInt(prefix.length)]+ " " +
							(int) Math.floor(Math.random()*(maxMiddle-minMiddle+1)+minMiddle)+ " " +
							(int) Math.floor(Math.random()*(maxMiddle-minMiddle+1)+minMiddle)+ " " +
							(int) Math.floor(Math.random()*(maxFinal-minFinal+1)+minFinal))
					.setBusinessClient(bc.get(j));
			bccService.create(bcc);
			j++;
			log.info(bcc.toString());
			
		}
	}
}
