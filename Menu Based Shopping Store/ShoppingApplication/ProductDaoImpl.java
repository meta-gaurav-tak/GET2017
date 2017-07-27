package ShoppingApplication;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
/**
 * A dao implementation class for product
 * @author Gaurav Tak
 *
 */
public class ProductDaoImpl extends Product {
	
	private static List<Product> productList;
	private static Map<String,Product> productMap;
	
	public static Map<String, Product> getProductMap() {
		return productMap;
	}
	public static void setProductMap() {
		productMap=new HashMap<String,Product>();
		for(Product product:productList) {
			productMap.put(product.getProductId(),product);
		}	
	}
	
	public static void setProductList(List<Product> productList) {
		ProductDaoImpl.productList = productList;
	}
	
	/*Display product list from file*/
	public static void displayProductList() {
		ReadFile fileReader=new ReadFile();
		List<String> productListString=fileReader.readLineByLine(".\\src\\ProductList.csv");
		for(String product:productListString) {
			System.out.println(product);
		}
	}
	public static List<Product> getProductList() {
		return productList;
	}
	
	/*generate a product object in response of a line*/
	public static Product generateProductObject(String line) {
		Product product=new Product();
		StringTokenizer productToken=new StringTokenizer(line,",");
		if(productToken.countTokens()==3) {
			product.setProductId(productToken.nextToken());
			product.setProductName(productToken.nextToken());
			product.setProductRate(Double.parseDouble(productToken.nextToken()));
		}
		return product;
	}
	
	
}
