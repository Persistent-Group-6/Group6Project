package com.psl.training.test;

import java.util.List;

import com.psl.training.bean.Customer;
import com.psl.training.service.CustomerService;

public class Tester {
	public static void main(String[] args) {
		CustomerService c = new CustomerService();
		List<Customer> l= c.getCustomers();
		for (Customer customer : l) {
			System.out.println(customer.getCity());
		}
	}
}
