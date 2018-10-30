package com.xhy.shop.order.vo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.xhy.shop.user.vo.User;

public class Order {
	  /*CREATE TABLE orders (
	  oid int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	  total double DEFAULT NULL,
	  ordertime datetime DEFAULT NULL,
	  state int(11) DEFAULT NULL,
	  name varchar(21) DEFAULT NULL,
	  addr varchar(60) DEFAULT NULL,
	  phone varchar(20) DEFAULT NULL,
	  uid int(11) DEFAULT NULL,
	  CONSTRAINT pk_uid FOREIGN KEY (uid) REFERENCES user (uid)
	); */
	private int oid;
	private double total;
	private Date ordertime;
	private int state;
	private String name;
	private String addr;
	private String phone;
	private User user;
	private Set<OrderItem> orderItems=new HashSet<OrderItem>();
	
	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	public Date getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
















