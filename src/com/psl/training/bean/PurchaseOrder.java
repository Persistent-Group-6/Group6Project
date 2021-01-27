package com.psl.training.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import com.psl.training.bean.PurchaseOrder;
import com.psl.training.service.OrderItemService;
import com.psl.training.service.PurchaseOrderService;

public class PurchaseOrder {
	StockItem stockItem;
	Customer customer;
	 int poNumber;
	String orderDate;
	  String shipDate;
	  private boolean shipStatus;
	 private List<OrderItem> orderItems;
	 PurchaseOrderService pos;
	 OrderItemService ois;
	public PurchaseOrder() {
		// TODO Auto-generated constructor stub
		pos = new PurchaseOrderService();
		ois = new OrderItemService();
	}
	  public String getShipDate() {
		return shipDate;
	}
	public void setShipDate(String localDate) {
		this.shipDate = localDate;
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
	 public void setshipDate(String date)
	 {
		 shipDate=date;
		 
	 }
	 public void create(int poNo,String orderDt)
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
		 if(orderDate.equals(stockItem.getExpiryDate()))
		 {
			 return stockItem.getItemPrice()*0.50;
		 }
		 return 0;
	 }
	public  List<PurchaseOrder> removeExpiredItem(int custNo)
	 {
		 List<PurchaseOrder> po=new ArrayList<>();
		 po = pos.showPurchaseOrders(custNo);
		 Iterator<PurchaseOrder> it=po.iterator();
		 while(it.hasNext())
		 {
			 PurchaseOrder p =  (PurchaseOrder)it.next();
			 List<OrderItem> oi = new ArrayList<OrderItem>();
			 oi = p.getOrderItems();
			 Iterator<OrderItem> it1=oi.iterator();
			 while(it1.hasNext()) {
				 OrderItem o = (OrderItem)it1.next();
				 if(p.getOrderDate()==o.getStockItem().getExpiryDate()) {
					 ois.deleteOrderItems(p.getPoNumber());
				 }
			 }
			 
		 } 
		 return pos.showPurchaseOrders(custNo);
	 }
	public List<PurchaseOrder> orderBetween(Date d1,Date d2,int po)
	{
		List<PurchaseOrder> lo=new ArrayList<PurchaseOrder>();
		lo = pos.showPurchaseOrdersBetw2Dates(d1, d2);
		return lo;
	}
	public void generateBill()
	{
		System.out.println(poNumber+" "+ orderItems+" "+ customer.getStreet()+" "+ customer.getCity()+" "+customer.getState()
				+" "+customer.getZip());
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	 


}
