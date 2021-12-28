package it.mybookingsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.mybookingsystem.model.Role;
import it.mybookingsystem.repo.RoleRepository;
import it.mybookingsystem.service.interfaces.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleRepository repo;
	
	@Override
	public void create(Role entity) {
		repo.save(entity);
	}

	@Override
	public Role readById(long id) {
		return repo.getById(id);
	}

	@Override
	public Page<Role> readAll(Pageable pageable) {
		return repo.findAll(pageable);
	}

	@Override
	public List<Role> readAll() {
		return repo.findAll();
	}

	@Override
	public void update(long id, Role entity) {
		var role =readById(id)
		.setRoleType(entity.getRoleType());
		repo.save(role);
	}

	@Override
	public void delete(long id) {
		repo.deleteById(id);		
	}

}
