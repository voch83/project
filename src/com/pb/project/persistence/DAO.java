package com.pb.project.persistence;

import java.util.List;
import com.pb.project.entity.Entity;

public interface DAO<E extends Entity> {
	
	E findById(Integer id);
	
	List<E> findAll();
	
	void insert(E entity);

	void update(E entity);
	
	void delete(E entity);
}
