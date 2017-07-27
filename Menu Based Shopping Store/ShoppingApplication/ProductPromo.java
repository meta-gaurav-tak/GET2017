package ShoppingApplication;

import java.util.Map;
import java.util.StringTokenizer;
/**
 * A dao Implementation class for Product Promotions
 * @author Gaurav Tak
 *
 */
public class ProductPromo {
	private String promoType;
	private String applicableProducts[];
	private double promoDiscount;
	private String promotionString;
	
	public ProductPromo() {
		promoType="";
		promotionString="";
	}
	
	public String getPromoType() {
		return promoType;
	}
	public void setPromoType(String promoType) {
		this.promoType = promoType;
	}
	public String[] getApplicableProducts() {
		return applicableProducts;
	}
	public void setApplicableProducts(String[] applicableProducts) {
		this.applicableProducts = applicableProducts;
	}
	public double getPromoDiscount() {
		return promoDiscount;
	}
	public void setPromoDiscount(double promoAmount) {
		this.promoDiscount = promoAmount;
	}
	
	/*Check if the product promotion is applicable on a product or not*/
	
	public Boolean isApplicable(String productId){
		Boolean flag=false;
		if(applicableProducts!=null) {
			for(int iterate=0;iterate<applicableProducts.length;iterate++) {
			if(productId.equals(applicableProducts[iterate])) {
				flag=true;
				break;
			} else {
				flag=false;
				}
			}
		}
		return flag;
	}
	
	/*to generate a ProductPromo Object in response of a line*/
	
	public static ProductPromo generatePromoObject(String line) {
		ProductPromo productPromo=new ProductPromo();
		StringTokenizer promoToken=new StringTokenizer(line,",");
		if(promoToken.countTokens()==3) {
			productPromo.setPromoType(promoToken.nextToken());
			productPromo.setPromoDiscount(Double.parseDouble(promoToken.nextToken()));
			String applicableProducts[]=promoToken.nextToken().split(";");
			productPromo.setApplicableProducts(applicableProducts);
		}
		return productPromo;
	}
	
	public ProductPromo(String promoType, String[] applicableProducts,
			double promoDiscount) {
		this.promoType = promoType;
		this.applicableProducts = applicableProducts;
		this.promoDiscount = promoDiscount;
		this.promotionString = "";
	}



	/*To generate the promotion string to be displayed for a particular product promotion*/
	
	public String generatePromotionString(Map<String,Product> productsMap) {
		if(promoType.equals("ProductFixedAmountPromotion")) {
			promotionString="Rs."+promoDiscount+"off on";
			for(int iterator=0;iterator<applicableProducts.length;iterator++) {
				promotionString+="  "+(productsMap.get(applicableProducts[iterator])).getProductName();
				promotionString+=" [Code:"+(productsMap.get(applicableProducts[iterator])).getProductId()+"]";
			}
		} else if(promoType.equals("ProductFixedPercentPromotion")) {
			promotionString=promoDiscount+"% off on";
			for(int iterator=0;iterator<applicableProducts.length;iterator++) {
				promotionString+="  "+(productsMap.get(applicableProducts[iterator])).getProductName();
				promotionString+=" [Code:"+(productsMap.get(applicableProducts[iterator])).getProductId()+"]";
			}
		}
		return (promotionString);
	}
	
}
