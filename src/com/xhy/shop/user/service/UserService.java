package com.xhy.shop.user.service;

import org.springframework.transaction.annotation.Transactional;

import com.xhy.shop.user.dao.UserDao;
import com.xhy.shop.user.utils.MailUitls;
import com.xhy.shop.user.utils.UUIDUtil;
import com.xhy.shop.user.vo.User;


@Transactional
public class UserService {
	
	//注入UserDao
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public User findByUsername(String username){
		
		return userDao.findByUsername(username);	
	}
	
	public void save(User user) {
		
		
		user.setState(0);//0代表未被激活，1代表被激活
		String code=UUIDUtil.getUUID()+UUIDUtil.getUUID();
		user.setCode(code);
		userDao.save(user);
		MailUitls.sendMail(user.getEmail(),code);
		
	}
	
	public User findByCode(String code) {
		
		return userDao.findByCode(code);
	}
	
	public void update(User existuser) {
		userDao.update(existuser);
		
	}
	
	public User findUser(User user) {
		return userDao.findUser(user);
		
	}
	
}
