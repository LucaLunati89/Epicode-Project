package it.epicode.be05.ees.service.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import it.epicode.be05.ees.model.entity.BusinessClient;
import it.epicode.be05.ees.repo.BusinessClientRepo;
import it.epicode.be05.ees.service.interfaces.BusinessClientService;
import it.epicode.be05.ees.service.interfaces.InvoiceService;
import it.epicode.be05.ees.service.interfaces.derivate.AccountManagerService;
import it.epicode.be05.ees.service.interfaces.derivate.BusinessClientContactService;
import it.epicode.be05.ees.service.interfaces.derivate.OfficeAddressService;

@Service
public class BusinessClientServiceImpl implements BusinessClientService{

	@Autowired
	BusinessClientRepo repo;
	
	@Autowired
	AccountManagerService amService;
	
	@Autowired
	OfficeAddressService oaService;
	
	@Autowired
	BusinessClientContactService bccService;
	
	@Autowired
	InvoiceService iService;
	
	/*CRUD METHOD*/

	@Override
	public void create(BusinessClient entity) {
		repo.save(entity);		
	}

	
	@Override
	public BusinessClient readById(long id) {
		return  repo.findById(id).orElseThrow();
	}

	@Override
	public Page<BusinessClient> readAll(Pageable pageable) {
		return repo.findAll(pageable);
	}

	@Override
	public List<BusinessClient> readAll() {
		return (List<BusinessClient>) repo.findAll();
	}

	@Override
	public BusinessClient update(long id, BusinessClient entity) {
		return null;

	}

	@Override
	public void delete(long id) {
		
	var invoices = iService.findByBusinessClient(readById(id));
	for(var i : invoices) {
		iService.delete(i.getId());
	}
	amService.delete(amService.findByBusinessClient(readById(id)).setBusinessClient(null).getId());    
	bccService.delete(bccService.findByBusinessClient(readById(id)).setBusinessClient(null).getId());	
	var adresses = oaService.findByBusinessClient(readById(id));
	for(var a : adresses) {
		a.setBusinessClient(null);
		oaService.delete(a.getId());
	}
		repo.deleteById(id);

	}

	/*ORDER METHOD*/


	@Override
	public List<BusinessClient> order(Integer pageNo, Integer pageSize, String sortBy, String direction ) {

		Pageable paging = null;

		if(direction.equalsIgnoreCase("asc")) {
			paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending());
		}else if (direction.equalsIgnoreCase("desc"))
			paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());

		Page<BusinessClient> pagedResult = repo.findAll(paging);

		return pagedResult.getContent();
	}

	/*FILTER METHOD*/

	/*REVENUE*/

	@Override
	public List<BusinessClient> betweenRevenue(Integer pageNo, Integer pageSize, String from, String to) {
		Long fromL = Long.parseLong(from);
		Long toL = Long.parseLong(to);
		Pageable paging = PageRequest.of(pageNo, pageSize);
		return repo.betweenRevenue(paging, fromL, toL).stream()
				.sorted(Comparator.comparingLong(BusinessClient::getAnnualRevenue))
				.collect(Collectors.toList());
	}
	@Override
	public List<BusinessClient> byRevenue(Integer pageNo, Integer pageSize, String revenue, boolean direction) {
		Long revenueL = Long.parseLong(revenue);
		Pageable paging = PageRequest.of(pageNo, pageSize);
	
		if(direction) {
			return repo.byRevenueMax(paging, revenueL).stream()
					.sorted(Comparator.comparingLong(BusinessClient::getAnnualRevenue))
					.collect(Collectors.toList());
		}
		else return repo.byRevenueMin(paging, revenueL).stream()
				.sorted(Comparator.comparingLong(BusinessClient::getAnnualRevenue))
				.collect(Collectors.toList());
		
	}

	/*FIRST CONTACT*/
	
	@Override
	public List<BusinessClient> byFirstContact(Pageable pageable, LocalDate firstContact) {
		return repo.byFirstContact(pageable, firstContact);
				
	}

	/*LAST CONTACT*/
	
	@Override
	public List<BusinessClient> byLastContact(Pageable pageable, LocalDate lastContact) {
		
		return repo.byLastContact(pageable, lastContact);
	}
	
	/*PART OF NAME*/
	
	@Override
	public List<BusinessClient> byBusinessNameContains(Pageable pageable, String businessName) {
		
		return repo.findByBusinessNameContaining(pageable, businessName);
	}

	
	/*NAME*/
	
	@Override
	public BusinessClient findByName(String businessName) {
		return repo.findByBusinessName(businessName);
	}


	@Override
	public List<BusinessClient> byProvinceName(Pageable pageable, String province) {
		List<BusinessClient> clients = new ArrayList<>();
		var provinces =oaService.findByProvince(pageable, province);
		for (var p : provinces) {
			clients.add(p.getBusinessClient());
		}
		
		return clients;
	}


	


	


	
	



}
