package com.xhy.shop.admin.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xhy.shop.admin.vo.AdminUser;

public class AdminUserDao extends HibernateDaoSupport{

	public AdminUser findAdmin(AdminUser adminUser) {
		String hql = "from AdminUser where username =? and password=?";
		List<AdminUser> list = this.getHibernateTemplate().find(hql,adminUser.getUsername(),adminUser.getPassword());
		if(list != null && list.size()>0){
			return list.get(0);
		}
		return null;
	}
	}

