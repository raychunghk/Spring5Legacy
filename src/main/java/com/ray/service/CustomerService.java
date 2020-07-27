package com.ray.service;

import com.ray.entity.Customer;


import java.util.List;

public interface CustomerService {

	public List<Customer> getCustomers();

	void saveCustomer(Customer customer);

	Customer getCustomer(int id);

	void deleteCustomer(int id);
}
