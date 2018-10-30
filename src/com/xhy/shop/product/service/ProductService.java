package com.xhy.shop.product.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.xhy.shop.pageUtils.pageBean;
import com.xhy.shop.product.dao.ProductDao;
import com.xhy.shop.product.vo.Product;

@Transactional
public class ProductService {
	private ProductDao productDao;

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	//����������Ʒ
	public List<Product> findHotProduct() {
		
		return productDao.findHotProduct();
	}
	//����������Ʒ
	public List<Product> findNewProduct() {
		
		return productDao.findNewProduct();
	}
	//ͨ��id��ѯ��Ʒ��Ϣ
	public Product findById(Integer pid) {
		
		 return productDao.findById(pid);
	}
	//����һ�������ѯ��Ʒ����ҳ
	public pageBean<Product> fingByPageCid(int page, int cid) {
		
		pageBean<Product> pagebean=new pageBean<Product>();
		//���õ�ǰҳ��
		pagebean.setPage(page);
		//ÿҳ��ʾ�ļ�¼��
		int limit=8;
		pagebean.setLimit(limit);
		//�ܼ�¼��
		int totalcount =0;
		totalcount=productDao.findCountByCid(cid);
		pagebean.setTotalCount(totalcount);
		//��ҳ��
		int totalPage=0;
		if(totalcount%limit==0){
			totalPage=totalcount/limit;
		}
		else{
			totalPage=(totalcount/limit)+1;
		}
		pagebean.setTotalPage(totalPage);
		int beginpage=(page-1)*limit;
				
		List<Product> list=productDao.findProductByPageCid(cid,beginpage,limit);
		pagebean.setList(list);
		return pagebean;
		
	}
	//���������ҳ
	public pageBean<Product> findByPageCsid(int csid, int page) {
		
		pageBean<Product> pagebean=new pageBean<Product>();
		//���õ�ǰҳ��
		pagebean.setPage(page);
		//ÿҳ��ʾ�ļ�¼��
		int limit=8;
		pagebean.setLimit(limit);
		//�ܼ�¼��
		int totalcount =0;
		totalcount=productDao.findCountByCsid(csid);
		pagebean.setTotalCount(totalcount);
		//��ҳ��
		int totalPage=0;
		if(totalcount%limit==0){
			totalPage=totalcount/limit;
		}
		else{
			totalPage=(totalcount/limit)+1;
		}
		pagebean.setTotalPage(totalPage);
		int beginpage=(page-1)*limit;
				
		List<Product> list=productDao.findProductByPageCsid(csid,beginpage,limit);
		pagebean.setList(list);
		return pagebean;
	}
	
	
	

}












