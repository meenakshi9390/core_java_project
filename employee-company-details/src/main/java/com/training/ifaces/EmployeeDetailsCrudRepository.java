package com.training.ifaces;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import com.training.entity.PersonalDetails;
import com.training.exceptions.ElementNotFoundException;

public interface EmployeeDetailsCrudRepository extends CrudRepository<PersonalDetails> {
	
	
	public Collection<String> findByFnamePhone() throws ElementNotFoundException;
	public Collection<String> findByDob(LocalDate dob) throws ElementNotFoundException;
	public Collection<String> findByWed(LocalDate weddingDate) throws ElementNotFoundException;
	public Collection<PersonalDetails> findByFirstName(String firstName) throws ElementNotFoundException;
	public boolean updateEmailPhone(String firstName,String email,long phoneNumber) throws ElementNotFoundException;
	public boolean delete(String firstName) throws ElementNotFoundException;

}
