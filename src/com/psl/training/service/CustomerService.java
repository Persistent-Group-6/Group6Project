package com.psl.training.service;

import java.sql.SQLException;
import java.util.List;

import com.psl.training.dao.CustomerDAO;
import com.psl.training.bean.Customer;
public class CustomerService {
	CustomerDAO cumDao=new CustomerDAO();
	
	
	public void insertCustomer(Customer e){
		cumDao.insertCustomer(e);
	}
	
	public Customer getCustomerById(int id){
		return cumDao.getCustomerById(id);
	}
	
	public List<Customer> getCustomers(){
		return cumDao.getCustomers();
		// fetch all Customers from db;
	}
	
	public void updateCustomerById(Customer c) throws SQLException{
		// code to update Customer object
			cumDao.updateCustomerById(c);
	}
	
	public String deleteCustomerById(int id){
		// delete Customer from DB with matching id
			return cumDao.deleteCustomerById(id);
				
	}

}
