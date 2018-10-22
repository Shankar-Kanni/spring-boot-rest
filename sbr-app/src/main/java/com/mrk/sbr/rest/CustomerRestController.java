package com.mrk.sbr.rest;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mrk.sbr.model.Customer;
import com.mrk.sbr.service.FinanceService;


@RestController
public class CustomerRestController {
	
	@Autowired
	private FinanceService financeService;
    
    @RequestMapping(value = "/customers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Collection<Customer>> getCustomers(){
    	Collection<Customer> customers = this.financeService.findAllCustomers();
    	return new ResponseEntity<Collection<Customer>>(customers, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/addCustomer", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Customer> addCustomer(@RequestBody @Valid Customer customer){
    	this.financeService.saveCustomer(customer);
    	return new ResponseEntity<Customer>(customer, HttpStatus.CREATED);
    }
    
    

}