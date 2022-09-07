import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;
// This is an annotation for assigning point values to tests
import com.gradescope.jh61b.grader.GradedTest;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

// Import anything else you need to run the tests, such as the students' classes

public class MyTestClass {

    @Test
    @GradedTest(name="Test CtoF with 0", max_score=6)
    public void test_ctof_0() {
        System.out.println("Testing 0.0 degree celcius");
        String userInput = "0.0";
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        CtoF.main(null); // call the main method

        String expected = "Temperature in Celcius: " + userInput + " degrees Celcius is 32.0 degrees Fahrenheit.";
        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];  // second last line

        // checkout output
        Assert.assertEquals(expected,actual);

    }

    @Test
    @GradedTest(name="Test CtoF with 100", max_score=6)
    public void test_ctof_100() {
        System.out.println("Testing 100 degree celcius");
        String userInput = "100.0";
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        CtoF.main(null); // call the main method

        String expected = "Temperature in Celcius: " + userInput + " degrees Celcius is 212.0 degrees Fahrenheit.";
        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];  // second last line

        // checkout output
        Assert.assertEquals(expected,actual);
    }

    @Test
    @GradedTest(name="Test CtoF with random value", max_score=8)
    public void test_ctof_random() {
        System.out.println("Testing a random value");
        Random random = new Random();
        String userInput = "" + random.nextInt(1000);
        double inputDouble = Double.parseDouble(userInput);
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        CtoF.main(null); // call the main method

        double x = 9.0/5.0 * Double.parseDouble(userInput) + 32;

        String expected = "Temperature in Celcius: " + inputDouble + " degrees Celcius is " + x  + " degrees Fahrenheit.";
        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];  // second last line

        // checkout output
        Assert.assertEquals(expected,actual);
    }
}
