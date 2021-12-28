package it.epicode.be05.ees.service.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.epicode.be05.ees.model.entity.BusinessClient;
import it.epicode.be05.ees.model.entity.BusinessClientContact;
import it.epicode.be05.ees.repo.BusinessClientContactRepo;
import it.epicode.be05.ees.service.interfaces.derivate.BusinessClientContactService;

@Service
public class BusinessClientContactServiceImpl implements BusinessClientContactService {

	@Autowired
	BusinessClientContactRepo repo;
	
	@Override
	public void create(BusinessClientContact entity) {
		repo.save(entity);
		
	}

	@Override
	public BusinessClientContact readById(long id) {
		return repo.findById(id).orElseThrow();
	}

	@Override
	public Page<BusinessClientContact> readAll(Pageable pageable) {
		return repo.findAll(pageable);
	}

	@Override
	public List<BusinessClientContact> readAll() {
		return (List<BusinessClientContact>) repo.findAll();
	}

	@Override
	public BusinessClientContact update(long id, BusinessClientContact entity) {
		var bcc = readById(id);
		bcc
		.setEmail(entity.getEmail())
		.setPec(entity.getPec())
		.setPhoneNumber(entity.getPhoneNumber());
		
	return repo.save(bcc);
	}

	@Override
	public void delete(long id) {
		repo.deleteById(id);
		
	}

	@Override
	public BusinessClientContact findByBusinessClient(BusinessClient bc) {
		return repo.findByBusinessClient(bc);
	}

	@Override
	public BusinessClientContact updateBusinessClientContact(long id, BusinessClientContact entity, long idBusinessClient) {
		BusinessClient bc = readById(id).getBusinessClient();
		delete(id);
		var am = BusinessClientContact.build()
				.setBusinessClient(bc)
				.setEmail(entity.getEmail())
				.setPec(entity.getPec())
				.setPhoneNumber(entity.getPhoneNumber());
		
	return repo.save(am);
	}

}
