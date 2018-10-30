package com.xhy.shop.category.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.xhy.shop.category.dao.CategoryDao;
import com.xhy.shop.category.vo.Category;

@Transactional
public class CategoryService {
	//×¢ÈëcategoryDao
	private CategoryDao categoryDao;

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	public List<Category> findAll() {
		
		return categoryDao.findAll();
	}

	public void save(Category category) {
		categoryDao.save(category);
		
	}

}
