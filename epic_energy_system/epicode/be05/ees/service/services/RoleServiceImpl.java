package it.epicode.be05.ees.service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.epicode.be05.ees.model.entity.security.Role;
import it.epicode.be05.ees.repo.RoleRepo;
import it.epicode.be05.ees.service.interfaces.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepo repo;
	
	@Override
	public void create(Role entity) {
		repo.save(entity);
		
	}

	@Override
	public Role readById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Role> readAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role update(long id, Role entity) {
		return null;
		
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

}
