package com.xhy.shop.cart.vo;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
	//购物车属性
	private Map<Integer ,CartItem> carMap=new LinkedHashMap<Integer ,CartItem>();
	private double total;
	//这里设置了getCartItem方法，相当于Cart中有CartItem属性，这样视图页面好获取
	public Collection<CartItem> getCartItem(){
		return carMap.values();
	}
	//购物车的功能
	//1.将购物项添加到购物车
	public void addCart(CartItem cartItem){
		int pid=cartItem.getProduct().getPid();
		if(carMap.containsKey(pid)){
			CartItem preCartItem=carMap.get(pid);//之前的购物项
			preCartItem.setNum(preCartItem.getNum()+cartItem.getNum());//数量=之前+当前项
			total=total+preCartItem.getSubtotal();
		}
		else{
			carMap.put(pid, cartItem);
			total=total+cartItem.getSubtotal();
		}
	}
	//2.将购物项删除
	public void removeCartItem(int pid){
		CartItem cartItem=carMap.get(pid);
		carMap.remove(pid);
		total=total-cartItem.getSubtotal();
		
		
	}
	//3将购物车清空
	public void clearCart(){
		//将购物项清空，总计变成0
		carMap.clear();
		total=0;
	}
	 
	
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
		
	}
	
}
