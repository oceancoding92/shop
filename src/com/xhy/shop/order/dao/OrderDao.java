package com.xhy.shop.order.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


import com.xhy.shop.order.vo.Order;
import com.xhy.shop.pageUtils.PageHibernateCallback;

public class OrderDao extends HibernateDaoSupport{

	public void save(Order order) {
		this.getHibernateTemplate().save(order);
		
	}

	public int findCountByUid(int uid) {
		String hql="select count(*) from Order o where o.user.uid=? ";
		List<Long> list = this.getHibernateTemplate().find(hql, uid);
		if(list.size()>0&&list!=null){
			return list.get(0).intValue();
		}
		return 0;
	}

	public List<Order> findOrderByPageUid(int uid, int beginPage, int limit) {
		String hql="from Order o where  o.user.uid=? order by ordertime desc";
		List<Order> list = this.getHibernateTemplate().
				execute(new PageHibernateCallback<>(hql, new Object[]{uid}, beginPage, limit));
		if(list!=null&&list.size()>0){
			return list;
		}
		return null;
	}

	public Order findByOid(int oid) {
		
		return this.getHibernateTemplate().get(Order.class, oid);
	}

	

	
}
