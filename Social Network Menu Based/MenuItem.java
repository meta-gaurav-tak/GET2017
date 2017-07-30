/**
 * this class defines the abstract menu item class 
 * Menu item Holds the display value for an item of menu
 * @author Gaurav Tak
 *
 */
public abstract class MenuItem {
	
	private String displayName;

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

}
