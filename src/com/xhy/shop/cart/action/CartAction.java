package com.xhy.shop.cart.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.xhy.shop.cart.vo.Cart;
import com.xhy.shop.cart.vo.CartItem;
import com.xhy.shop.product.service.ProductService;
import com.xhy.shop.product.vo.Product;

public class CartAction extends ActionSupport{
	//接受参数count，pid
	private int count;
	private int pid;
	
	//注入productService
	private ProductService productService;
	
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String addCart(){
		CartItem cartItem=new CartItem();
		cartItem.setNum(count);
		//通过pid获得商品
		Product product=productService.findById(pid);
		cartItem.setProduct(product);
		//提供一个获得购物车的方法
		Cart cart=this.getCart();
		cart.addCart(cartItem);
		return "addCart";
	}
	//获得购物车不能每次都重新建立，，因为，每次建立都是一个新的，
	//要将购物车放进session中，要始终保持一个购物车
	private Cart getCart() {
		Cart cart=(Cart) ServletActionContext.getRequest().getSession().getAttribute("cart");
		if(cart==null){
			 cart=new Cart();
			ServletActionContext.getRequest().getSession().setAttribute("cart", cart);
		}
		return cart;
	}
	//清空购物车
	public String clearCart(){
		Cart cart=getCart();
		cart.clearCart();
		return "clearCart";
	}
	//删除购物项
	public String removeCart(){
		Cart cart=getCart();
		cart.removeCartItem(pid);//这个pid上面的属性方式可以获取，只要上面设置的有set方法就行。
		return "removeCart";
		
	}
	//直接去购物车
	public String toCart(){
		return "toCart";
	}
}
















