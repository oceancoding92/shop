package com.xhy.shop.order.action;

import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xhy.shop.cart.vo.Cart;
import com.xhy.shop.cart.vo.CartItem;
import com.xhy.shop.order.service.OrderService;
import com.xhy.shop.order.vo.Order;
import com.xhy.shop.order.vo.OrderItem;
import com.xhy.shop.pageUtils.pageBean;
import com.xhy.shop.user.vo.User;

public class OrderAction extends ActionSupport implements ModelDriven<Order> {
	//��������
	
	private int page;
	
	public void setPage(int page) {
		this.page = page;
	}

	//ģ������
	Order order=new Order();
	@Override
	public Order getModel() {
		
		return order;
	}
	//ע��orderSecvice
	private OrderService orderService;

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	public String save(){
		//���Ƚ������������ݿ���
		order.setOrdertime(new Date());
		order.setState(1);
		//ͨ��session��ù��ﳵ
		Cart cart=(Cart) ServletActionContext.getRequest().getSession().getAttribute("cart");
		if(cart==null){
			addActionMessage("���ﳵ�տ���Ҳ����ǰȥ����");
			return "msg";
		}
		order.setTotal(cart.getTotal());
		
		for(CartItem cartItem:cart.getCartItem()){
			OrderItem orderItem=new OrderItem();
			orderItem.setSubtotal(cartItem.getSubtotal());
			orderItem.setCount(cartItem.getNum());
			orderItem.setProduct(cartItem.getProduct());
			order.getOrderItems().add(orderItem);		
		}
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		if(user==null){
			this.addActionMessage("���ȵ�¼");
			return "login";
		}
		order.setUser(user);
		orderService.save(order);
		//��ν�������ҳ������ʾ����
		//���������ַ�ʽ��order��ʾ��ҳ�棬1.ͨ��ֵջ�ķ�ʽ 2.��Ϊģ����������Order,����ʹ��ģ������
		//�����ﳵ���
		cart.clearCart();
		return "save";
	}
	//ͨ��uid�����û��Ķ�������
	public String findByUid(){
		User existUser = (User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		pageBean<Order> pagebean = orderService.findByUid(existUser.getUid(),page);
		ActionContext.getContext().getValueStack().set("pagebean", pagebean);
		return "myorder";
	}
	
	//ͨ��������oid���Ҷ���������
	public String findByOid(){
		//���ص�order�������¶���
		 order=orderService.findByOid(order.getOid());
		return "findorderbyoid";
	}
}
















