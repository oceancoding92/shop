package com.xhy.shop.categorysecond.action;

import com.opensymphony.xwork2.ActionSupport;
import com.xhy.shop.categorysecond.service.CategorySecondService;

public class CategorySecondAction extends ActionSupport{
	//ע����������
	private CategorySecondService categorySecondService;

	public void setCategorySecondService(CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}
	
}
