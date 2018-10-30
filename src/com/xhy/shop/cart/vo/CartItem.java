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
	//С�����������ͼ۸�ĳ˻��ó��Ľ�����ṩһ��get�����Ա���ͼ��ʹ��
	public double getSubtotal() {
		return product.getShop_price()*num;
	}
	
	

}
