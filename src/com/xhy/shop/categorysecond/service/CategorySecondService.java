package com.xhy.shop.categorysecond.service;

import com.xhy.shop.categorysecond.dao.CategorySecondDao;

public class CategorySecondService {
	//注入二级分类的categorySecondDao
	private CategorySecondDao categorySecondDao;

	public void setCategorySecondDao(CategorySecondDao categorySecondDao) {
		this.categorySecondDao = categorySecondDao;
	}
	
}
