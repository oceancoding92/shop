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
	
	//查找热门商品
	public List<Product> findHotProduct() {
		//使用离线查询热销商品
		DetachedCriteria criteria=DetachedCriteria.forClass(Product.class);
		//查询热门商品限制条件是is_hot=1
		criteria.add(Restrictions.eq("is_hot", 1));
		//倒序排列输出
		criteria.addOrder(Order.desc("pdate"));
		List<Product> list=this.getHibernateTemplate().findByCriteria(criteria, 0, 10);
		return list;
	}
	
	//查找最新商品
	public List<Product> findNewProduct() {
		//使用离线查询热销商品
		DetachedCriteria criteria=DetachedCriteria.forClass(Product.class);
		//限定输出条件
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
	//根据cid查询总共的记录数
	public int findCountByCid(int cid) {
		//将利用三个表的关联建立hql语句，要在各个实体以及hbm.xml文件中配置好关联
		String hql="select count(*) from Product p "
				+ "where p.categorySecond.category.cid=?";
		//统计出来的count泛型是Long类型
		List<Long> list=this.getHibernateTemplate().find(hql, cid);
		if(list!=null&&list.size()>0){
		return   list.get(0).intValue();
		}
		return 0;
	}
	//根据分类的id查询商品的集合
	public List<Product> findProductByPageCid(int cid, int beginpage, int limit) {
		//SQL的写法 select p* from category c,categorySecond cs,product p where c.cid=cs.cid and cs.csid=p.csid and where c.cid=?
		//直接改成hql:select p from Category c,CategorySecond cs,Product p where c.cid=cs.category.cid and cs.csid=p.categorySecond.csid and c.cid=?	
		String hql="select p from Product p join p.categorySecond cs "
				+ "join cs.category c where c.cid=?";
		List<Product> list=this.getHibernateTemplate().execute(new PageHibernateCallback<>(hql, new Object[]{cid}, beginpage, limit));
		if(list!=null&&list.size()>0)
		{
			return list;
		}
		return null;
	}
	
	//根据csid查询二级分类下总的记录数
	public int findCountByCsid(int csid) {
		String hql="select count(*) from Product p where p.categorySecond.csid=?";
		//统计出来的count泛型是Long类型
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

