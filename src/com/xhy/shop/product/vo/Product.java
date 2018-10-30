package com.xhy.shop.product.vo;

import java.util.Date;

import com.xhy.shop.categorysecond.vo.CategorySecond;

public class Product {
	/*CREATE TABLE product (
			  pid int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
			  pname varchar(255) DEFAULT NULL,
			  market_price double DEFAULT NULL,
			  shop_price double DEFAULT NULL,
			  image varchar(255) DEFAULT NULL,
			  pdesc varchar(255) DEFAULT NULL,
			  is_hot int(11) DEFAULT NULL,
			  pdate datetime DEFAULT NULL,
			  csid int(11) DEFAULT NULL,
			 
			  CONSTRAINT pk_csid FOREIGN KEY (csid) REFERENCES categorysecond (csid)
			) */
	private Integer pid;
	private String pname;
	private Double market_price;
	private Double shop_price;
	private String image;
	private String pdesc;
	private Integer is_hot;
	private Date pdate;
	//二级分类外键：使用二级分类的对象
	private CategorySecond categorySecond;
	public CategorySecond getCategorySecond() {
		return categorySecond;
	}
	public void setCategorySecond(CategorySecond categorySecond) {
		this.categorySecond = categorySecond;
	}
	public Integer getPid() {
		return pid;
	}
	public String getPname() {
		return pname;
	}
	public Double getMarket_price() {
		return market_price;
	}
	public Double getShop_price() {
		return shop_price;
	}
	public String getImage() {
		return image;
	}
	public String getPdesc() {
		return pdesc;
	}
	public Integer getIs_hot() {
		return is_hot;
	}
	public Date getPdate() {
		return pdate;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public void setMarket_price(Double market_price) {
		this.market_price = market_price;
	}
	public void setShop_price(Double shop_price) {
		this.shop_price = shop_price;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	public void setIs_hot(Integer is_hot) {
		this.is_hot = is_hot;
	}
	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}
	

}
