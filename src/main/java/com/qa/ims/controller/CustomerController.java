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
public class CustomerController implements CrudController<Customer> {

	public static final Logger LOGGER = LogManager.getLogger();

	private CustomerDAO customerDAO;
	private Utils utils;

	public CustomerController(CustomerDAO customerDAO, Utils utils) {
		super();
		this.customerDAO = customerDAO;
		this.utils = utils;
	}

	/**
	 * Reads all customers to the logger
	 */
	@Override
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
	@Override
	public Customer create() {
		LOGGER.info("Please enter a first name");
		String firstName = utils.getString();
		LOGGER.info("Please enter a surname");
		String surname = utils.getString();
		String name = firstName + ' ' + surname;
		LOGGER.info("Please enter an email Address");
		String emailAddress = utils.getString();
		boolean correctEmailFormat = CheckEmailFormat(emailAddress);
		while(!correctEmailFormat){
			LOGGER.error("Error - Please enter a Valid Email Address");
			LOGGER.info("Please enter an email Address");
			emailAddress = utils.getString();
			correctEmailFormat = CheckEmailFormat(emailAddress);
		}
		LOGGER.info("Please enter an Phone Number");
		String phoneNumber = utils.getString();
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
	@Override
	public Customer update() {
		LOGGER.info("Please enter a first name");
		String firstName = utils.getString();
		LOGGER.info("Please enter a surname");
		String surname = utils.getString();
		String name = firstName + ' ' + surname;
		LOGGER.info("Please enter an email Address");
		String emailAddress = utils.getString();
		boolean correctEmailFormat = CheckEmailFormat(emailAddress);
		while(!correctEmailFormat){
			LOGGER.error("Error - Please enter a Valid Email Address");
			LOGGER.info("Please enter an email Address");
			emailAddress = utils.getString();
			correctEmailFormat = CheckEmailFormat(emailAddress);
		}
		LOGGER.info("Please enter an Phone Number");
		String phoneNumber = utils.getString();
		Customer customer = customerDAO.create(new Customer(name, emailAddress,phoneNumber));
		LOGGER.info("Customer created");
		return customer;
	}

	/**
	 * Deletes an existing customer by the id of the customer
	 * 
	 * @return
	 */
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the customer you would like to delete");
		Long id = utils.getLong();
		return customerDAO.delete(id);
	}

}
