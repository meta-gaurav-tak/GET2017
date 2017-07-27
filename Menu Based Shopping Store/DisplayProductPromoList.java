import ShoppingApplication.ProductPromoImpl;

public class DisplayProductPromoList implements Action {
	
	/**
	 * override parent class' performAction method to instance based overridden method
	 * this method displays the product Promotions line by line
	 */
	@Override
	public void performAction() {
		ProductPromoImpl.displayProductPromoList();
	}
}
