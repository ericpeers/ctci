package net.mtnboy.StringUnique;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    public void testEmpties()
    {
        assertTrue(App.hasAllUnique(null));
        assertTrue(App.hasAllUnique(""));
    }

    public void testNums() {
        assertTrue(App.hasAllUnique("01234{}"));
        assertFalse(App.hasAllUnique("01234{}0"));
    }

    public void testCase() {
        assertTrue(App.hasAllUnique("abcABC"));
        assertFalse(App.hasAllUnique("ABCABC"));
    }

    //skip long string test because I'm lazy to build a unit test for this. TBD with another test framework.

    public void testShort() {
        assertTrue(App.hasAllUnique("a"));
        assertFalse(App.hasAllUnique("aa"));
    }

    public void testDup() {
        assertFalse(App.hasAllUnique("hello"));
        assertFalse(App.hasAllUnique("heloh"));
        assertFalse(App.hasAllUnique("eehlo"));
        assertFalse(App.hasAllUnique("ehloh"));
    }

    public void testNoDup() {
        assertTrue(App.hasAllUnique("abcdefghijklmno"));
        assertTrue(App.hasAllUnique("ABCDEFG"));
        assertTrue(App.hasAllUnique("abcCBA"));
    }

    public void testWhiteSpace() {
        assertTrue(App.hasAllUnique(" "));
        assertFalse(App.hasAllUnique("  "));
        assertTrue(App.hasAllUnique(" \t"));
        assertTrue(App.hasAllUnique(" \n"));
    }
}
