package it.mybookingsystem.runners;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import it.mybookingsystem.model.Role;
import it.mybookingsystem.model.Role.RoleType;
import it.mybookingsystem.model.User;
import it.mybookingsystem.service.interfaces.RoleService;
import it.mybookingsystem.service.interfaces.UserService;

@Component
public class EnsureUsers {
	
	private static final Logger log = LoggerFactory.getLogger(EnsureUsers.class);
	
	@Autowired
	UserService service;
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	PasswordEncoder encoder;
	
	
	private List<User> instanceUsers(){
		saveRoles();
		log.info("%%%CREAZIONE ISTANZE USER%%%");
		String hashedPassword = encoder.encode("password");
		List<User> users = new ArrayList<>();
		User u1 = User.builder()
				.setUserName("LL")
				.setFirstName("Luca")
				.setLastName("Lunati")
				.setEmail("luca_lunati@email.it")
				.setPassword(hashedPassword)
				.setRoles(roles());
				
				
		User u2 = User.builder()
				.setUserName("MR")
				.setFirstName("Mario")
				.setLastName("Rossi")
				.setEmail("mario_rossi@email.it")
				.setRoles(user());
		User u3 = User.builder()
				.setUserName("GG")
				.setFirstName("Giulia")
				.setLastName("Gabrini")
				.setEmail("giulia_gabrini@email.it");
		users.add(u1);
		users.add(u2);
		users.add(u3);
		return users;
	}
	
	public void ensureUsers() {
		for(User u : instanceUsers()) {
			log.debug("STO INSERENDO L'{}", u);
			service.create(u);
			log.debug("HO INSERITO L'{}", u);
		}
	}
	
	public Set<Role> roles(){
		Set<Role> roles = new HashSet<>();
		roles.add(roleService.readById(1));
		roles.add(roleService.readById(2));
		
		
		return roles;
	}
	
	public Set<Role> user(){
		Set<Role> roles = new HashSet<>();
		roles.add(roleService.readById(1));
		
		return roles;
	}
	
	
	
	public void saveRoles() {
		var admin = new Role().setRoleType(RoleType.ADMIN);
		var user = new Role().setRoleType(RoleType.USER);
		roleService.create(admin);
		roleService.create(user);
	}
}
