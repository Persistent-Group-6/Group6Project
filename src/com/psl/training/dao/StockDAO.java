package com.psl.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.psl.training.bean.StockItem;
import com.psl.training.util.DBConnection;

public class StockDAO {
	Connection cn=DBConnection.getConnection();
	public StockItem showStockItemById(int no) {
		StockItem s=null;
		try{
			Statement stmt=cn.createStatement();
		String qry="select * from stock_item where item_Number="+no;
		ResultSet rs=stmt.executeQuery(qry);
		if(rs.next()){
			s=new StockItem();
			s.setItemNo(rs.getInt(1));
			s.setItemDesc(rs.getString(2));
			s.setItemPrice(rs.getDouble(3));
			s.setExpiryDate(rs.getString(4));
		}
		
		}catch (Exception ex) {
		}
		return s;
	}
	public StockItem showStockItemByName(String name) {
		StockItem s = new StockItem();
		try{
			Statement stmt=cn.createStatement();
		String qry="select * from stock_item where itemDescription=\""+name+"\"";
		ResultSet rs=stmt.executeQuery(qry);
		if(rs.next()){
			s.setItemNo(rs.getInt(1));
			s.setItemDesc(rs.getString(2));
			s.setItemPrice(rs.getDouble(3));
			s.setExpiryDate(rs.getString(4));
		}
		
		}catch (Exception ex) {
		}
		return s;
	}
	public int showStockItemIdByName(String name) {
		int n = 0;
		try{
			Statement stmt=cn.createStatement();
		String qry="select item_Number from stock_item where itemDescription=\""+name+"\"";
		ResultSet rs=stmt.executeQuery(qry);
		if(rs.next()){
			n = rs.getInt("item_Number");
		}
		
		}catch (Exception ex) {
		}
		return n;
	}
	
	public void createStockItem(StockItem si) {
		try {
			PreparedStatement	pstmt = cn.prepareStatement("insert into stock_item values(?,?,?,?)");
			
			pstmt.setInt(1, si.getItemNo());
			pstmt.setString(2, si.getItemDesc());
			pstmt.setDouble(3, si.getItemPrice());
			pstmt.setString(4, si.getExpiryDate());
			pstmt.executeUpdate();
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public List<StockItem> displayStocks(){
		List<StockItem> l= new ArrayList<StockItem>();
		StockItem si=null;
		try{
			Statement stmt=cn.createStatement();
		String qry="select * from stock_item";
		ResultSet rs=stmt.executeQuery(qry);
		while(rs.next()){
			si = new StockItem();
			si.setItemNo(rs.getInt(1));
			si.setItemDesc(rs.getString(2));
			si.setItemPrice(rs.getDouble(3));
			si.setExpiryDate(rs.getString(4));
		    l.add(si);
		    si = null;
		}
		
		
		}catch (Exception ex) {
		}
		return l;
	}
	public String deleteStockItemById(int id){
		// delete Customer from DB with matching id
		try{
			Statement stmt=cn.createStatement();
		String qry="delete from stock_item where item_Number="+id;
		stmt.executeUpdate(qry);
		
		}catch (Exception ex) {
		}
		return "Deleted Successfully";
	}
	
	  public void updateStock(StockItem s) throws SQLException
	    {
			PreparedStatement ps = cn.prepareStatement("UPDATE stock_item SET item_Number=?, itemDescription=?, itemPrice=?, expiryDate=?"); 
			 
		
			ps.setInt(1, s.getItemNo());
			ps.setString(2, s.getItemDesc());
			ps.setDouble(3, s.getItemPrice());
			ps.setString(4, s.getExpiryDate());
			ps.executeUpdate();
			ps.close();
	    }
}
