package entity;
/**
 * 封装用户查询信息
 */
public class PageQueryInfo {
	private int currentPageNumber = 1; // 用户当前需要查看的页码
	private int perPageRecordCount = 5; // 每页显示的记录条数
	
	private int startIndex;
	
	public int getStartIndex() {
		this.startIndex = (currentPageNumber - 1) * perPageRecordCount;
		return startIndex;
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
