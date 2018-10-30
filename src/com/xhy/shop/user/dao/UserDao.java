package com.xhy.shop.user.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.opensymphony.xwork2.ActionContext;
import com.xhy.shop.user.utils.UUIDUtil;
import com.xhy.shop.user.vo.User;

public class UserDao extends HibernateDaoSupport{
	
	//按名字查询是否有该用户
	public User findByUsername(String  username){
		 
		String hql="from User where username=?";
		
		List <User> list=this.getHibernateTemplate().find(hql, username);
		
		if(list!=null&&list.size()>0){
			return  list.get(0);
		}
		return null;
		
	}

	public void save(User user) {
		
		
		this.getHibernateTemplate().save(user);
		
		
	}

	public User findByCode(String code) {
		
		String hql="from User where code=?";
		List<User> list=this.getHibernateTemplate().find(hql,code);
		if(list!=null&&list.size()>0){
			return  list.get(0);
		}
		return null;
	}

	public void update(User existuser) {
		this.getHibernateTemplate().update(existuser);
		
	}

	public User findUser(User user) {
		
		String hql="from User where username= ? and password= ? and state=?";  
		List<User> list=this.getHibernateTemplate().find(hql, user.getUsername(),user.getPassword(),1);
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}
}




















