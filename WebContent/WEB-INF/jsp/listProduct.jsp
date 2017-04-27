<%@ page language="java" contentType="text/html; charset=UTF-8" import="entity.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<table border="1" width="80%">
			<tr>
				<th>产品编号</th>
				<th>产品名称</th>
				<th>产品价格</th>
				<th>产品厂家</th>
			</tr>
			<%
				entity.Page pageData = (Page)request.getAttribute("pageData");
				List<Product> productList = pageData.getProductList();
				for(Product p : productList){
					%>
						<tr>
							<td><%=p.getId() %></td>
							<td><%=p.getName() %></td>
							<td><%=p.getPrice() %></td>
							<td><%=p.getFactory() %></td>
						</tr>
					<%
				}
				%>
					<tr>
						<td colspan="4">
							<a href="productServlet?currentPageNumber=<%=pageData.getPreviousPageNumber() %>">上一页</a>
							<%
								int[] pages = pageData.getPageNumberBar();
								for(int i = 0 ; i < pages.length ; i++){
									%>
										<a href="productServlet?currentPageNumber=<%=pages[i]%>"><%=pages[i] %></a>
									<%
								}
							%>
							共<%=pageData.getTotalPageNumber() %>页,共<%=pageData.getTotalRecordCount() %>条,
							
							<a href="productServlet?currentPageNumber=<%=pageData.getNextPageNumber() %>">下一页</a>
							 
						</td>
					</tr>
				<%
			%>
		</table>
	</body>
</html>