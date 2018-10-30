package com.xhy.shop.admin.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xhy.shop.admin.dao.AdminUserDao;
import com.xhy.shop.admin.service.AdminUserService;
import com.xhy.shop.admin.vo.AdminUser;

public class AdminUserAction extends ActionSupport implements ModelDriven<AdminUser>{
	 
	AdminUser adminUser=new AdminUser();
	@Override
	public AdminUser getModel() {
		// TODO Auto-generated method stub
		return adminUser;
	}
	private AdminUserService adminUserService;
	public void setAdminUserService(AdminUserService adminUserService) {
		this.adminUserService = adminUserService;
	}
	
	public String login(){
		AdminUser existAdminUser=adminUserService.findByadmin(adminUser);
		if(existAdminUser==null){
			 this.addActionError("ÄãµÄµÇÂ½ÃÜÂë»òÕßÕËºÅÓÐÎó");	
			return "faillogin";
		}
		else{
			ActionContext.getContext().getSession().put("existAdminUser", existAdminUser);
			return "successlogin";
		}
		
	}
	
}
