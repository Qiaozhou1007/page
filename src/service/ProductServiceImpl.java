package service;

import dao.ProductDaoImpl;
import entity.Page;
import entity.PageQueryInfo;
import entity.PageQueryResult;

public class ProductServiceImpl {
	public Page getPageData(PageQueryInfo queryInfo){
		
		ProductDaoImpl pdi = new ProductDaoImpl();
		PageQueryResult pqr = pdi.queryPageResult(queryInfo.getStartIndex(), queryInfo.getPerPageRecordCount());
		Page page = new Page();
		
		page.setProductList(pqr.getProductList());
		page.setTotalRecordCount(pqr.getTotalRecordCount());
		
		page.setPerPageRecordCount(queryInfo.getPerPageRecordCount());
		page.setCurrentPageNumber(queryInfo.getCurrentPageNumber());
		
		return page;
	}
}
