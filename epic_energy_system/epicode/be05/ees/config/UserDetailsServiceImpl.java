package it.epicode.be05.ees.config;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import it.epicode.be05.ees.repo.UserRepo;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepo repo;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		var user = repo.findByUsername(username).orElseThrow();
		var appUser = UserDetailsImpl.build(user);
		return appUser;
	}
}
