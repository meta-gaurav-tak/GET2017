import ShoppingApplication.ShoppingStore;


public class GiveOrder implements Action {
	
	/**
	 * override parent class' performAction method to instance based overridden method
	 * This method here call the order taking method of Shopping Store
	 */
	@Override
	public void performAction() {
		System.out.println(ShoppingStore.takeOrder());
		
	}
}
