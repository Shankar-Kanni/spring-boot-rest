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
import com.mrk.sbr.model.Account;
import com.mrk.sbr.model.Customer;
import com.mrk.sbr.service.FinanceService;


@RestController
public class AccountRestController {
	
	@Autowired
	private FinanceService financeService;
    
    @RequestMapping(value = "/accounts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Collection<Account>> getAccounts(){
    	return null;
    }

    @RequestMapping(value = "/addAccount", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Account> addAccount(@RequestBody @Valid Account account){
    	this.financeService.saveAccount(account);
    	return new ResponseEntity<Account>(account, HttpStatus.CREATED);
    }
    
}