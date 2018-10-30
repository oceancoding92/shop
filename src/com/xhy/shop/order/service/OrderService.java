package com.xhy.shop.order.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.xhy.shop.order.dao.OrderDao;
import com.xhy.shop.order.vo.Order;
import com.xhy.shop.pageUtils.pageBean;
@Transactional
public class OrderService {
	//注入orderDao
	private OrderDao orderDao;

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	public void save(Order order) {
		
		orderDao.save(order);
	}
	//通过uid查找用户订单的业务逻辑

	public pageBean<Order> findByUid(int uid, int page) {
		
		pageBean<Order> pagebean=new pageBean<Order>();
		//每页显示的个数
		int limit=4;
		pagebean.setLimit(limit);
		pagebean.setPage(page);
		//总记录数
		int totalCount=0;
		totalCount=orderDao.findCountByUid(uid);
		pagebean.setTotalCount(totalCount);
		//总页数
		int totalPage=0;
		if(totalCount%limit!=0){
			totalPage=(totalCount/limit)+1;
		}
		else{
			totalPage=totalCount/limit;
		}
		pagebean.setTotalPage(totalPage);
		//设置订单集合
		int beginPage=(page-1)*limit;
		List<Order> list=orderDao.findOrderByPageUid(uid,beginPage,limit);
		pagebean.setList(list);
		return pagebean;
	}

	public Order findByOid(int oid) {
		
		return orderDao.findByOid(oid);
	}

	
	
}

















