package it.epicode.be05.ees.service.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.be05.ees.model.dto.OfficeAddressDTO;
import it.epicode.be05.ees.model.entity.BusinessClient;
import it.epicode.be05.ees.model.entity.OfficeAddress;
import it.epicode.be05.ees.service.interfaces.CommuneService;
import it.epicode.be05.ees.service.services.OfficeAddressServiceImpl;

@Service
public class OfficeAddressServiceDTO {

	@Autowired
	OfficeAddressServiceImpl oaService;
	
	@Autowired
	CommuneService cService;
	
	//PARSING DA ENTITA' A DATAOBJECTMODEL
	public List<OfficeAddressDTO> createOfficeAddressDTO(List<OfficeAddress> addresses){
	List<OfficeAddressDTO> addressesDTO = new ArrayList<>();
		for(var a : addresses) {
			var address = OfficeAddressDTO.build()
					.setNameAddress(a.getNameAddress())
					.setCivicNumber(a.getCivicNumber())
					.setPlace(a.getPlace())
					.setZIPCode(a.getZIPCode())
					.setType(a.getType())
					.setCommuneName(a.getCommune().getCommune())
					.setProvinceName(a.getCommune().getProvince().getName());
			addressesDTO.add(address);
		}
		
		return addressesDTO;
	}
	
	//PARSING DA DATAOBJECTMODEL A ENTITA'
	public List<OfficeAddress> parseOfficeAddress(List<OfficeAddressDTO> officeAddress, BusinessClient bc){
		List<OfficeAddressDTO> adresses = officeAddress;
		List<OfficeAddress> entity = new ArrayList<>();
		for(var a : adresses) {
			var address = OfficeAddress.build()
					.setNameAddress(a.getNameAddress())
					.setCivicNumber(a.getCivicNumber())
					.setZIPCode(a.getZIPCode())
					.setPlace(a.getPlace())
					.setType(a.getType())
					.setCommune(cService.findByName(a.getCommuneName()))
					.setBusinessClient(bc);
			entity.add(address);
			}
		return entity;
	}
	


}
