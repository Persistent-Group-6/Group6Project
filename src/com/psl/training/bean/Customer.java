package com.psl.training.bean;

import java.util.List;

public class Customer {
	//variables
	private int customerNumber;
	private String customerName;
	private String homePhone;
	private String cellPhone;
	private String workPhone;
	private String street;
	private String city;
	private String state;
	private String zip;
	private List<PurchaseOrder> po;
	
	private String printingAddress;
	private String phoneNumbers;

	public Customer() {
	// TODO Auto-generated constructor stub
	}

	public Customer(int customerNumber, String customerName, String homePhone, String cellPhone, String workPhone,
			String street, String city,String state, String zip, List<PurchaseOrder> po) {
		super();
		this.customerNumber = customerNumber;
		this.customerName = customerName;
		this.homePhone = homePhone;
		this.cellPhone = cellPhone;
		this.workPhone = workPhone;
		this.street = street;
		this.city = city;
		this.state=state;
		this.zip = zip;
		this.po = po;
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
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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
	
	//setPhoneNumbers
	public void setPhoneNumbers(int customerNumber) {
		if(this.customerNumber==customerNumber) {
			 this.phoneNumbers="HomePhone"+homePhone+"CellPhone"+cellPhone+"WorkPhone"+workPhone;

		}
	}
	 public String printPhoneNumbersString(int customerNumber) {
		 if(this.customerNumber==customerNumber) {
			 	return this.phoneNumbers;
		}
		return null;
	 }
	 
	 //Address
	 public void setPrintingAddress(int customerNumber) {
			if(this.customerNumber==customerNumber) {
				 this.printingAddress="Street-"+street+"City-"+city+"State-"+state+"Zip"+zip;

			}
	 }
	 public String printShippingAddress(int customerNumber) {
		 if(this.customerNumber==customerNumber) {
			 return this.printingAddress;
		 }
		 return null;
	 }
	 
	 public void print(Customer c) {
		 System.out.println(c);
	 }
	 








}
