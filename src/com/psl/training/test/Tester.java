package com.psl.training.test;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.psl.training.bean.Customer;
import com.psl.training.bean.OrderItem;
import com.psl.training.bean.PurchaseOrder;
import com.psl.training.bean.StockItem;
import com.psl.training.service.CustomerService;
import com.psl.training.service.OrderItemService;
import com.psl.training.service.PurchaseOrderService;
import com.psl.training.service.StockItemService;

public class Tester {
	public static void main(String[] args) {
		CustomerService c = new CustomerService();
		PurchaseOrderService pos = new PurchaseOrderService();
		StockItemService sis = new StockItemService();
		OrderItemService ois = new OrderItemService();
		Customer co = new Customer(2, "Jamie", "456873", "9440647467", "789541", "mana road", "Madanapalli", "Andhrapradesh", "974567");
		c.insertCustomer(co);
		Customer co1 = new Customer(3, "Bill", "126743", "9440098768", "785678", "kishna road", "pune", "maharashtra", "975740");
		c.insertCustomer(co1);
		StockItem si = new StockItem(1, "Milk", 25.0, 1000, LocalDate.now().plusDays(9).toString());
		StockItem si2 = new StockItem(2, "Chicken", 80.0, 800, LocalDate.now().plusDays(9).toString());
		StockItem si3= new StockItem(3, "Egg", 80.0, 600, LocalDate.now().plusDays(9).toString());
		StockItem si4= new StockItem(4,"Apple",60.0,500,LocalDate.now().plusDays(9).toString());
		StockItem si5= new StockItem(5, "Orange", 80.0, 100, LocalDate.now().plusDays(9).toString());
		sis.createStockItem(si);
		sis.createStockItem(si2);
		sis.createStockItem(si3);
		sis.createStockItem(si4);
		sis.createStockItem(si5);
		PurchaseOrder po = new PurchaseOrder();
		po.setPoNumber(1);
		po.setOrderDate(LocalDate.now().toString());
		po.setShipDate(LocalDate.now().plusDays(7).toString());
		List<OrderItem> lo = new ArrayList<OrderItem>();
		OrderItem o1 = new OrderItem(sis.showStockItemByName("Milk"),2);
		OrderItem o2 = new OrderItem(sis.showStockItemByName("Chicken"), 2);
		OrderItem o3 = new OrderItem(sis.showStockItemByName("Egg"), 12);
		
		lo.add(o1);
		lo.add(o2);
		lo.add(o3);
		po.setOrderItems(lo);
		ois.insertOrderItem(lo, 1);
		pos.createPurchaseOrder(po, 1);
		
		List<Customer> l= c.getCustomers();
		for (Customer customer : l) {
			System.out.println(customer.getCity());
		}
		c.deleteCustomerById(2);
	}
}
