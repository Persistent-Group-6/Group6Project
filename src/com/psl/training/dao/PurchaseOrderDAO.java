package com.psl.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.psl.training.bean.PurchaseOrder;
import com.psl.training.util.DBConnection;

public class PurchaseOrderDAO {
	Connection cn=DBConnection.getConnection();
	OrderItemDAO odao;
	public PurchaseOrderDAO() {
		// TODO Auto-generated constructor stub
		odao = new OrderItemDAO();
	}
	public List<PurchaseOrder> showPurchaseOrders(int custNo) {
		List<PurchaseOrder> l = new ArrayList<PurchaseOrder>();
		PurchaseOrder p=null;
		try{
			Statement stmt=cn.createStatement();
		String qry="select * from purchase_order where customerNumber="+custNo;
		ResultSet rs=stmt.executeQuery(qry);
		while(rs.next()){
			p=new PurchaseOrder();
			p.setPoNumber(rs.getInt(1));
			p.setOrderDate(rs.getDate(2));
			p.setshipDate(rs.getDate(3));
			p.setOrderItems(odao.showOrderItems(p.getPoNumber()));
		    l.add(p);
		    p = null;
		}
		
		}catch (Exception ex) {
		}
		return l;
	}
	
	public String deletePurchaseOrder(int no) {
		try{
			Statement stmt=cn.createStatement();
			odao.deleteOrderItems(no);
		String qry="delete from purchase_order where purchaseOrderNo="+no;
		stmt.executeUpdate(qry);
		
		}catch (Exception ex) {
		}
		return "Deleted Order Successfully";
	}

	public void createPurchaseOrders(PurchaseOrder po,int custNo) {
		try {
			PreparedStatement	pstmt = cn.prepareStatement("insert into purchase_order values(?,?,?,?)");
			
			pstmt.setInt(1, po.getPoNumber());
			pstmt.setDate(2, po.getOrderDate());
			pstmt.setDate(3, po.getShipDate());
			pstmt.setInt(4, custNo);
			odao.createOrderItems(po.getOrderItems(),po.getPoNumber());
			pstmt.executeUpdate();
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	 /* public void updatePurchaseOrder(PurchaseOrder p) throws SQLException
	    {
			PreparedStatement ps = cn.prepareStatement("UPDATE purchase_order SET  poNumber=?, orderDate=?, shipDate=?, customerNo=?");
		
			 
		
			
		
			 
		
			ps.executeUpdate();
			ps.close();
	    }*/

}
