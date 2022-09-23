package com.training.services;

import static java.util.stream.Collectors.toList;



import static java.util.stream.Collectors.toMap;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import java.util.stream.Collectors;
import org.apache.logging.log4j.*;

import com.example.demo.utils.ConnectionFactory;
import com.training.entity.PersonalDetails;
import com.training.exceptions.ElementNotFoundException;
import com.training.repos.ManagementRepository;

public class ManagementService {
	
    
	ManagementRepository repo= new ManagementRepository(); 
	private static final Logger logger=LogManager.getRootLogger();
	
	   public ManagementService() {
			super();
			this.repo = repo;
		}
    
	public String add(PersonalDetails obj) {
		boolean result=repo.save(obj);
		if(!result) {
			logger.error("Adding Employee : "+result);
			return "Enter Correct Employee credentials";
		}
		else {
			logger.info("Adding Employee : "+result);
			return result+"  ---one row Added";
		}
	
    }
	
   public void findByFirstName(String firstName) throws ElementNotFoundException  {
	   Collection<PersonalDetails> list=repo.findByFirstName(firstName);
	if(list.size()==0) {
		throw new ElementNotFoundException("ERR-102","No matches with first Name:"+firstName);
	}
	else {
		list.forEach(e->logger.info(e));
	}
   }
	
    public void findByFnamePhone() throws ElementNotFoundException  {
    	 Collection<String> list=repo.findByFnamePhone();
    	
    	if(list.size()==0) {
    		throw new ElementNotFoundException("ERR-102","No matcheds with first Name  and Phone Number ");
    	}
    	else {
    		list.forEach(e->logger.info(e));
    	}
    }  
    
      public void findByDob(LocalDate dob) throws ElementNotFoundException  {
    	  Collection<String> list=repo.findByDob(dob);
    	 
    	if(list.size()==0) {
    		throw new ElementNotFoundException("ERR-102","No matches with date of Birth "+dob);
    	}
    	else {
    		list.forEach(e->logger.info(e));
    	}
    }   
    
      public void findByWed(LocalDate weddingDate) throws ElementNotFoundException  {
      	
    	  Collection<String> list=repo.findByWed(weddingDate);
    	if(list.size()==0) {
    		throw new ElementNotFoundException("ERR-102","No matches With wedding date "+weddingDate);
    	}
    	else {
    		list.forEach(e->logger.info(e));
    	}
    }   
    	
	

   public String update(String firstName,String email,long phoneNumber) throws ElementNotFoundException {
		boolean result=false;
		result = repo.updateEmailPhone(firstName,email,phoneNumber);
		if(!result) {
			logger.error("Updated one Employee : "+result);
			throw new ElementNotFoundException("ERR-102","No matches with first name"+firstName);
		}
		else {
			logger.info("Updated one Employee : "+result);
			return result+"   ---row updated";
			
		}
		
	
    } 
 

	public String delete(String firstName) throws ElementNotFoundException {
		boolean result= repo.delete(firstName);
		if(!result) {
			logger.error("Deleted one Employee : "+result);
			throw new ElementNotFoundException("ERR-102","No matches with first name"+firstName);
		}
		else {
			logger.info("Deleted one Employee : "+result);
			return result+"   --one row deleted";
		}
			
    } 
    	
}
