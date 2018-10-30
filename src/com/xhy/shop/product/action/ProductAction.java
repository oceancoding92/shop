package com.xhy.shop.product.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xhy.shop.category.service.CategoryService;
import com.xhy.shop.pageUtils.pageBean;
import com.xhy.shop.product.service.ProductService;
import com.xhy.shop.product.vo.Product;
public class ProductAction extends ActionSupport implements ModelDriven<Product>{
	//���Է�ʽ����cid��page��csid�Ĳ���
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


	//ʵ��ģ���������ܲ���
	Product product=new Product(); 
	@Override
	public Product getModel() {
		
		return product;
	}
	//ע��productService
	private ProductService productService;
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	//ע���ѯһ����service����Ϊ֮ǰ�Ѿ�������е�һ���������Ϣ�������Ϳ���ֱ��ʹ��
	private CategoryService categoryService;
	
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	// ͨ��pid��ѯ��Ʒ�������Ϣ
	public String findById(){
		//���ַ���������ģ�������ķ�ʽ��ֱ�Ӿʹ浽ֵջ��ջ������ͼ��ȡ������ֵջ�ķ���ȡ
		product=productService.findById(product.getPid());
		
		//���ǽ�product�����session��,����ͼҳ���õ�����ʱ������session������ʾ
		/*Product product1=productService.findById(product.getPid());
		ActionContext.getContext().getSession().put("product", product1);*/
		return "findbyid";
	}
	//ͨ��cid��ѯ�����Ϣ
	public String findByCid(){
		pageBean<Product> pagebean=productService.fingByPageCid(page,cid); //����һ�������ѯ��Ʒ������ҳ��ʾ
		//��pageBean�����ֵջ���Ա���ͼҳ��ʹ��
		ActionContext.getContext().getValueStack().set("pagebean", pagebean);
		return "findbycid";
	}
	//ͨ��csid����ѯ���������µ���Ʒ
	public String findByCsid(){
		pageBean<Product> pagebean=productService.findByPageCsid(csid,page);
		ActionContext.getContext().getValueStack().set("pagebean",pagebean);
		return "findbycsid";
	}
	
}











