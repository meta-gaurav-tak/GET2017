
public class Exit implements Action {
	
	/**
	 * override parent class' performAction method to instance based overridden method
	 * defined to exit from the menu
	 */
	@Override
	public void performAction() {
		System.exit(0);	
	}
}
