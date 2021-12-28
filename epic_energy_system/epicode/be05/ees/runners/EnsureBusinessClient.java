package it.epicode.be05.ees.runners;

import java.time.LocalDate;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.epicode.be05.ees.model.entity.BusinessClient;
import it.epicode.be05.ees.model.util.ClientType;
import it.epicode.be05.ees.service.interfaces.BusinessClientService;
import it.epicode.be05.ees.service.interfaces.derivate.OfficeAddressService;

@Component
public class EnsureBusinessClient {

	private static final Logger log = LoggerFactory.getLogger(EnsureBusinessClient.class);
	
	@Autowired
	BusinessClientService service;
	
	
	
	public void createBusinessClient(int clients) {
		
		ClientType[] types = {ClientType.PA, ClientType.SASA, ClientType.SPA, ClientType.SRL};
		var min = 11111111111l;
		var max = 99999999999l;
		var minRev = 500000;
		var maxRev = 3000000;
		var rand = new Random();
		var minYear = 2020;
		var maxYear = 2021;
		var minMonth = 1;
		var maxMonth = 12;
		var minDay = 1;
		var maxDay = 28;
		var minAdd = 7;
		var maxAdd = 30;
		
		
		for(int i = 1; i <= clients; i++) {
			
			var bc = BusinessClient.build()
					.setBusinessName("azienda" + i)
					.setType(types[rand.nextInt(types.length)])
					.setVATNumber((long) Math.floor(Math.random()*(max-min+1)+min))
					.setAnnualRevenue((long) Math.floor(Math.random()*(maxRev-minRev+1)+minRev))
					.setFirstContact(LocalDate.of(
							(int) Math.floor(Math.random()*(maxYear-minYear+1)+minYear), 
							(int) Math.floor(Math.random()*(maxMonth-minMonth+1)+minMonth), 
							(int) Math.floor(Math.random()*(maxDay-minDay+1)+minDay)));
			bc.setLastContact(bc.getFirstContact().plusDays((int) Math.floor(Math.random()*(maxAdd-minAdd+1)+minAdd)));
					
					
			service.create(bc);
			
			log.info(bc.toString());
			
		}
	}
	
	
}
