package it.epicode.be05.ees.service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.epicode.be05.ees.model.entity.BusinessClient;
import it.epicode.be05.ees.model.entity.OfficeAddress;
import it.epicode.be05.ees.model.util.OfficeType;
import it.epicode.be05.ees.repo.OfficeAddressRepo;
import it.epicode.be05.ees.service.interfaces.derivate.OfficeAddressService;

@Service
public class OfficeAddressServiceImpl implements OfficeAddressService {

	@Autowired
	OfficeAddressRepo repo;
	
	@Override
	public void create(OfficeAddress entity) {
		repo.save(entity);
		
	}

	@Override
	public OfficeAddress readById(long id) {
		return repo.findById(id).orElseThrow();
	}

	@Override
	public Page<OfficeAddress> readAll(Pageable pageable) {
		return repo.findAll(pageable);
	}

	@Override
	public List<OfficeAddress> readAll() {
		return (List<OfficeAddress>) repo.findAll();

	}

	@Override
	public OfficeAddress update(long id, OfficeAddress entity) {
		
		var oa = readById(id);
		
		oa 
		 .setCivicNumber(entity.getCivicNumber())
		 .setNameAddress(entity.getNameAddress())
		 .setPlace(entity.getPlace())
		 .setZIPCode(entity.getZIPCode())
		 .setType(entity.getType())
		 .setCommune(entity.getCommune())
		 .setType(entity.getType());
		
		return repo.save(oa);
		
	}

	@Override
	public void delete(long id) {
		repo.deleteById(id);
		
	}

	@Override
	public List<OfficeAddress> findByBusinessClient(BusinessClient bc) {
		return repo.findByBusinessClient(bc);
	}

	@Override
	public List<OfficeAddress> findByType(Pageable pageable, OfficeType type) {
		return repo.findByType(pageable, type);
	}

	@Override
	public List<OfficeAddress> findByProvince(Pageable pageable, String name) {
		return repo.findByCommuneProvinceName(pageable, name);
	}


	
}
