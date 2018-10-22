package com.mrk.sbr.model;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.Date;


/**
 * The persistent class for the account database table.
 * 
 */
@Entity
@NamedQuery(name="Account.findAll", query="SELECT a FROM Account a")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name="acc_creation_date")
	private Date accCreationDate;

	@Column(name="acc_number")
	private String accNumber;

	//bi-directional many-to-one association to Customer
	@JsonBackReference(value="customer-account")
	@JoinColumn(name = "customer_id")
	@ManyToOne
	private Customer customer;

	//bi-directional many-to-one association to Type
	@JsonBackReference(value="type-account")
	@JoinColumn(name = "type_id")	
	@ManyToOne
	private Type type;

	public Account() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getAccCreationDate() {
		return this.accCreationDate;
	}

	public void setAccCreationDate(Date accCreationDate) {
		this.accCreationDate = accCreationDate;
	}

	public String getAccNumber() {
		return this.accNumber;
	}

	public void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Type getType() {
		return this.type;
	}

	public void setType(Type type) {
		this.type = type;
	}

}