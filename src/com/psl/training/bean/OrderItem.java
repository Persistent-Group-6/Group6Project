package com.psl.training.bean;



public class OrderItem {
	
		StockItem stockItem;
		int numberOfItems;
		public OrderItem() {
			
		}
		public OrderItem(StockItem stockItem, int numberOfItems) {
			super();
			this.stockItem = stockItem;
			this.numberOfItems = numberOfItems;
		}
		
		public double getTotal()
		{
			return (stockItem.getItemPrice())*numberOfItems;
		}
		public int getNumberOfItems() {
			return numberOfItems;
		}
		public void setNumberOfItems(int numberOfItems) {
			this.numberOfItems = numberOfItems;
		}
		public StockItem getStockItem() {
			return stockItem;
		}
		public void setStockItem(StockItem stockItem) {
			this.stockItem = stockItem;
		}
		
}
