import homework.calculator_for_testing.TestCalculator;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import lessons.for_test.Calculator;
import org.junit.*;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.IOException;

@RunWith(JUnitParamsRunner.class)
public class CalculatorTest {
    private TestCalculator testCalculator = new TestCalculator();

    //////////////////Test Calculator
    @Test
    public void shouldReturnSum() {
        int sum = testCalculator.sum(1, 8);
        Assert.assertEquals("9", 9, sum);

    }

    @Test
    @Parameters({"5|6","7|8"})
    public void shouldReturnSumWithJUnitParams(int value1, int value2) {

        Assert.assertEquals(value1 + value2, testCalculator.sum(value1, value2));

    }

    @Test
    public void shouldReturnSubValues() {
        int sub = testCalculator.sub(1, 8);
        Assert.assertEquals("-7", -7, sub);

    }

    @Test
    public void shouldReturnDiv() {
        TestCalculator testCalculator = new TestCalculator();
        int div = testCalculator.div(1, 8);
        Assert.assertEquals("0", 0, div);

    }

    @Test
    public void shouldReturnMult() {
        TestCalculator testCalculator = new TestCalculator();
        int mult = testCalculator.mult(1, 8);
        Assert.assertEquals("8", 8, mult);

    }

    //////////////////////////
    @Test
    public void shouldReturnSumValue() {
        Calculator calculator = new Calculator();

        int sum = calculator.sum(6, 7);
        Assert.assertEquals("Expected 13", 13, 13);
    }

    @Before
    public void beforeEachTest() {
//        System.out.println("Before each method");
    }

    @BeforeClass
    public static void beforeAllTests() {
//        System.out.println("Before all methods");
    }

    @AfterClass
    public static void afterAllTests() {
//        System.out.println("After all methods");
    }

    @After
    public void afterEachTest() {
//        System.out.println("After each method");
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Rule
    public SystemOutRule outRule = new SystemOutRule().enableLog();

    /*
     * create file -> copy file -> delete all files
     *
     * dir(file  -> copy to subdir(copiedFile))
     * */

    @Test
    public void shouldPrintInConsole() {

        new Calculator().print();

        String log = outRule.getLog();

//        Assert.assertTrue(log.equals("Hello world\r\n"));
        Assert.assertTrue(log.contains("Hello world"));
    }

    @Test
    public void useTemporaryFolder() throws IOException {
        File file = folder.newFolder("run", "gun");

      //  Path path = Paths.get(file.toString(), "Foo.txt");

   //     Files.createFile(path);

//        File file1 = folder.newFile("Hello.txt");

        System.out.println();
    }


    @Test
    public void shouldReturnSumValues() {
        Calculator calculator = new Calculator();

        int sum = calculator.sum(7, 5);

        Assert.assertEquals("Should return 12", 12, sum);
    }

    @Test
    public void shouldReturnSumValues1() {
        Calculator calculator = new Calculator();

        int sum = calculator.sum(7, 5);

        Assert.assertEquals("Should return 12", 12, sum);
    }

    @Test(expected = IOException.class)
    public void shouldThrowException() throws IOException {
        new Calculator().throwException();
    }

    @Test
    public void shouldThrowExceptionUsingRule() throws IOException {
        exception.expect(IOException.class);

        exception.expectMessage("Class not found");

        new Calculator().throwException();

    }


}
