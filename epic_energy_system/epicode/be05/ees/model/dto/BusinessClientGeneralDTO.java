package it.epicode.be05.ees.model.dto;

import java.util.List;

public class BusinessClientGeneralDTO {

	private BusinessClientDTO businessClient;
	private BusinessClientContactDTO businessContact;
	private List<OfficeAddressDTO> officeAddress;
	private AccountManagerDTO accountManager;
	
	public BusinessClientDTO getBusinessClient() {
		return businessClient;
	}
	public BusinessClientGeneralDTO setBusinessClient(BusinessClientDTO businessClient) {
		this.businessClient = businessClient;
		return this;
	}
	public BusinessClientContactDTO getBusinessContact() {
		return businessContact;
	}
	public BusinessClientGeneralDTO setBusinessContact(BusinessClientContactDTO businessContact) {
		this.businessContact = businessContact;
		return this;
	}
	
	public List<OfficeAddressDTO> getOfficeAddress() {
		return officeAddress;
	}
	public BusinessClientGeneralDTO setOfficeAddress(List<OfficeAddressDTO> officeAddress) {
		this.officeAddress = officeAddress;
		return this;
	}
	
	public AccountManagerDTO getAccountManager() {
		return accountManager;
	}
	public BusinessClientGeneralDTO setAccountManager(AccountManagerDTO accountManager) {
		this.accountManager = accountManager;
		return this;
	}
	
	public static BusinessClientGeneralDTO build() {
		
		return new BusinessClientGeneralDTO();
	}
	
}
