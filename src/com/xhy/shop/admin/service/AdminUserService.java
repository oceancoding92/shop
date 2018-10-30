package com.xhy.shop.admin.service;


import com.xhy.shop.admin.dao.AdminUserDao;
import com.xhy.shop.admin.vo.AdminUser;

public class AdminUserService {
	
	private AdminUserDao adminUserDao;

	public void setAdminUserDao(AdminUserDao adminUserDao) {
		this.adminUserDao = adminUserDao;
	}

	public AdminUser findByadmin(AdminUser adminUser) {
		
		return adminUserDao.findAdmin(adminUser);
	}
	

}
