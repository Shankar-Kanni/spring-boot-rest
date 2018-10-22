package com.mrk.sbr.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mrk.sbr.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	List<Customer> findByLastName(String lastName);
	

}
