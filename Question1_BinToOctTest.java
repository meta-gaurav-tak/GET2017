import static org.junit.Assert.assertEquals;
import org.junit.Test;
/**
 * This class is designed to test BinaryToOctal class functionality
 * @author Gaurav Tak
 *
 */
public class Question1_BinToOctTest {
  @Test
  public void testConvertBinaryToOctalNonTriplet() {
    Question1_BinToOct b2o = new Question1_BinToOct();
    assertEquals(1111,b2o.convertBinaryToOctal(1001001001));
  }
  
  @Test
  public void testConvertBinaryToOctalTriplet() {
    Question1_BinToOct b2o = new Question1_BinToOct();
    assertEquals(56,b2o.convertBinaryToOctal(101110));
  }
  
  @Test
  public void testConvertBinaryToOctalNonTripletFalse() {
    Question1_BinToOct b2o = new Question1_BinToOct();  
    assertEquals(1101,b2o.convertBinaryToOctal(1001001001));
  }
  
  @Test
  public void testConvertBinaryToOctalTripletFalse() {
    Question1_BinToOct b2o = new Question1_BinToOct();
    assertEquals(42,b2o.convertBinaryToOctal(110110));
  }
}