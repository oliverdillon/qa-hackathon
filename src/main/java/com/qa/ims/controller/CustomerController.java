package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.utils.Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Takes in customer details for CRUD functionality
 *
 */
public class CustomerController{

	public static final Logger LOGGER = LogManager.getLogger();

	private CustomerDAO customerDAO;

	public CustomerController(CustomerDAO customerDAO) {
		super();
		this.customerDAO = customerDAO;
	}

	/**
	 * Reads all customers to the logger
	 */
	public List<Customer> readAll() {
		List<Customer> customers = customerDAO.readAll();
		for (Customer customer : customers) {
			LOGGER.info(customer);
		}
		return customers;
	}

	/**
	 * Creates a customer by taking in user input
	 */
	public Customer create(String firstName, String surname, String emailAddress, String phoneNumber ) {
		String name = firstName + ' ' + surname;
		boolean correctEmailFormat = CheckEmailFormat(emailAddress);
		if(!correctEmailFormat){
			LOGGER.error("Error - Please enter a Valid Email Address");
		}
		Customer customer = customerDAO.create(new Customer(name, emailAddress,phoneNumber));
		LOGGER.info("Customer created");
		return customer;
	}

	// Checks email format and returns boolean if it is in a correct format
	public boolean CheckEmailFormat(String emailAddress){
		Pattern pattern = Pattern.compile("[a-zA-Z]+@{1}[a-zA-z]*\\.[a-zA-Z]+", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(emailAddress);
		return matcher.find();
	}

	/**
	 * Updates an existing customer by taking in user input
	 */
	public Customer update(Long id, String firstName, String surname, String emailAddress, String phoneNumber) {
		String name = firstName + ' ' + surname;
		boolean correctEmailFormat = CheckEmailFormat(emailAddress);
		if(!correctEmailFormat){
			LOGGER.error("Error - Please enter a Valid Email Address");
		}
		Customer customer = customerDAO.update(new Customer(id, name, emailAddress,phoneNumber));
		LOGGER.info("Customer created");
		return customer;
	}

	/**
	 * Deletes an existing customer by the id of the customer
	 * 
	 * @return
	 */
	public int delete(Long id) {
		return customerDAO.delete(id);
	}

}
