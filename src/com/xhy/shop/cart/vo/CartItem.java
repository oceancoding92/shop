package com.xhy.shop.cart.vo;

import com.xhy.shop.product.vo.Product;

public class CartItem {
	private Product product;
	private int num;
	private double subtotal;
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	//小计是用数量和价格的乘积得出的结果，提供一个get方法以便视图的使用
	public double getSubtotal() {
		return product.getShop_price()*num;
	}
	
	

}
