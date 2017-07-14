import static org.junit.Assert.assertEquals;
import org.junit.Test;
public class Question1_BinToOctTest{
  @Test
  public void testConvertBinaryToOctal() {
    Question1_BinToOct b2o = new Question1_BinToOct();
    assertEquals(1111,b2o.convertBinaryToOctal(1001001001));
  }
  @Test
  public void testConvertBinaryToOctal() {
    Question1_BinToOct b2o = new Question1_BinToOct(); 
    assertEquals(56,b2o.convertBinaryToOctal(101110));
  }
  @Test
  public void testConvertBinaryToOctal() {
    Question1_BinToOct b2o = new Question1_BinToOct();
    assertEquals(172,b2o.convertBinaryToOctal(1111010));
  } 
}