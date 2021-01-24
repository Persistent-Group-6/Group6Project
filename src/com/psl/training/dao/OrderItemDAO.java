package com.psl.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.psl.training.bean.OrderItem;
import com.psl.training.util.DBConnection;

public class OrderItemDAO {
	Connection cn=DBConnection.getConnection();
	StockDAO sdao = null;
	public OrderItemDAO() {
		// TODO Auto-generated constructor stub
		sdao = new StockDAO();
	}
	public void createOrderItems(List<OrderItem> orderItem,int po) {
		// TODO Auto-generated method stub
		for (OrderItem o : orderItem) {
			try {
				PreparedStatement	pstmt = cn.prepareStatement("insert into order_item values(?,?,?)");
				
				pstmt.setInt(1, o.getNumberOfItems());
				pstmt.setInt(2, o.getStockItem().getItemNo());
				pstmt.setInt(3, po);
				pstmt.executeUpdate();
			
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	public List<OrderItem> showOrderItems(int purNo) {
		List<OrderItem> l = new ArrayList<OrderItem>();
		OrderItem o=null;
		try{
			Statement stmt=cn.createStatement();
		String qry="select * from order_item where purchaseOrderNo="+purNo;
		ResultSet rs=stmt.executeQuery(qry);
		while(rs.next()){
			o=new OrderItem();
			o.setNumberOfItems(rs.getInt(1));
			int no = rs.getInt(2);
			o.setStockItem(sdao.showStockItemById(no));
		    l.add(o);
		    o = null;
		}
		
		}catch (Exception ex) {
		}
		return l;
	}
	
	public void deleteOrderItems(int no) {
		// TODO Auto-generated method stub
		try{
			Statement stmt=cn.createStatement();
		String qry="delete from order_item where purchaseOrderNo="+no;
		stmt.executeUpdate(qry);
		
		}catch (Exception ex) {
		}
	}
}
