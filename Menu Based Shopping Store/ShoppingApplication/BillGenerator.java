package ShoppingApplication;

import java.util.List;
import java.util.Map;


public class BillGenerator {
	
	public static String billString;
	
	public static String getBill(OrderEntry[] order,Map<String,Product> productMap,
			List<OrderPromo> orderPromoList,List<ProductPromo> productPromoList) {
		
		billString="\n";
		billString+="###############################################\n";
		billString+="YOUR ORDER  : \n";
		billString+="###############################################\n";
		billString+="\n";
		billString+="PURCHASED PRODUCTS :  \n";
		
		double finalBillingAmount=0;
		
		for(int orderLoop=0;orderLoop<order.length;orderLoop++) {		//loop through each order entry
			
			Product currentProduct=productMap.get(order[orderLoop].getProductId());
			
			billString+="Product : "+currentProduct.getProductId()+" - "+
					currentProduct.getProductName()+"\n";
			order[orderLoop].setCostOfOrder(order[orderLoop].getQuantity()*currentProduct.getProductRate());
			
			billString+="Cost    : Rs."+order[orderLoop].getCostOfOrder()+
					"("+order[orderLoop].getQuantity()+" x "
					+currentProduct.getProductRate()+")"+"\n\n";
			order[orderLoop].evaluateApplicablePromotions(productPromoList);
			order[orderLoop].evaluateProductDiscount(currentProduct);
			finalBillingAmount+=order[orderLoop].getCostOfOrder();
		}
		
		billString+="Subtotal : Rs. "+finalBillingAmount;
		billString+="\n";
		billString+="\n";
		double productPromotionDiscount=0;
		for(int orderLoop=0;orderLoop<order.length;orderLoop++) {
			if(!order[orderLoop].getAppliedPromotion().generatePromotionString(productMap).equals("")){
			billString+="Promotion : "+order[orderLoop].getAppliedPromotion().generatePromotionString(productMap)+"\n";
			billString+="Discount  : "+order[orderLoop].getDiscountAmount()*order[orderLoop].getQuantity();
			billString+="\n";
			productPromotionDiscount+=(order[orderLoop].getDiscountAmount()*order[orderLoop].getQuantity());  // product promotion discount amount
			}
			
		}
		billString+="\n";
		billString+="Product Promotions Discount : Rs."+productPromotionDiscount+"\n";
		finalBillingAmount-=productPromotionDiscount;
		double finalOrderDiscount=0;
		
		OrderPromo appliedOrderPromotion=null;
		for(OrderPromo promotion:orderPromoList) {
			double discount=0;
			if(promotion.isApplicable(finalBillingAmount)){
				discount=promotion.getPromoDiscount();
				if(promotion.getPromoType().equals("OrderFixedPercentPromotion")) {
					discount=discount*finalBillingAmount/100.0;
				}
			}
			if(discount>finalOrderDiscount) {
				finalOrderDiscount=discount;
				appliedOrderPromotion=promotion;
			}
		}
		
		billString+=appliedOrderPromotion!=null?appliedOrderPromotion.generateOrderPromotionString():"";
		
		billString+="Final Amount Payable : Rs."+(finalBillingAmount-finalOrderDiscount);
		WriteFile.write(billString,"CurrentBill.txt");
		return billString;
	}
}
