import ShoppingApplication.*;
public class DisplayProductList implements Action {

	/**
	 * override parent class' performAction method to instance based overridden method
	 * This method here displays the product list
	 */
	@Override
	public void performAction() {
		ProductDaoImpl.displayProductList();
	}
}
