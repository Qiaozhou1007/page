package entity;

import java.util.List;

/**
 * 封装页面显示的数据内容结果
 */
public class PageQueryResult {
	private List<Product> productList = null; // 当前页面条目 
	private int totalRecordCount;// 总记录条数
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	public int getTotalRecordCount() {
		return totalRecordCount;
	}
	public void setTotalRecordCount(int totalRecordCount) {
		this.totalRecordCount = totalRecordCount;
	}
	
	
}
