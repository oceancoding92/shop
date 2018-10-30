package com.xhy.shop.cart.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.xhy.shop.cart.vo.Cart;
import com.xhy.shop.cart.vo.CartItem;
import com.xhy.shop.product.service.ProductService;
import com.xhy.shop.product.vo.Product;

public class CartAction extends ActionSupport{
	//���ܲ���count��pid
	private int count;
	private int pid;
	
	//ע��productService
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
		//ͨ��pid�����Ʒ
		Product product=productService.findById(pid);
		cartItem.setProduct(product);
		//�ṩһ����ù��ﳵ�ķ���
		Cart cart=this.getCart();
		cart.addCart(cartItem);
		return "addCart";
	}
	//��ù��ﳵ����ÿ�ζ����½���������Ϊ��ÿ�ν�������һ���µģ�
	//Ҫ�����ﳵ�Ž�session�У�Ҫʼ�ձ���һ�����ﳵ
	private Cart getCart() {
		Cart cart=(Cart) ServletActionContext.getRequest().getSession().getAttribute("cart");
		if(cart==null){
			 cart=new Cart();
			ServletActionContext.getRequest().getSession().setAttribute("cart", cart);
		}
		return cart;
	}
	//��չ��ﳵ
	public String clearCart(){
		Cart cart=getCart();
		cart.clearCart();
		return "clearCart";
	}
	//ɾ��������
	public String removeCart(){
		Cart cart=getCart();
		cart.removeCartItem(pid);//���pid��������Է�ʽ���Ի�ȡ��ֻҪ�������õ���set�������С�
		return "removeCart";
		
	}
	//ֱ��ȥ���ﳵ
	public String toCart(){
		return "toCart";
	}
}
















