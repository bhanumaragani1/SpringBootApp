package com.starter.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.starter.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>
{

}
