package page;

import java.util.List;

import dao.ProductDaoImpl;
import entity.PageQueryResult;
import entity.Product;

public class Client {

	public static void main(String[] args) {
		ProductDaoImpl pdi = new ProductDaoImpl();
		PageQueryResult pqr = pdi.queryPageResult(10, 5);
		
		List<Product> productList = pqr.getProductList();
		for(Product p : productList){
			System.out.println(p.getId()+"   "+ p.getName() + "  " + p.getPrice() + " " + p.getFactory());
		}
		
		System.out.println(pqr.getTotalRecordCount());
	}

}
