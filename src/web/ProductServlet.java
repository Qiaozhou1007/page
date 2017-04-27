package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Page;
import entity.PageQueryInfo;
import service.ProductServiceImpl;
@WebServlet("/productServlet")
public class ProductServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//收集请求信息
		PageQueryInfo queryInfo = new PageQueryInfo();
		String currentPageNumber = request.getParameter("currentPageNumber");
		String perPageRecordCount = request.getParameter("perPageRecordCount");
		if(currentPageNumber != null && currentPageNumber.trim().length() > 0){
			queryInfo.setCurrentPageNumber(Integer.parseInt(currentPageNumber));
		}
		if(perPageRecordCount != null && perPageRecordCount.trim().length() > 0){
			queryInfo.setPerPageRecordCount(Integer.parseInt(perPageRecordCount));
		}
	 //------------------------------------------------------------------------------
		
		//调用业务层产生页面数据
		ProductServiceImpl psi = new ProductServiceImpl();
		Page pageData = psi.getPageData(queryInfo);
		request.setAttribute("pageData", pageData);
		//转发视图
		request.getRequestDispatcher("/WEB-INF/jsp/listProduct.jsp").forward(request, response);
	}
}
