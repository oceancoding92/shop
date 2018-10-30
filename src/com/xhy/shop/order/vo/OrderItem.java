package com.xhy.shop.order.vo;

import com.xhy.shop.product.vo.Product;

public class OrderItem {
	      /*CREATE TABLE orderitem (
			  itemid int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY ,
			  count int(11) DEFAULT NULL,
			  subtotal double DEFAULT NULL,
			  pid int(11) DEFAULT NULL,
			  oid int(11) DEFAULT NULL,
			  CONSTRAINT pk_oid FOREIGN KEY (oid) REFERENCES orders (oid),
			  CONSTRAINT pk_pid FOREIGN KEY (pid) REFERENCES product (pid)
			);*/
	private int itemid;
	private int count;
	private double subtotal;
	private Order order;
	private Product product;
	
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	

}
