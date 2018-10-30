package com.xhy.shop.product.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xhy.shop.pageUtils.PageHibernateCallback;
import com.xhy.shop.product.vo.Product;

public class ProductDao extends HibernateDaoSupport {
	
	//����������Ʒ
	public List<Product> findHotProduct() {
		//ʹ�����߲�ѯ������Ʒ
		DetachedCriteria criteria=DetachedCriteria.forClass(Product.class);
		//��ѯ������Ʒ����������is_hot=1
		criteria.add(Restrictions.eq("is_hot", 1));
		//�����������
		criteria.addOrder(Order.desc("pdate"));
		List<Product> list=this.getHibernateTemplate().findByCriteria(criteria, 0, 10);
		return list;
	}
	
	//����������Ʒ
	public List<Product> findNewProduct() {
		//ʹ�����߲�ѯ������Ʒ
		DetachedCriteria criteria=DetachedCriteria.forClass(Product.class);
		//�޶��������
		criteria.addOrder(Order.desc("pdate"));
		List<Product> list=this.getHibernateTemplate().findByCriteria(criteria, 0, 10);
		return list;
	}

	public Product findById(Integer pid) {
		
		/*String Hql="from Product where pid=?";
		 List list=this.getHibernateTemplate().find(Hql, pid);
		 Product product=(Product) list.get(0);
		return product;*/
		return this.getHibernateTemplate().get(Product.class, pid);
	
	}
	//����cid��ѯ�ܹ��ļ�¼��
	public int findCountByCid(int cid) {
		//������������Ĺ�������hql��䣬Ҫ�ڸ���ʵ���Լ�hbm.xml�ļ������úù���
		String hql="select count(*) from Product p "
				+ "where p.categorySecond.category.cid=?";
		//ͳ�Ƴ�����count������Long����
		List<Long> list=this.getHibernateTemplate().find(hql, cid);
		if(list!=null&&list.size()>0){
		return   list.get(0).intValue();
		}
		return 0;
	}
	//���ݷ����id��ѯ��Ʒ�ļ���
	public List<Product> findProductByPageCid(int cid, int beginpage, int limit) {
		//SQL��д�� select p* from category c,categorySecond cs,product p where c.cid=cs.cid and cs.csid=p.csid and where c.cid=?
		//ֱ�Ӹĳ�hql:select p from Category c,CategorySecond cs,Product p where c.cid=cs.category.cid and cs.csid=p.categorySecond.csid and c.cid=?	
		String hql="select p from Product p join p.categorySecond cs "
				+ "join cs.category c where c.cid=?";
		List<Product> list=this.getHibernateTemplate().execute(new PageHibernateCallback<>(hql, new Object[]{cid}, beginpage, limit));
		if(list!=null&&list.size()>0)
		{
			return list;
		}
		return null;
	}
	
	//����csid��ѯ�����������ܵļ�¼��
	public int findCountByCsid(int csid) {
		String hql="select count(*) from Product p where p.categorySecond.csid=?";
		//ͳ�Ƴ�����count������Long����
				List<Long> list=this.getHibernateTemplate().find(hql, csid);
				if(list!=null&&list.size()>0){
				return   list.get(0).intValue();
				}
				return 0;
	}

	public List<Product> findProductByPageCsid(int csid, int beginpage, int limit) {
		String hql="select p from Product p join p.categorySecond cs "
				+ " where cs.csid=?";
		List<Product> list=this.getHibernateTemplate().execute(new PageHibernateCallback<>(hql, new Object[]{csid}, beginpage, limit));
		if(list!=null&&list.size()>0)
		{
			return list;
		}
		return null;
	}

	

}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

