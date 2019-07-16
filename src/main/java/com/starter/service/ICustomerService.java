package com.starter.service;

import java.util.List;

import com.starter.model.Customer;

public interface ICustomerService {

	public Integer saveCustomer(Customer c);
	public List<Customer> getAllCustomers();
	public Customer getOneCustomer(Integer custId);
	public void deleteCustomer(Integer custId);
}

