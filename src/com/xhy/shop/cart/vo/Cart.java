package com.xhy.shop.cart.vo;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
	//���ﳵ����
	private Map<Integer ,CartItem> carMap=new LinkedHashMap<Integer ,CartItem>();
	private double total;
	//����������getCartItem�������൱��Cart����CartItem���ԣ�������ͼҳ��û�ȡ
	public Collection<CartItem> getCartItem(){
		return carMap.values();
	}
	//���ﳵ�Ĺ���
	//1.����������ӵ����ﳵ
	public void addCart(CartItem cartItem){
		int pid=cartItem.getProduct().getPid();
		if(carMap.containsKey(pid)){
			CartItem preCartItem=carMap.get(pid);//֮ǰ�Ĺ�����
			preCartItem.setNum(preCartItem.getNum()+cartItem.getNum());//����=֮ǰ+��ǰ��
			total=total+preCartItem.getSubtotal();
		}
		else{
			carMap.put(pid, cartItem);
			total=total+cartItem.getSubtotal();
		}
	}
	//2.��������ɾ��
	public void removeCartItem(int pid){
		CartItem cartItem=carMap.get(pid);
		carMap.remove(pid);
		total=total-cartItem.getSubtotal();
		
		
	}
	//3�����ﳵ���
	public void clearCart(){
		//����������գ��ܼƱ��0
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
