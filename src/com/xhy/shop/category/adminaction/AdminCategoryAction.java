package com.xhy.shop.category.adminaction;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xhy.shop.category.service.CategoryService;
import com.xhy.shop.category.vo.Category;

public class AdminCategoryAction extends ActionSupport implements ModelDriven<Category>{
		
	Category category=new Category();

	@Override
	public Category getModel() {
		
		return category;
	}
	
	private CategoryService categoryService;
	
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	// ��ѯȫ��һ������
	public String findAll(){
		List<Category> clist = categoryService.findAll();
		ActionContext.getContext().getValueStack().set("clist", clist);
		return "findallcategory";
	}
	//����Լ�����
	public String save(){
		categoryService.save(category);
		return "saveSuccess";
	}
	
}
