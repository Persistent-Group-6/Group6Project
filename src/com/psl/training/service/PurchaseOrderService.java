
package com.psl.training.service;
import java.util.Date;
import java.util.List;

import com.psl.training.dao.PurchaseOrderDAO;
import com.psl.training.bean.PurchaseOrder;

public class PurchaseOrderService {
	
	
		
		PurchaseOrderDAO poDAO=new PurchaseOrderDAO();
		
		
		public void createPurchaseOrder(PurchaseOrder po,int custNo){
			poDAO.createPurchaseOrders(po,custNo);
		}

		
		public List<PurchaseOrder> showPurchaseOrders(int custNo){
			return poDAO.showPurchaseOrders(custNo);
		}
		
		public List<PurchaseOrder> showPurchaseOrdersBetw2Dates(Date d1,Date d2){
			return poDAO.orderBetween(d1, d2);
		}
		
	/*	public void updatePurchaseOrders(PurchaseOrder o){
			// code to update PurchaseOrder object
		}*/
		
		public String deletePurchaseOrders(int no){
			// delete poloyee from DB with matching id
			return poDAO.deletePurchaseOrder(no);
					
		}

}
