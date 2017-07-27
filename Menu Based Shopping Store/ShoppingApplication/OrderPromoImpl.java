package ShoppingApplication;

import java.util.List;

public class OrderPromoImpl {
	private static List<OrderPromo> orderPromoList;
	
	/* displays the order promotion list*/
	public static void displayOrderPromoList(){	
		ReadFile fileReader=new ReadFile();
		List<String> orderPromotionString=fileReader.readLineByLine(".\\src\\OrderPromo.csv");
		for(String promotion:orderPromotionString) {
			System.out.println(promotion);
		}
	}

	public static List<OrderPromo> getOrderPromoList() {
		return orderPromoList;
	}

	public static void setOrderPromoList(List<OrderPromo> orderPromoList) {
		OrderPromoImpl.orderPromoList = orderPromoList;
	}
}
