package it.epicode.be05.ees.service.interfaces;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Pageable;

import it.epicode.be05.ees.model.entity.BusinessClient;

public interface BusinessClientService extends CrudService<BusinessClient>{
	
	/*ORDINA IN BASE ALL'ATTRIBUTO */
	public List<BusinessClient>order(Integer pageNo, Integer pageSize, String sortBy, String direction );

	/*METODI FILTRO*/
	public List<BusinessClient> byRevenue(Integer pageNo, Integer pageSize, String from, boolean direction);
	public List<BusinessClient> betweenRevenue(Integer pageNo, Integer pageSize, String from, String to);
	
	public List<BusinessClient> byLastContact(Pageable pageable, LocalDate lastContact);
	public List<BusinessClient> byFirstContact(Pageable pageable, LocalDate firstContact);
	public List<BusinessClient> byBusinessNameContains(Pageable pageable, String businessName);
	
	public List<BusinessClient> byProvinceName(Pageable pageable, String province);
	
	/*METODO RICERCA PER NOME*/
	public BusinessClient findByName(String businessName);
	
	
}
