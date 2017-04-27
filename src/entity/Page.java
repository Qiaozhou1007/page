package entity;

import java.util.List;

/**
 * 封闭页面内容
 */
public class Page {
	private List<Product> productList = null;// 当前页面条目 
	private int totalRecordCount;// 总记录条数
	private int currentPageNumber;  // 用户当前需要查看的页码
	private int perPageRecordCount;  // 每页显示的记录条数
	private int totalPageNumber; //总页数
	private int previousPageNumber;
	private int nextPageNumber;
	private int[] pageNumberBar; // 页码条
	
	public int getTotalPageNumber() {
		if(totalRecordCount % perPageRecordCount == 0){
			totalPageNumber = totalRecordCount / perPageRecordCount;
		}else{
			totalPageNumber =  totalRecordCount / perPageRecordCount + 1;
		}
		return totalPageNumber;
	}
	public int[] getPageNumberBar() {
		int[] bar = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		 
		this.pageNumberBar = bar;
		return pageNumberBar;
	}
	public int getPreviousPageNumber() {
		if(currentPageNumber - 1 < 1){
			previousPageNumber = 1;
		}else{
			previousPageNumber = currentPageNumber - 1;
		}
		return previousPageNumber;
	}
	public int getNextPageNumber() {
		if(currentPageNumber + 1 > totalPageNumber){
			nextPageNumber = totalPageNumber;
		}else{
			nextPageNumber = currentPageNumber + 1 ;
		}
		return nextPageNumber;
	}
	
	//----------------------------------------
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
	public int getCurrentPageNumber() {
		return currentPageNumber;
	}
	public void setCurrentPageNumber(int currentPageNumber) {
		this.currentPageNumber = currentPageNumber;
	}
	public int getPerPageRecordCount() {
		return perPageRecordCount;
	}
	public void setPerPageRecordCount(int perPageRecordCount) {
		this.perPageRecordCount = perPageRecordCount;
	}
	
	
}
