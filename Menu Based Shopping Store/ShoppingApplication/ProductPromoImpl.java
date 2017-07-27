package ShoppingApplication;

import java.util.List;

public class ProductPromoImpl extends ProductPromo {
	private static List<ProductPromo> productPromoList;
	
	/*Display product promotions from file*/
	public static void displayProductPromoList() {
		ReadFile fileReader=new ReadFile();
		List<String> productPromotionString=fileReader.readLineByLine(".\\src\\ProductPromo.csv");
		for(String promotion:productPromotionString) {
			System.out.println(promotion);
		}
	}

	public static List<ProductPromo> getProductPromoList() {
		return productPromoList;
	}

	public static void setProductPromoList(List<ProductPromo> productPromoList) {
		ProductPromoImpl.productPromoList = productPromoList;
	}
}
