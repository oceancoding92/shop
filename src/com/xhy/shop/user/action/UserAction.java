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
	//ע��userservice
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
	//AJAX�����û�У��ķ���
	public String findByusername() throws IOException{
		
		User exituser= userService.findByUsername(user.getUsername());
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		if(exituser!=null){
			//��ѯ���û���˵���û�����
			response.getWriter().println("<font color='red'>���û��Ѵ���</font>");
		}
		//˵���û�û��ע�ᣬ����ʹ��
		else{
			response.getWriter().println("<font color='green'>���û�����ע��</font>");
		}
		//ajaxУ�鲻�÷��ؽ������˷���none
		return NONE;
	}
	//�û�ע��
	public String register(){
		//�ж���֤�����
		//�����֤������ֵ
		String checknumber=(String) ServletActionContext.getRequest().getSession().getAttribute("checknumber");
		if(!checknumber.equalsIgnoreCase(checkcode)){
			this.addActionError("��֤���������");
			return "checkRegisterFail";
		}
		userService.save(user);
		this.addActionMessage("����ע�ᣬ����ǰ�����伤��");
		return "msg";
	}
	//�û���������
	public String active(){
		//��ͨ��code��ø��û���Ȼ��satate��1��code�ÿ�
		User existuser=userService.findByCode(user.getCode());
		if(existuser!=null){
			//
			existuser.setState(1);
			existuser.setCode(null);
			userService.update(existuser);
			this.addActionMessage("����ɹ�");
		}
		else{
			this.addActionMessage("����ʧ�ܣ����������");
		}
		return "msg";
	}
	//�û���½ҳ��
	public String loginPage(){
		
		return "loginPage";
	}
	
	//��½
	public String login(){
		//��½��������֤��֤��
		//��½��֤�����
		/*String checknumber=(String) ServletActionContext.getRequest().getSession().getAttribute("checknumber");
		if(!checknumber.equalsIgnoreCase(checkcode)){
			this.addActionError("��֤���������");
			return "checkLoginFail";
		}*/
		
		User existUser=userService.findUser(user);
		
		if(existUser!=null){
			//��½�ɹ�
			ServletActionContext.getRequest().getSession().setAttribute("existUser",existUser);
			return "loginSuccess";
		}
		else{
			//��½ʧ��
			this.addActionError("��½ʧ��:�û��������������û�δ����");
			
			return "login";
		}
			
	}
	
	//�û��˳�
	public String quit(){
		//����session
		ServletActionContext.getRequest().getSession().invalidate();
		return "quit";
	}
	
}

















