package JUNIT_Test;
import org.junit.*;
import static org.junit.Assert.assertEquals;

import com.metacube.ShoppingCart.Controller.ShoppingStoreController;
import com.metacube.ShoppingCart.Enumerations.Status;
import com.metacube.ShoppingCart.Facade.CartFacade;
import com.metacube.ShoppingCart.Facade.ProductFacade;
import com.metacube.ShoppingCart.TO.CartEntry;

public class ShoppingStoreTest {
    private CartEntry cartEntry;
    private CartFacade shoppingCart;
    private ProductFacade productOperations;
    @Before
    public void setupProduct(){
        shoppingCart=new CartFacade();
        productOperations=new ProductFacade();
        productOperations.readProductsFromFile();
    }
    @Before
    public void generateCartEntry(){
    cartEntry=new CartEntry();
    cartEntry.setProductId("1003");
    cartEntry.setQuantity(7);
    cartEntry.setEntryNumber(1);
    }
    @Test
    public void addToCartTestSuccess(){
       Status status= ShoppingStoreController.addProductCart(cartEntry, productOperations,shoppingCart);
       assertEquals(Status.SUCCESS_ADDTOCART,status);
    }
    @Test
    public void addToCartFailInvalidCart(){
        Status status=ShoppingStoreController.addProductCart(new CartEntry(), productOperations,shoppingCart);
        assertEquals(Status.INVALID_CARTENTRY,status);
    }
    @Test
    public void addToCartTestSuccessSameItemTwice(){
       Status status= ShoppingStoreController.addProductCart(cartEntry, productOperations,shoppingCart);
       status= ShoppingStoreController.addProductCart(cartEntry, productOperations,shoppingCart);
       assertEquals(Status.SUCCESS_ADDTOCART,status);
    }
    @Test
    public void removeFromCartTest(){
        ShoppingStoreController.addProductCart(cartEntry, productOperations,shoppingCart);
        Status status=ShoppingStoreController.removeProductCart(cartEntry, productOperations, shoppingCart);
        assertEquals(Status.SUCCESS_REMOVECART,status); 
    }
    @Test
    public void removeFromCartTestFailure(){
        Status status=ShoppingStoreController.removeProductCart(cartEntry, productOperations, shoppingCart);
        assertEquals(Status.FAILURE_REMOVECART,status); 
    }
    @Test
    public void emptyCartDisplayTest(){
        String status=ShoppingStoreController.displayCart(productOperations, shoppingCart);
        assertEquals(Status.CART_EMPTY+"",status);
    }
    @Test
    public void emptyCartCheckoutTest(){
        String status=ShoppingStoreController.checkout(productOperations, shoppingCart);
        assertEquals(Status.CART_EMPTY+"",status);
    }
}
