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
        assertTrue("check null", App.hasAllUnique(null));
        assertTrue("check empty", App.hasAllUnique(""));
    }

    public void testNums() {
        assertTrue("check nums",  App.hasAllUnique("01234{}"));
        assertFalse("check nums with dup",  App.hasAllUnique("01234{}0"));
    }

    public void testCase() {
        assertTrue("check mixed case", App.hasAllUnique("abcABC"));
        assertFalse("check upcase dups", App.hasAllUnique("ABCABC"));
    }

    //skip long string test because I'm lazy to build a unit test for this. TBD with another test framework.

    public void testShort() {
        assertTrue("check singleton", App.hasAllUnique("a"));
        assertFalse("check dup, but short", App.hasAllUnique("aa"));
    }

    public void testDup() {
        assertFalse(App.hasAllUnique("hello"));
        assertFalse(App.hasAllUnique("heloh"));
        assertFalse(App.hasAllUnique("eehlo"));
        assertFalse(App.hasAllUnique("ehloh"));
    }

    public void testNoDup() {
        assertTrue("simple no dup", App.hasAllUnique("abcdefghijklmno"));
        assertTrue("upcase no dup", App.hasAllUnique("ABCDEFG"));
        assertTrue("mixcase, no dup", App.hasAllUnique("abcCBA"));
    }

    public void testWhiteSpace() {
        assertTrue("white space, no dup", App.hasAllUnique(" "));
        assertFalse("double space, dup", App.hasAllUnique("  "));
        assertTrue("mixed space, no dup", App.hasAllUnique(" \t"));
        assertTrue("mixed space no dup2", App.hasAllUnique(" \n"));
    }
}
