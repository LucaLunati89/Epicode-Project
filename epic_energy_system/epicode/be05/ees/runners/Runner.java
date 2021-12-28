package it.epicode.be05.ees.runners;




import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.security.crypto.password.PasswordEncoder;


import it.epicode.be05.ees.model.entity.security.Role;
import it.epicode.be05.ees.model.entity.security.Role.RoleType;
import it.epicode.be05.ees.model.entity.security.User;
import it.epicode.be05.ees.model.util.Anagrafic;
import it.epicode.be05.ees.service.interfaces.BusinessClientService;
import it.epicode.be05.ees.service.interfaces.CommuneService;
import it.epicode.be05.ees.service.interfaces.RoleService;
import it.epicode.be05.ees.service.interfaces.UserService;


@Component
public class Runner implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(Runner.class);
	
	@Autowired
	Anagrafic anagrafic;
	
	@Autowired
	EnsureBusinessClient bc;
	
	@Autowired
	EnsureAccountManager ac;
	
	@Autowired
	EnsureBusinessClientContact bcc;
	
	@Autowired
	EnsureOfficeAddress oa;
	
	@Autowired
	BusinessClientService bcService;
	
	@Autowired
	UserService uService;
	
	@Autowired
	RoleService rService;
	
	@Autowired
	CommuneService cService;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Override
	public void run(String... args) throws Exception {
		
		var clients = 10;
		log.info("Creazione clienti Business");
		bc.createBusinessClient(clients);
		
		String hashedPassword = encoder.encode("password");
		var admin = new Role().setRoleType(RoleType.ADMIN);
		var user = new Role().setRoleType(RoleType.USER);
		
		rService.create(admin);
		rService.create(user);
		
		Set<Role> roles = new HashSet<>();
		roles.add(admin);
		roles.add(user);
		
		var user1 = User.build()
				.setFirstName("Luca")
				.setLastName("Lunati")
				.setUserName("LL")
				.setPassword(hashedPassword)
				.setEmail("luca_lunati@email.it")
				.setRoles(roles);
		
		log.info("Creazione clienti Business");
		uService.create(user1);
		log.info(user1.toString());
		
		ac.createAccountManager(clients);
		bcc.createBusinessClientContactService(clients);
		oa.createOfficeAddressLegal(clients);
		oa.createOfficeAddressOperational(clients); 
		 
		anagrafic.readFile();
		//var a = cService.findByName("chieri");
		//log.info(a.toString());
		
	}

}
