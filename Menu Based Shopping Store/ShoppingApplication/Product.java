package ShoppingApplication;

/**
 * A DAO class for product 
 * @author Gaurav Tak
 *
 */
public class Product {
	
	private String productId;
	private String productName;
	private double productRate;
	
	public Product() {
	}
	public Product(String productId, String productName, double productRate) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productRate = productRate;
	}
	
	//getters and setters
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductRate() {
		return productRate;
	}
	public void setProductRate(double productRate) {
		this.productRate = productRate;
	}
}
