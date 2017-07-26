import java.util.StringTokenizer;
/**
 * A dao implementation class for product
 * @author Gaurav Tak
 *
 */
public class ProductDaoImpl extends Product {
	
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
