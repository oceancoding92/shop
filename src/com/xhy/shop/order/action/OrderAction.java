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
	//属性驱动
	
	private int page;
	
	public void setPage(int page) {
		this.page = page;
	}

	//模型驱动
	Order order=new Order();
	@Override
	public Order getModel() {
		
		return order;
	}
	//注入orderSecvice
	private OrderService orderService;

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	public String save(){
		//首先将订单存入数据库中
		order.setOrdertime(new Date());
		order.setState(1);
		//通过session获得购物车
		Cart cart=(Cart) ServletActionContext.getRequest().getSession().getAttribute("cart");
		if(cart==null){
			addActionMessage("购物车空空如也，请前去购物");
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
			this.addActionMessage("请先登录");
			return "login";
		}
		order.setUser(user);
		orderService.save(order);
		//其次将订单在页面中显示出来
		//可以有两种方式将order显示在页面，1.通过值栈的方式 2.因为模型驱动就是Order,可以使用模型驱动
		//将购物车清空
		cart.clearCart();
		return "save";
	}
	//通过uid查找用户的订单详情
	public String findByUid(){
		User existUser = (User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		pageBean<Order> pagebean = orderService.findByUid(existUser.getUid(),page);
		ActionContext.getContext().getValueStack().set("pagebean", pagebean);
		return "myorder";
	}
	
	//通过订单的oid查找订单的详情
	public String findByOid(){
		//返回的order不用重新定义
		 order=orderService.findByOid(order.getOid());
		return "findorderbyoid";
	}
}
















