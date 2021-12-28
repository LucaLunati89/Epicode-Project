package it.epicode.be05.ees.repo;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import it.epicode.be05.ees.model.entity.security.User;

public interface UserRepo extends PagingAndSortingRepository<User, Long>{
	Optional<User> findByUsername(String username);
}
