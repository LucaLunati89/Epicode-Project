package it.mybookingsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.mybookingsystem.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long>{

}
