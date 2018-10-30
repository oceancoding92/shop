package com.xhy.shop.admin.vo;

public class AdminUser {
	         /*CREATE TABLE adminuser (
			  auid int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
			  username varchar(255) DEFAULT NULL,
			  password varchar(255) DEFAULT NULL
			  ) */
	private Integer auid;
	private String username;
	private String password;
	public Integer getAuid() {
		return auid;
	}
	public void setAuid(Integer auid) {
		this.auid = auid;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
