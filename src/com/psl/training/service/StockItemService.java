package com.psl.training.service;

import java.sql.SQLException;
import java.util.List;

//import com.psl.training.bean.Stock;
import com.psl.training.bean.StockItem;
import com.psl.training.dao.StockDAO;

public class StockItemService {
	StockDAO poDAO=new StockDAO();
	
	
	public void createStockItem(StockItem si){
		poDAO.createStockItem(si);
	}

	
	public StockItem showStockItemById(int no){
		return poDAO.showStockItemById(no);
	}
	
	
	
	public void updateStock(StockItem s) throws SQLException{
		// code to update Stock object
		poDAO.updateStock(s);
	}
	
	public String deleteStockItemById(int id){
		// delete poloyee from DB with matching id
		return poDAO.deleteStockItemById(id);
				
	}

}
