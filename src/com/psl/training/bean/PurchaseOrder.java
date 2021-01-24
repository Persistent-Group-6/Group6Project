package com.psl.training.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.psl.training.bean.OrderItem;
import com.psl.training.bean.PurchaseOrder;
import com.psl.training.bean.StockItem;
import com.psl.training.bean.Customer;

public class PurchaseOrder {
	StockItem stockItem;
	Customer customer;
	 int poNumber;
	  Date orderDate;
	  Date shipDate;
	 private Date expiryDate;
	  private boolean shipStatus;
	 private OrderItem[] orderItems;
	 PurchaseOrder po=new PurchaseOrder();
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
		 int len=orderItems.length;
		 for(int i=0;i<len; i++)
		 {
			 if(orderItems[i]==null)
				 break;
			 s+=orderItems[i].getTotal();
			 
		 }
		 return s;
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
	 public void setOrderItems(OrderItem[] orderItems)
	 {
		 this.orderItems=orderItems;
		 
	 }
	 public OrderItem[] getOrderItems()
	 {
		 return orderItems;
	 }
	 public double getDiscount()
	 {
		 if(orderDate==expiryDate)
		 {
			 return stockItem.itemPrice*0.50;
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
	 


}
