package com.xhy.shop.index.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xhy.shop.category.service.CategoryService;
import com.xhy.shop.category.vo.Category;
import com.xhy.shop.product.service.ProductService;
import com.xhy.shop.product.vo.Product;

/*��ҳ����ʵ�action*/
public class IndexAction extends ActionSupport {
	
	//ע��һ�������categoryService
	private CategoryService categoryService;

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	//ע����Ʒ��productService
	private ProductService productService;
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	

	public String execute(){
		//�������е�һ������
		List<Category> clist =categoryService.findAll();
		
		//��ܶ�ҳ�湲�ã����Ա��浽session�У���������ÿ�ζ���ѯ���ݿ�
		ActionContext.getContext().getSession().put("clist", clist);
		
		//����������Ʒ
		List<Product> hlist=productService.findHotProduct();
		//��hlist���浽ֵջ��
		ActionContext.getContext().getValueStack().set("hlist", hlist);
		
		//����������Ʒ
		List<Product> nlist=productService.findNewProduct();
		ActionContext.getContext().getValueStack().set("nlist", nlist);
		return "index";
	}


	
}

















