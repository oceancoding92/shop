package com.xhy.shop.user.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xhy.shop.user.service.UserService;
import com.xhy.shop.user.vo.User;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	
	public String registPage(){
		return "registPage";
	}
	private User user=new User();
	//注入userservice
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@Override
	public User getModel() {
		
		return user;
	}
	private String checkcode;
	
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}
	//AJAX进行用户校验的方法
	public String findByusername() throws IOException{
		
		User exituser= userService.findByUsername(user.getUsername());
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		if(exituser!=null){
			//查询到用户，说明用户存在
			response.getWriter().println("<font color='red'>该用户已存在</font>");
		}
		//说明用户没有注册，可以使用
		else{
			response.getWriter().println("<font color='green'>该用户可以注册</font>");
		}
		//ajax校验不用返回结果，因此返回none
		return NONE;
	}
	//用户注册
	public String register(){
		//判断验证码程序
		//获得验证码的随机值
		String checknumber=(String) ServletActionContext.getRequest().getSession().getAttribute("checknumber");
		if(!checknumber.equalsIgnoreCase(checkcode)){
			this.addActionError("验证码输入错误");
			return "checkRegisterFail";
		}
		userService.save(user);
		this.addActionMessage("可以注册，请你前往邮箱激活");
		return "msg";
	}
	//用户激活邮箱
	public String active(){
		//先通过code获得该用户，然后将satate置1，code置空
		User existuser=userService.findByCode(user.getCode());
		if(existuser!=null){
			//
			existuser.setState(1);
			existuser.setCode(null);
			userService.update(existuser);
			this.addActionMessage("激活成功");
		}
		else{
			this.addActionMessage("激活失败：激活码错误");
		}
		return "msg";
	}
	//用户登陆页面
	public String loginPage(){
		
		return "loginPage";
	}
	
	//登陆
	public String login(){
		//登陆首先先验证验证码
		//登陆验证码程序
		/*String checknumber=(String) ServletActionContext.getRequest().getSession().getAttribute("checknumber");
		if(!checknumber.equalsIgnoreCase(checkcode)){
			this.addActionError("验证码输入错误");
			return "checkLoginFail";
		}*/
		
		User existUser=userService.findUser(user);
		
		if(existUser!=null){
			//登陆成功
			ServletActionContext.getRequest().getSession().setAttribute("existUser",existUser);
			return "loginSuccess";
		}
		else{
			//登陆失败
			this.addActionError("登陆失败:用户名或密码错误或用户未激活");
			
			return "login";
		}
			
	}
	
	//用户退出
	public String quit(){
		//销毁session
		ServletActionContext.getRequest().getSession().invalidate();
		return "quit";
	}
	
}

















