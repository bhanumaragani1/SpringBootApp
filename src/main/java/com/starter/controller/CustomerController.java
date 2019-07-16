package com.starter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.starter.model.Customer;
import com.starter.service.ICustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private ICustomerService service;
	
	@RequestMapping("/reg")
	private String showreg(Model map) {
		map.addAttribute("customer", new Customer());
		return "Register";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveData(@ModelAttribute Customer cust, Model map) {
		
		Integer id = service.saveCustomer(cust);	
		map.addAttribute("message", "customer '"+id+"' created");
		map.addAttribute("customer", new Customer());
		return "Register";
	}
	
	@RequestMapping("/all")
	public String showAll(Model map) {
		List<Customer> cobs = service.getAllCustomers();
		
		map.addAttribute("list", cobs);
		return "Data";
		
	}
	
	@RequestMapping("/view/{id}")
	public String viewOne(
			@PathVariable Integer id,
			Model map) 
	{
		Customer c=service.getOneCustomer(id);
		map.addAttribute("ob", c);
		return "View";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteOne(
			@PathVariable Integer id,
			Model map) 
	{
		service.deleteCustomer(id);
		//fetch all new data
		List<Customer> cobs=service.getAllCustomers();
		//send data to UI
		map.addAttribute("list", cobs);
		//success message 
		map.addAttribute("message", "Customer '"+id+"' deleted");
		return "Data";
	}
}

