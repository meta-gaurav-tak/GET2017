import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import SocialNetwork.Connection;
import SocialNetwork.Entity;
import SocialNetwork.Graph;
import SocialNetwork.Organisation;
import SocialNetwork.Person;
import SocialNetwork.ReadFile;
import SocialNetwork.SocialNetwork;
/**
 * this class defines the main menu for the menu and defines basic methods
 * @author Gaurav Tak
 *
 */
public class MainMenu {
    
	public static Entity currentUser;  //will hold the reference for currently logged in user 
	
	/**
	 * method to define the main menu structure and buttons
	 * @return
	 */
	public static Menu createMenu() {
		
		Menu mainMenu=new Menu();			          //a main menu object
		mainMenu.setDisplayName("Main Menu");
		
		MenuItem menuItemLogin=new ActionableMenuItem(new Login());	// menu item that is action-able performs login 
		List<MenuItem> subMenu=mainMenu.getSubMenu();
		menuItemLogin.setDisplayName("1. Login");
		subMenu.add(menuItemLogin);
		
		
		MenuItem menuItemConnection=new Menu();
		menuItemConnection.setDisplayName("2. Add connection"); // to add connecttions for currently logged in user
		subMenu.add(menuItemConnection);
		
		/*Creating submenu for Adding connection menu*/
		List<MenuItem> subPromoMenu=((Menu) menuItemConnection).getSubMenu();
		
		MenuItem menuItemSummaryAll=new ActionableMenuItem(new SummaryAll());	
		menuItemSummaryAll.setDisplayName("1. View all profiles summary");
		subPromoMenu.add(menuItemSummaryAll);
				
		MenuItem menuItemAddConnection=new ActionableMenuItem(new AddConnection());		
		menuItemAddConnection.setDisplayName("2. To add a connection by its username");
		subPromoMenu.add(menuItemAddConnection);
			
		/*add back functionality to go to previous menu*/	
        MenuItem menuItemBack=new Back();
        menuItemBack.setDisplayName("3. Previous Menu");
        subPromoMenu.add(menuItemBack);
			
		/*End Of Promo Submenu*/
		MenuItem menuItemSummary=new ActionableMenuItem(new DisplayProfileSummary());
		menuItemSummary.setDisplayName("3. Summary for your profile");
		subMenu.add(menuItemSummary);
		
		MenuItem menuItemSearch=new ActionableMenuItem(new SearchEntity());						
		menuItemSearch.setDisplayName("4. Search User By name");
		subMenu.add(menuItemSearch);
		
		MenuItem menuItemShow=new ActionableMenuItem(new ShowSocialNetwork());						
		menuItemShow.setDisplayName("5. Display Social Network");
		subMenu.add(menuItemShow);
		
		MenuItem menuItemLogout=new ActionableMenuItem(new Logout());						
		menuItemLogout.setDisplayName("6. Logout");
		subMenu.add(menuItemLogout);
		
		MenuItem menuItemExit=new ActionableMenuItem(new Exit());
		menuItemExit.setDisplayName("7. Exit");
		subMenu.add(menuItemExit);
		
		return mainMenu;	
	}
	
	/* to display a menu passed as argument*/
	public static void display(Menu menu){													
		
		Iterator<MenuItem> itr=menu.getSubMenu().iterator();
		System.out.println("###########  MENU  ############");
		while(itr.hasNext()){
			System.out.println(itr.next().getDisplayName());
		}
		
	}
	
	/* a method to display menu and perfornm actions on actionable menu  */
	public static void displayAndPerformAction(Menu menu) {
	    while (true) { // to loop until exit is pressed
			display(menu);
			int choice = menu.getInput();
			MenuItem menuItem = menu.getSelection(choice);

			if (menuItem == null) {                              //if choice is invalid re-display menu
				displayAndPerformAction(menu);
			} else if (menuItem instanceof ActionableMenuItem) { //it choice item is actionable trigger action
				((ActionableMenuItem) menuItem).triggerAction();
			} else if (menuItem instanceof Menu) {               // if the choice contains a menu within it
				((Menu) menuItem).setParentMenu(menu);
				displayAndPerformAction((Menu) menuItem);
			} else {                                             // to go back to previous menu
				displayAndPerformAction(menu.getParentMenu());
			}
		}
	}
	
	/*Main function for initial call*/
	public static void main(String args[]) {
	    
		/*Reads the user profile data from file and populates person and organisation list*/
		SocialNetwork.readInformationFromFile();
		Entity.generateEntityMap();
		List<Connection> connectedEntities=new ArrayList<Connection>();
		Graph.setConnectedEntities(connectedEntities);
		
		/*Code to run Menu*/
		Menu mainMenu=MainMenu.createMenu();
		mainMenu.setParentMenu(mainMenu);
		MainMenu.displayAndPerformAction(mainMenu);
		
	}
}
