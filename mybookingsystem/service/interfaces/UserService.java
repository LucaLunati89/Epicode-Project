package it.mybookingsystem.service.interfaces;

import java.time.LocalDate;
import java.util.List;

import it.mybookingsystem.model.User;
import it.mybookingsystem.model.WorkStation;
import it.mybookingsystem.util.City;
import it.mybookingsystem.util.Type;

public interface UserService extends CrudService<User> {
 public boolean bookWorkStation(long idUser, long idWorkStation, LocalDate date);
 public List<WorkStation> findWorkStations(Type type, City city);
 public boolean hasNoPrenotationForThisDate(long idUser, LocalDate date);
}
