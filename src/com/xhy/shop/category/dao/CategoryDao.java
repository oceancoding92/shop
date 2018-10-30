package com.xhy.shop.category.dao;

import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xhy.shop.category.vo.Category;

public class CategoryDao extends HibernateDaoSupport{

	public List<Category> findAll() {
		String hql="from Category";
		List<Category> list=this.getHibernateTemplate().find(hql);
		return list;
	}

	public void save(Category category) {
		this.getHibernateTemplate().save(category);
		
	}
	

}
