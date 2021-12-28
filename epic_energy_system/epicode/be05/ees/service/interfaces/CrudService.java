package it.epicode.be05.ees.service.interfaces;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CrudService<T>  {

	void create(T entity);
	T readById(long id);
	List<T>readAll();
	Page<T> readAll(Pageable pageable);
	T update(long id, T entity);
	void delete(long id);
}
