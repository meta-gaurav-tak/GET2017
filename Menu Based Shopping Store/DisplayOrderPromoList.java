import ShoppingApplication.OrderPromoImpl;


public class DisplayOrderPromoList implements Action {
	
	/**
	 * override parent class' performAction method to instance based overridden method
	 * displays orderPromotions list line by line
	 */
	@Override
	public void performAction() {
		OrderPromoImpl.displayOrderPromoList();
	}

}
