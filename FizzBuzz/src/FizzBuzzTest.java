import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FizzBuzzTest {
	public FizzBuzz fBuzz;
	@Before
	public void setUp() throws Exception {
		fBuzz = new FizzBuzz();
	}

    @Test
    public void testForFizz() {
        String result = fBuzz.fizzBuzz(3);
        assertTrue(result.equals("fizz"));
    }
    
    @Test
    public void testForBuzz() {
        String result = fBuzz.fizzBuzz(5);
        assertTrue(result.equals("buzz"));
    }
    
    @Test
    public void testForFizzBuzz() {
        String expected = "fizzbuzz";
        String actual = fBuzz.fizzBuzz(30);
        assertTrue(actual.equals(expected));
    }

}
