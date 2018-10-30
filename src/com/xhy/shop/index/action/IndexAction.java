package com.xhy.shop.index.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xhy.shop.category.service.CategoryService;
import com.xhy.shop.category.vo.Category;
import com.xhy.shop.product.service.ProductService;
import com.xhy.shop.product.vo.Product;

/*首页面访问的action*/
public class IndexAction extends ActionSupport {
	
	//注入一级分类的categoryService
	private CategoryService categoryService;

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	//注入商品的productService
	private ProductService productService;
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	

	public String execute(){
		//查找所有的一级分类
		List<Category> clist =categoryService.findAll();
		
		//因很多页面共用，所以保存到session中，这样不用每次都查询数据库
		ActionContext.getContext().getSession().put("clist", clist);
		
		//查找热门商品
		List<Product> hlist=productService.findHotProduct();
		//将hlist保存到值栈中
		ActionContext.getContext().getValueStack().set("hlist", hlist);
		
		//查找最新商品
		List<Product> nlist=productService.findNewProduct();
		ActionContext.getContext().getValueStack().set("nlist", nlist);
		return "index";
	}


	
}

















