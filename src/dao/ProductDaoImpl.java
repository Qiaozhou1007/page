package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.PageQueryResult;
import entity.Product;

public class ProductDaoImpl {
	//程序使用数组封装查询的具体商品信息，并传递
	public PageQueryResult queryPageResult(int startIndex , int perPageRecordCount){
		
		PageQueryResult pqr = new PageQueryResult();
		List<Product> productList = new ArrayList<>();
		String SQL1 = " SELECT * FROM Product LIMIT ? , ? ";
		String SQL2 = " SELECT COUNT(*) AS TotalRecordCount FROM Product ";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql:///page", "root", "123456");
			PreparedStatement pst = connection.prepareStatement(SQL1);
			pst.setInt(1, startIndex);
			pst.setInt(2, perPageRecordCount);
			
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				Product product = new Product();
				product.setId(rs.getInt("ProductId"));
				product.setName(rs.getString("Name"));
				product.setPrice(rs.getDouble("Price"));
				product.setFactory(rs.getString("Factory"));
				productList.add(product);
			}
			pqr.setProductList(productList);
			pst = connection.prepareStatement(SQL2);
			rs = pst.executeQuery();
			rs.next();
			pqr.setTotalRecordCount(rs.getInt("TotalRecordCount"));
		}catch(Exception ex){
			
		}
		return pqr;
	}
}
