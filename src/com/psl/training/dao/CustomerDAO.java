package com.psl.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.psl.training.bean.Customer;
import com.psl.training.util.DBConnection;

public class CustomerDAO {
Connection cn=DBConnection.getConnection();
	
	//CRUD
	public void insertCustomer(Customer c){
		// code to insert Customer
		
		try {
			PreparedStatement	pstmt = cn.prepareStatement("insert into Customers values(?,?,?,?,?,?,?)");
			
			pstmt.setInt(1, c.getCustomerNumber());
			pstmt.setString(2, c.getCustomerName());
			pstmt.setString(3, c.getHomePhone());
			pstmt.setString(4, c.getWorkPhone());
			pstmt.setString(5, c.getStreet());
			pstmt.setString(5, c.getCity());
			pstmt.setString(6, c.getState());
			pstmt.setString(7, c.getZip());
			pstmt.executeUpdate();
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
	
	// Statement PreparedStatement CallableStatement
	
	public Customer getCustomerById(int id){
		Customer c=null;
		try{
			Statement stmt=cn.createStatement();
		String qry="select * from Customers where customerNumber="+id;
		ResultSet rs=stmt.executeQuery(qry);
		if(rs.next()){
			c=new Customer();
			c.setCustomerNumber(rs.getInt(1));
			c.setCustomerName(rs.getString(2));
			c.setHomePhone(rs.getString(3));
			c.setWorkPhone(rs.getString(4));
			c.setStreet(rs.getString(5));
			c.setCity(rs.getString(6));
			c.setState(rs.getString(7));
			c.setZip(rs.getString(8));
		}
		
		}catch (Exception ex) {
		}
		return c;
	}
	
	public List<Customer> getCustomers(){
		List<Customer> l = new ArrayList<Customer>();
		Customer c=null;
		try{
			Statement stmt=cn.createStatement();
		String qry="select * from Customers";
		ResultSet rs=stmt.executeQuery(qry);
		while(rs.next()){
			c=new Customer();
			c.setCustomerNumber(rs.getInt(1));
			c.setCustomerName(rs.getString(2));
			c.setHomePhone(rs.getString(3));
			c.setWorkPhone(rs.getString(4));
			c.setStreet(rs.getString(5));
			c.setCity(rs.getString(6));
			c.setState(rs.getString(7));
			c.setZip(rs.getString(8));
		    l.add(c);
		    c = null;
		}
		
		}catch (Exception ex) {
		}
		return l;
	}
	// Delete customer by id
	public String deleteCustomerById(int id){
		// delete Customer from DB with matching id
		try{
			Statement stmt=cn.createStatement();
		String qry="delete from customer where customerNumber="+id;
		stmt.executeUpdate(qry);
		
		}catch (Exception ex) {
		}
		return "Deleted Successfully";
	}
	//update customer data
	public void updateCustomerById(Customer c){
		// code to update Customer object
	}
	// show purchase orders
	
}
