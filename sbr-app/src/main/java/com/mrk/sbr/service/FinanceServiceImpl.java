package com.mrk.sbr.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrk.sbr.model.Account;
import com.mrk.sbr.model.Customer;
import com.mrk.sbr.repository.AccountRepository;
import com.mrk.sbr.repository.CustomerRepository;

@Service
public class FinanceServiceImpl implements FinanceService  {
	
	private CustomerRepository customerRepository;
	private AccountRepository accountRepository;

	
    @Autowired
    public FinanceServiceImpl(CustomerRepository customerRepository, AccountRepository accountRepository) {
        this.customerRepository = customerRepository;
        this.accountRepository = accountRepository;
    }	
    
    @Transactional
    public void saveCustomer(Customer customer) throws DataAccessException {
    	customerRepository.save(customer);
    }
    
    @Transactional(readOnly = true)
    public Collection<Customer> findCustomerByLastName(String lastName) throws DataAccessException {
        return customerRepository.findByLastName(lastName);
    }
      
    @Transactional(readOnly = true)
    public Collection<Customer> findAllCustomers() throws DataAccessException {
        return customerRepository.findAll();
    }
    
    @Transactional
    public void saveAccount(Account account) throws DataAccessException {
    	accountRepository.save(account);
    }
}