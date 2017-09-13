import java.util.List;

import com.metacube.Helper.LibraryDataHelper;
import com.metacube.Helper.Menu;
import com.metacube.Model.Title;
import com.metacube.Utility.Utility;
/**
 * class to provide user interactivity to the user  on  library database
 * @author GAURAV TAK
 *
 */
public class Main {
    public static void main(String args[]) {
        LibraryDataHelper libraryDataHelper = new LibraryDataHelper();
        do {
            Menu.displayMenu();
            int choice = Utility.getChoiceInput();
            switch(choice) {
                case 1:
                    System.out.println("Enter author name ");
                    String authorName = Utility.getStringInput();
                    List<Title> listOfTitlesByAuthor = libraryDataHelper.titlesByAuthor(authorName);
                    System.out.println("Title ID\t Title Name\t Publisher ID\t Subject ID\t");
                    for(Title title : listOfTitlesByAuthor) {
                        System.out.println(title.getTitleId()+"\t "+title.getTitleName()+"\t "+title.getPublisherId()+"\t "+title.getSubjectId());
                    }
                    break;
                case 2:
                    System.out.println("Enter member name ");
                    String memberName = Utility.getStringInput();
                    System.out.println("Enter book name ");
                    String bookName = Utility.getStringInput();
                    boolean isIssued = libraryDataHelper.isBookIssued(bookName,memberName);
                    if(isIssued) {
                        System.out.println("the book has been issued");
                    } else {
                        System.out.println("the book has not been issued");
                    }
                    break;
                case 3:
                    int obsoleteBooks = libraryDataHelper.deleteUnpopularBooks();
                    System.out.println("Removed " + obsoleteBooks+" books from database since not issued for a year now ");
                    break;
                case 4 :
                    System.exit(0);
            }
        } while(true);
    }
}
