package com.psl.training.bean;

import java.util.ArrayList;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import com.psl.training.bean.PurchaseOrder;

public class PurchaseOrder {
	StockItem stockItem;
	Customer customer;
	 int poNumber;
	Date orderDate;
	  Date shipDate;
	 private Date expiryDate;
	  private boolean shipStatus;
	 private List<OrderItem> orderItems;
	 PurchaseOrder po=new PurchaseOrder();
	  public Date getShipDate() {
		return shipDate;
	}
	public void setShipDate(Date shipDate) {
		this.shipDate = shipDate;
	}
	public void setshippedstatus(boolean shipStatus)
	 
	  {
		  this.shipStatus=shipStatus;
	  }
	 public boolean isShipped()
	  {
		  return shipStatus;
	  }
	 public double sumItems()
	 {
		 double s=0;
		 int len=orderItems.size();
		 for(int i=0;i<len; i++)
		 {
			 if(orderItems.get(i)==null)
				 break;
			 s+=orderItems.get(i).getTotal();
			 
		 }
		 return s;
	 }
	 public int getPoNumber() {
			return poNumber;
		}
		public void setPoNumber(int poNumber) {
			this.poNumber = poNumber;
		}
	 public void setshipDate(Date date)
	 {
		 shipDate=date;
		 
	 }
	 public void setExpiryDate(Date expiryDate)
	 {
		 this.expiryDate=expiryDate;
		 
	 }
	 public Date getExpiryDate()
	 {
		 return this.expiryDate;
	 }
	 public void create(int poNo,Date orderDt)
	 {
		 poNumber=poNo;
		 orderDate=orderDt;
		 
	 }
	 public void setOrderItems(List<OrderItem> orderItems)
	 {
		 this.orderItems=orderItems;
		 
	 }
	 public List<OrderItem> getOrderItems()
	 {
		 return orderItems;
	 }
	 public double getDiscount()
	 {
		 if(orderDate==expiryDate)
		 {
			 return stockItem.getItemPrice()*0.50;
		 }
		 return 0;
	 }
	public List<PurchaseOrder> removeExpiredItem()
	 {
		 List<PurchaseOrder> ol=new ArrayList<>();
		 Iterator it=ol.iterator();
		 while(it.hasNext())
		 {
			 if(new PurchaseOrder().orderDate==new PurchaseOrder().expiryDate)
			 {
				ol.remove(new PurchaseOrder());
			 }
		 }
			 
		 return ol; 
		 
	 }
	public List<OrderItem[]> orderBetween(Date d1,Date d2)
	{
		List<OrderItem[]> lo=new ArrayList<>();
		Iterator it=lo.iterator();
		return lo;
	}
	public void generateBill()
	{
		System.out.println(poNumber+" "+ orderItems+" "+ customer.getStreet()+" "+ customer.getCity()+" "+customer.getState()
				+" "+customer.getZip());
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	 


}
