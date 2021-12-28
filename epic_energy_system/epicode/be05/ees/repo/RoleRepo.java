package it.epicode.be05.ees.repo;
import org.springframework.data.repository.PagingAndSortingRepository;

import it.epicode.be05.ees.model.entity.security.Role;

public interface RoleRepo extends PagingAndSortingRepository<Role, Long>{

}
