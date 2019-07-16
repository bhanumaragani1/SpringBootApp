package com.starter.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starter.model.Customer;
import com.starter.repo.CustomerRepository;
import com.starter.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService{

	@Autowired
	private CustomerRepository repo;
	
	@Transactional
	public Integer saveCustomer(Customer c) {
		/*
		 * Customer cust = repo.save(c); return cust.getCustId();
		 */
		return repo.save(c).getCustId();
	}

	@Transactional
	public List<Customer> getAllCustomers() {
		/*
		 * List<Customer> list = repo.findAll(); return list;
		 */
		return repo.findAll();
	}

	@Transactional
	public Customer getOneCustomer(Integer custId) {
		Optional<Customer> c= repo.findById(custId);
		if(c.isPresent()) {
			return c.get();
		}
		return null;
	}

	@Transactional
	public void deleteCustomer(Integer custId) {
		repo.deleteById(custId);
	}
	

}
