package com.xhy.shop.category.vo;

import java.util.HashSet;
import java.util.Set;

import com.xhy.shop.categorysecond.vo.CategorySecond;

public class Category {
	private int cid;
	private String cname;
	
	public int getCid() {
		return cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	//Ҫ��һ�����Բ�ѯ������������Ҫ���ö����ļ���
	private Set<CategorySecond> categorySeconds=new HashSet<CategorySecond>();

	public Set<CategorySecond> getCategorySeconds() {
		return categorySeconds;
	}
	public void setCategorySeconds(Set<CategorySecond> categorySeconds) {
		this.categorySeconds = categorySeconds;
	}

	
	
}













