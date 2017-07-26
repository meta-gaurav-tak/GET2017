import java.util.StringTokenizer;
/**
 * A daoImplementation class for OrderPromotions 
 * @author Gaurav Tak
 *
 */
public class OrderPromo {
	
	private String promoType;			//the type of promotion
	private double promoDiscount;		// the discount amount or percent
	private double threshHold;			//the threshHold value for discount to be applicable
	
	public OrderPromo(String promoType, double promoDiscount, double threshHold) {
		this.promoType = promoType;
		this.promoDiscount = promoDiscount;
		this.threshHold = threshHold;
	}
	public OrderPromo() {
	}
	
	//getters and setters
	public String getPromoType() {
		return promoType;
	}
	public void setPromoType(String promoType) {
		this.promoType = promoType;
	}
	public double getPromoDiscount() {
		return promoDiscount;
	}
	public void setPromoDiscount(double promoAmount) {
		this.promoDiscount = promoAmount;
	}
	public double getThreshHold() {
		return threshHold;
	}
	public void setThreshHold(double threshHold) {
		this.threshHold = threshHold;
	}
	public Boolean isApplicable(double orderAmount) {
		return orderAmount>getThreshHold()?true:false;
	}
	
	public String generateOrderPromotionString() {
		return ("Order Promotion Applied : "+this.getPromoDiscount()+" % off on "
				+this.getThreshHold()+" and above order\n");
	}
	
	/*generate a new OrderPromo Object in response of a line*/ 
	
	public static OrderPromo generatePromoObject(String line) {
		OrderPromo orderPromo=new OrderPromo();
		StringTokenizer promoToken=new StringTokenizer(line,",");
		if(promoToken.countTokens()==3) {
			orderPromo.setPromoType(promoToken.nextToken());
			orderPromo.setPromoDiscount(Double.parseDouble(promoToken.nextToken()));
			orderPromo.setThreshHold(Double.parseDouble(promoToken.nextToken()));
		}
		return orderPromo;
	}
}
