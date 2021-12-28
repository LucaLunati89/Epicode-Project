package it.epicode.be05.ees.service.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.epicode.be05.ees.model.dto.BusinessClientGeneralDTO;
import it.epicode.be05.ees.model.entity.BusinessClient;
import it.epicode.be05.ees.service.services.AccountManagerServiceImpl;
import it.epicode.be05.ees.service.services.BusinessClientContactServiceImpl;
import it.epicode.be05.ees.service.services.BusinessClientServiceImpl;
import it.epicode.be05.ees.service.services.OfficeAddressServiceImpl;

@Service
public class BusinessClientGeneralServiceDTO {

	@Autowired
	BusinessClientServiceImpl bcService;
	
	@Autowired
	AccountManagerServiceImpl amService;
	
	@Autowired
	BusinessClientContactServiceImpl bccService;
	
	@Autowired
	OfficeAddressServiceImpl oaService;
	
	@Autowired
	AccountManagerServiceDTO amServiceDTO;
	
	@Autowired
	BusinessClientServiceDTO bcServiceDTO;
	
	@Autowired
	BusinessClientContactServiceDTO bccServiceDTO;
	
	@Autowired
	OfficeAddressServiceDTO oaServiceDTO;
	
	//DALL'OGGETTO JSON CREA LE VARIE ENTITA' E LE SALVA NELLE RISPETTIVE TABELLE
	public void create(BusinessClientGeneralDTO client) {
		
		var businessClient = bcServiceDTO.parseBusinessClient(client.getBusinessClient());
		bcService.create(businessClient);
		var clientById = bcService.findByName(businessClient.getBusinessName());
		amService.create(amServiceDTO.parseAccountManager(client.getAccountManager()).setBusinessClient(clientById));
		bccService.create(bccServiceDTO.parseBusinessClientContact(client.getBusinessContact()).setBusinessClient(clientById));
		var addresses = oaServiceDTO.parseOfficeAddress(client.getOfficeAddress(), clientById);
		for (var a : addresses) {
			oaService.create(a);
		}
		
		
		
	}
	
	//DALLE ENTITA' PARSING IN CLIENTI DTO PER LA RESPONSE
	public List<BusinessClientGeneralDTO> buildJSON( List<BusinessClient> bcClients){
		List<BusinessClientGeneralDTO> clients= new ArrayList<>();
		for(var c : bcClients) {
			var client = BusinessClientGeneralDTO.build()
					.setBusinessClient(bcServiceDTO.createBusinessClientFE(c))
					.setAccountManager(amServiceDTO.createAccountManagerDTO(amService.findByBusinessClient(c)))
					.setBusinessContact(bccServiceDTO.createBusinessClientContactFE(bccService.findByBusinessClient(c)))
					.setOfficeAddress(oaServiceDTO.createOfficeAddressDTO(oaService.findByBusinessClient(c)));
			clients.add(client);
		}
	return clients;
	}
	
	
	//ordina in base al nome dell'attributo che gli passi nel sortBy
	public List<BusinessClientGeneralDTO> order(int pageNo, int size, String sortBy, String direction){
		
		var bcClients = bcService.order(pageNo, size, sortBy, direction);
		return buildJSON(bcClients);
		
	}
	
	//filtra in base al fatturato > o < dell'importo inserito
	public List<BusinessClientGeneralDTO> byRevenue(Integer pageNo, Integer pageSize, String revenue, boolean direction){
		
		var bcClients = bcService.byRevenue(pageNo, pageSize, revenue, direction);
			return buildJSON(bcClients);
	}
	
	//filtra fra due importi di fatturato
	public List<BusinessClientGeneralDTO> betweenRevenue(Integer pageNo, Integer pageSize, String from, String to){
		var bcClients = bcService.betweenRevenue(pageNo, pageSize, from, to);
	return buildJSON(bcClients);
	}

	//filtra dalla data del primo contatto
	public List<BusinessClientGeneralDTO> byFirstContact(Pageable pageable, LocalDate firstContact) {
		var bcClients = bcService.byFirstContact(pageable, firstContact);
		return  buildJSON(bcClients);
		
	}
	
	//filtra dalla data dell'ultimo contatto
	public List<BusinessClientGeneralDTO> byLastContact(Pageable pageable, LocalDate lastContact) {
		var bcClients = bcService.byLastContact(pageable, lastContact);
		return  buildJSON(bcClients);
	}
	
	//filtra da parte del nome
	public List<BusinessClientGeneralDTO> byName(Pageable pageable, String businessName){
		var bcClients = bcService.byBusinessNameContains(pageable, businessName);
		return buildJSON(bcClients);
	}
	
	//filtra per Provincia
	public List<BusinessClientGeneralDTO> byProvince(Pageable pageable, String provinceName){
		var bcClients = bcService.byProvinceName(pageable, provinceName);
		return buildJSON(bcClients);
	}
	
}
