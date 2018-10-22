package com.mrk.sbr.service;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.mrk.sbr.model.Account;
import com.mrk.sbr.model.Customer;

public interface FinanceService {

	public void saveCustomer(Customer customer) throws DataAccessException;
	
	Collection<Customer> findCustomerByLastName(String lastName) throws DataAccessException;
    
	Collection<Customer> findAllCustomers() throws DataAccessException;

	public void saveAccount(Account account) throws DataAccessException;

}