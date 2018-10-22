package com.mrk.sbr.model;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.List;


/**
 * The persistent class for the types database table.
 * 
 */
@Entity
@Table(name="types")
@NamedQuery(name="Type.findAll", query="SELECT t FROM Type t")
public class Type implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String name;

	//bi-directional many-to-one association to Account
	@OneToMany(cascade = CascadeType.ALL, mappedBy="type")
	//@OneToMany(cascade = {CascadeType.ALL,CascadeType.PERSIST,CascadeType.MERGE}, mappedBy="type")
	@JsonManagedReference(value="type-account")
	private List<Account> accounts;

	public Type() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Account> getAccounts() {
		return this.accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public Account addAccount(Account account) {
		getAccounts().add(account);
		account.setType(this);

		return account;
	}

	public Account removeAccount(Account account) {
		getAccounts().remove(account);
		account.setType(null);

		return account;
	}

}