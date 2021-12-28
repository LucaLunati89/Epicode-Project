package it.epicode.be05.ees.service.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.be05.ees.model.dto.BusinessClientDTO;
import it.epicode.be05.ees.model.entity.BusinessClient;
import it.epicode.be05.ees.service.services.BusinessClientServiceImpl;

@Service
public class BusinessClientServiceDTO {

	@Autowired
	BusinessClientServiceImpl amService;
	
	//PARSING DA ENTITA' A DATAOBJECTMODEL
	public BusinessClientDTO createBusinessClientFE(BusinessClient bc) {
		return BusinessClientDTO.build()
				.setBusinessName(bc.getBusinessName())
				.setType(bc.getType())
				.setVATNumber(bc.getVATNumber())
				.setFirstContact(bc.getFirstContact())
				.setLastContact(bc.getLastContact())
				.setAnnualRevenue(bc.getAnnualRevenue());
	}
	
	//PARSING DA DATAOBJECTMODEL A ENTITA'
	public BusinessClient parseBusinessClient(BusinessClientDTO client) {
	
		var clientEntity = BusinessClient.build()
				.setBusinessName(client.getBusinessName())
				.setAnnualRevenue(client.getAnnualRevenue())
				.setFirstContact(client.getFirstContact())
				.setLastContact(client.getLastContact())
				.setType(client.getType())
				.setVATNumber(client.getVATNumber());
		return clientEntity;
		
	}
}
