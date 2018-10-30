package com.xhy.shop.order.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.xhy.shop.order.dao.OrderDao;
import com.xhy.shop.order.vo.Order;
import com.xhy.shop.pageUtils.pageBean;
@Transactional
public class OrderService {
	//ע��orderDao
	private OrderDao orderDao;

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	public void save(Order order) {
		
		orderDao.save(order);
	}
	//ͨ��uid�����û�������ҵ���߼�

	public pageBean<Order> findByUid(int uid, int page) {
		
		pageBean<Order> pagebean=new pageBean<Order>();
		//ÿҳ��ʾ�ĸ���
		int limit=4;
		pagebean.setLimit(limit);
		pagebean.setPage(page);
		//�ܼ�¼��
		int totalCount=0;
		totalCount=orderDao.findCountByUid(uid);
		pagebean.setTotalCount(totalCount);
		//��ҳ��
		int totalPage=0;
		if(totalCount%limit!=0){
			totalPage=(totalCount/limit)+1;
		}
		else{
			totalPage=totalCount/limit;
		}
		pagebean.setTotalPage(totalPage);
		//���ö�������
		int beginPage=(page-1)*limit;
		List<Order> list=orderDao.findOrderByPageUid(uid,beginPage,limit);
		pagebean.setList(list);
		return pagebean;
	}

	public Order findByOid(int oid) {
		
		return orderDao.findByOid(oid);
	}

	
	
}

















