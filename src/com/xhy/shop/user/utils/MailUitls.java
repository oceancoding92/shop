package com.xhy.shop.user.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class MailUitls {
	/**
	 * �����ʼ��ķ���
	 * @param to	:�ռ���
	 * @param code	:������
	 */
	public static void sendMail(String to,String code){
		/**
		 * 1.���һ��Session����.
		 * 2.����һ�������ʼ��Ķ���Message.
		 * 3.�����ʼ�Transport
		 */
		// 1.������Ӷ���
		Properties props = new Properties();
		props.setProperty("mail.host", "localhost");
		Session session = Session.getInstance(props, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("service@ocean.com", "1234");
			}
			
		});
		// 2.�����ʼ�����:
		Message message = new MimeMessage(session);
		// ���÷�����:
		try {
			message.setFrom(new InternetAddress("service@ocean.com"));
			// �����ռ���:
			message.addRecipient(RecipientType.TO, new InternetAddress(to));
			// ���� CC   ����BCC
			// ���ñ���
			message.setSubject("���Թ������ô����̳ǹٷ������ʼ�");
			// �����ʼ�����:
			message.setContent("<h1>�������ô����̳ǹٷ������ʼ�!������������ɼ������!</h1><h3><a href='http://192.168.131.29:8080/shop/user_active.action?code="+code+"'>http://192.168.131.29:8080/shop/user_active.action?code="+code+"</a></h3>", "text/html;charset=UTF-8");
			// 3.�����ʼ�:
			Transport.send(message);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}
	
	/*public static void main(String[] args) {
		
		sendMail("ocean_xu1992@163.com","11111111111111");
	}*/
}