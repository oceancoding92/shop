package com.xhy.shop.categorysecond.vo;

import java.util.HashSet;
import java.util.Set;

import com.xhy.shop.category.vo.Category;
import com.xhy.shop.product.vo.Product;

public class CategorySecond {
	/*CREATE TABLE `categorysecond` (
			  `csid` int(11) NOT NULL AUTO_INCREMENT,
			  `csname` varchar(255) DEFAULT NULL,
			  `cid` int(11) DEFAULT NULL,
			  PRIMARY KEY (`csid`),
			  KEY `FK936FCAF21DB1FD15` (`cid`),
			  CONSTRAINT `FK936FCAF21DB1FD15` FOREIGN KEY (`cid`) REFERENCES `category` (`cid`)
			) */
	private Integer csid;
	private String csname;
	//一级分类的外键使用一级分类的对象建立
	private Category category;
	
	//二级分类中的商品集合
	private Set<Product> products=new HashSet<Product>();
	
	
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	public Integer getCsid() {
		return csid;
	}
	public void setCsid(Integer csid) {
		this.csid = csid;
	}
	public String getCsname() {
		return csname;
	}
	public void setCsname(String csname) {
		this.csname = csname;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
}













