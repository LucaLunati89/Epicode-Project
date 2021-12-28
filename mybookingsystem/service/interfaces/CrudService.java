package it.mybookingsystem.service.interfaces;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CrudService<T> {

	void create(T entity);
	
	T readById(long id);
	
	Page<T> readAll(Pageable pageable);
	
	 List<T>readAll();
	
	void update(long id, T entity);
	
	void delete(long id);
}
