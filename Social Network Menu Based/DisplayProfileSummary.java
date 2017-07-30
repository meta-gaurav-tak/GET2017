/**
 * Action interface child class to print summary of current user
 * @author Gaurav Tak
 *
 */
public class DisplayProfileSummary implements Action{

	@Override
	public void performAction() {
		if(MainMenu.currentUser!=null) {
			MainMenu.currentUser.showSummary();
		} else { 
			System.out.println("No user Logged in : Login First ");
		}
	}
	
}
