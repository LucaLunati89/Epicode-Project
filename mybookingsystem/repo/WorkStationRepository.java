package it.mybookingsystem.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.mybookingsystem.model.User;
import it.mybookingsystem.model.WorkStation;
import it.mybookingsystem.util.City;
import it.mybookingsystem.util.Type;

@Repository
public interface WorkStationRepository extends JpaRepository<WorkStation, Long>{

	/**@note trova una Stazione dal tipo di postazione e dalla città*/
	public List<WorkStation> findWorkStationByTypeAndBuildingCity(Type type, City city);
	/**@note trova una Stazione dall'utente che l'ha prenotata*/
	public WorkStation findWorkStationByUser(User user);
	
}
