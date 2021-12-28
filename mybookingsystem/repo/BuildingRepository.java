package it.mybookingsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.mybookingsystem.model.Building;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long>{
	
}
