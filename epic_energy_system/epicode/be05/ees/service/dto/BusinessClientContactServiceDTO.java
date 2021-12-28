package it.epicode.be05.ees.service.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.be05.ees.model.dto.BusinessClientContactDTO;
import it.epicode.be05.ees.model.entity.BusinessClientContact;
import it.epicode.be05.ees.service.services.BusinessClientContactServiceImpl;

@Service
public class BusinessClientContactServiceDTO {

	@Autowired
	BusinessClientContactServiceImpl bccService;
	
	//PARSING DA ENTITA' A DATAOBJECTMODEL
	public BusinessClientContactDTO createBusinessClientContactFE(BusinessClientContact bcc) {
		return BusinessClientContactDTO.build()
				.setPhoneNumber(bcc.getPhoneNumber())
				.setEmail(bcc.getEmail())
				.setPec(bcc.getPec());
	}
	
	//PARSING DA DATAOBJECTMODEL A ENTITA'
	public BusinessClientContact parseBusinessClientContact(BusinessClientContactDTO businessClientContact) {
		var businessClientContactEntity = BusinessClientContact.build()
				.setEmail(businessClientContact.getEmail())
				.setPec(businessClientContact.getPec())
				.setPhoneNumber(businessClientContact.getPhoneNumber());
		return businessClientContactEntity;
	}
}
