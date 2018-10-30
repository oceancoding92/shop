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
	//查找热门商品
	public List<Product> findHotProduct() {
		
		return productDao.findHotProduct();
	}
	//查找最新商品
	public List<Product> findNewProduct() {
		
		return productDao.findNewProduct();
	}
	//通过id查询商品信息
	public Product findById(Integer pid) {
		
		 return productDao.findById(pid);
	}
	//根据一级分类查询商品带分页
	public pageBean<Product> fingByPageCid(int page, int cid) {
		
		pageBean<Product> pagebean=new pageBean<Product>();
		//设置当前页数
		pagebean.setPage(page);
		//每页显示的记录数
		int limit=8;
		pagebean.setLimit(limit);
		//总记录数
		int totalcount =0;
		totalcount=productDao.findCountByCid(cid);
		pagebean.setTotalCount(totalcount);
		//总页数
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
	//二级分类分页
	public pageBean<Product> findByPageCsid(int csid, int page) {
		
		pageBean<Product> pagebean=new pageBean<Product>();
		//设置当前页数
		pagebean.setPage(page);
		//每页显示的记录数
		int limit=8;
		pagebean.setLimit(limit);
		//总记录数
		int totalcount =0;
		totalcount=productDao.findCountByCsid(csid);
		pagebean.setTotalCount(totalcount);
		//总页数
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












