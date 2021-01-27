package com.psl.training.bean;

public class StockItem {
	private int itemNo;
	private String itemDesc;
	private double itemPrice;
	private int quantity;
	private String expiryDate;
	
	public StockItem() {
		// TODO Auto-generated constructor stub
	}


	public StockItem(int itemNo, String itemDesc, double price, int quantity,String expirydate) {
		super();
		this.itemNo = itemNo;
		this.itemDesc = itemDesc;
		this.itemPrice = price;
		this.quantity = quantity;
		this.expiryDate = expirydate;
	}


	public int getItemNo() {
		return itemNo;
	}


	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}


	public String getItemDesc() {
		return itemDesc;
	}


	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}


	public double getItemPrice() {
		return itemPrice;
	}


	public void setItemPrice(double price) {
		this.itemPrice = price;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	@Override
	public String toString() {
		return "StockItem [itemNo=" + itemNo + ", itemDesc=" + itemDesc
				+ ", price=" + itemPrice + ", quantity=" + quantity + "]";
	}


	public String getExpiryDate() {
		return expiryDate;
	}


	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

}
