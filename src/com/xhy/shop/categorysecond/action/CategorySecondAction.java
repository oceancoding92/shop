package com.xhy.shop.categorysecond.action;

import com.opensymphony.xwork2.ActionSupport;
import com.xhy.shop.categorysecond.service.CategorySecondService;

public class CategorySecondAction extends ActionSupport{
	//注入二级分类的
	private CategorySecondService categorySecondService;

	public void setCategorySecondService(CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}
	
}
