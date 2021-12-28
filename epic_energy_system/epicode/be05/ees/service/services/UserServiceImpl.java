package it.epicode.be05.ees.service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.epicode.be05.ees.model.entity.security.User;
import it.epicode.be05.ees.repo.UserRepo;
import it.epicode.be05.ees.service.interfaces.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepo repo;

	@Override
	public void create(User entity) {
		repo.save(entity);	
		
	}

	@Override
	public User readById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<User> readAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User update(long id, User entity) {
		return null;
		
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}
	
	/*CRUD METHOD*/
}
