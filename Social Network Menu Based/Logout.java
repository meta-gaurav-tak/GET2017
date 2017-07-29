/**
 * Action interface child class to add logout functionality
 * @author Gaurav Tak
 *
 */
public class Logout implements Action {

	@Override
	public void performAction() {
		MainMenu.currentUser=null;
	}
	
}
