package com.xhy.shop.product.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xhy.shop.category.service.CategoryService;
import com.xhy.shop.pageUtils.pageBean;
import com.xhy.shop.product.service.ProductService;
import com.xhy.shop.product.vo.Product;
public class ProductAction extends ActionSupport implements ModelDriven<Product>{
	//属性方式接受cid、page、csid的参数
	private int cid;
	private int page;
	private int csid;
	
	public int getCsid() {
		return csid;
	}
	public void setCsid(int csid) {
		this.csid = csid;
	}
	
	
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}


	//实现模型驱动接受参数
	Product product=new Product(); 
	@Override
	public Product getModel() {
		
		return product;
	}
	//注入productService
	private ProductService productService;
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	//注入查询一级的service，因为之前已经查出所有的一级分类的信息，这样就可以直接使用
	private CategoryService categoryService;
	
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	// 通过pid查询商品的相关信息
	public String findById(){
		//这种方法是利用模型驱动的方式，直接就存到值栈的栈顶，视图中取出按照值栈的方法取
		product=productService.findById(product.getPid());
		
		//这是将product存放在session中,在视图页面用到数据时，利用session进行显示
		/*Product product1=productService.findById(product.getPid());
		ActionContext.getContext().getSession().put("product", product1);*/
		return "findbyid";
	}
	//通过cid查询相关信息
	public String findByCid(){
		pageBean<Product> pagebean=productService.fingByPageCid(page,cid); //根据一级分类查询商品，带分页显示
		//将pageBean存放在值栈中以便视图页面使用
		ActionContext.getContext().getValueStack().set("pagebean", pagebean);
		return "findbycid";
	}
	//通过csid来查询二级分类下的商品
	public String findByCsid(){
		pageBean<Product> pagebean=productService.findByPageCsid(csid,page);
		ActionContext.getContext().getValueStack().set("pagebean",pagebean);
		return "findbycsid";
	}
	
}











