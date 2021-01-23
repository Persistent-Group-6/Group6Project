package com.psl.training.bean;

import java.util.List;

public class Customer {
	private int customerNumber;
	private String customerName;
	
	private String homePhone;
	private String cellPhone;
	private String workPhone;
	private String street;
	private String city;
	private String zip;
	private List<PurchaseOrder> po;

	public Customer() {
	// TODO Auto-generated constructor stub
	}

	public int getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getWorkPhone() {
		return workPhone;
	}

	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public List<PurchaseOrder> getPo() {
		return po;
	}

	public void setPo(List<PurchaseOrder> po) {
		this.po = po;
	}

	@Override
	public String toString() {
		return "Customer [customerNumber=" + customerNumber + ", customerName=" + customerName + ", homePhone="
				+ homePhone + ", cellPhone=" + cellPhone + ", workPhone=" + workPhone + ", street=" + street + ", city="
				+ city + ", zip=" + zip + ", po=" + po + "]";
	}








}
