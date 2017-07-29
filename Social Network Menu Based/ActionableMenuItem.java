/**
 * a class that defines a menu item as an actionable leaf node and triggers actions
 * @author Gaurav Tak
 *
 */
public class ActionableMenuItem extends MenuItem{
	
	private Action action;						// reference to a Action type object
	
	public ActionableMenuItem(Action action) {
		this.action = action;
	}
	
	public void triggerAction() {				// triggers the performAction method of Action type 
		action.performAction();
	}
}