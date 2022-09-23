package com.training.ifaces;
import java.time.LocalDate;
import java.util.Collection;
import com.training.exceptions.ElementNotFoundException;
public interface CrudRepository<T> {
	
	public boolean save(T obj);
	public Collection<T> findAll();
}
