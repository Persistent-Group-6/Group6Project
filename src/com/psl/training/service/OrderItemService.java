package com.psl.training.service;

import java.sql.SQLException;
import java.util.List;

import com.psl.training.dao.OrderItemDAO;
import com.psl.training.bean.OrderItem;
import com.psl.training.bean.StockItem;

public class OrderItemService {
	
	OrderItemDAO empDAO=new OrderItemDAO();
	
	
	public void insertOrderItem(List<OrderItem> orderItem,int po){
		empDAO.createOrderItems(orderItem,po);
	}
	
	public List<OrderItem> showOrderItems(int id){
		return empDAO.showOrderItems(id);
	}
	
	
	
	public void updateOrderItem(OrderItem o,StockItem s) throws SQLException{
		// code to update OrderItem object
		empDAO.updateOrderItem(o, s);
	}
	
	public void deleteOrderItems(int id){
		// delete employee from DB with matching id
		empDAO.deleteOrderItems(id);
				
	}

}
