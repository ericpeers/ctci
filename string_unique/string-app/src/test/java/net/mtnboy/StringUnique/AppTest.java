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
        assertTrue("check null", App.hasAllUnique2(null));
        assertTrue("check empty", App.hasAllUnique2(""));

        //what I want is something more like:
        /*
            foreach method in (hasAllUnique, hasAllUnique2) {
                assertTrue("check null", App.method(null));
                ...
            }
        */
    }

    public void testNums() {
        assertTrue("check nums",  App.hasAllUnique("01234{}"));
        assertFalse("check nums with dup",  App.hasAllUnique("01234{}0"));
        assertTrue("check nums",  App.hasAllUnique2("01234{}"));
        assertFalse("check nums with dup",  App.hasAllUnique2("01234{}0"));
    }

    public void testCase() {
        assertTrue("check mixed case", App.hasAllUnique("abcABC"));
        assertFalse("check upcase dups", App.hasAllUnique("ABCABC"));
        assertTrue("check mixed case", App.hasAllUnique2("abcABC"));
        assertFalse("check upcase dups", App.hasAllUnique2("ABCABC"));
    }

    //skip long string test because I'm lazy to build a unit test for this. TBD with another test framework.

    public void testShort() {
        assertTrue("check singleton", App.hasAllUnique("a"));
        assertFalse("check dup, but short", App.hasAllUnique("aa"));
        assertTrue("check singleton", App.hasAllUnique2("a"));
        assertFalse("check dup, but short", App.hasAllUnique2("aa"));
    }

    public void testDup() {
        assertFalse(App.hasAllUnique("hello"));
        assertFalse(App.hasAllUnique("heloh"));
        assertFalse(App.hasAllUnique("eehlo"));
        assertFalse(App.hasAllUnique("ehloh"));
        assertFalse(App.hasAllUnique2("hello"));
        assertFalse(App.hasAllUnique2("heloh"));
        assertFalse(App.hasAllUnique2("eehlo"));
        assertFalse(App.hasAllUnique2("ehloh"));
    }

    public void testNoDup() {
        assertTrue("simple no dup", App.hasAllUnique("abcdefghijklmno"));
        assertTrue("upcase no dup", App.hasAllUnique("ABCDEFG"));
        assertTrue("mixcase, no dup", App.hasAllUnique("abcCBA"));
        assertTrue("simple no dup", App.hasAllUnique2("abcdefghijklmno"));
        assertTrue("upcase no dup", App.hasAllUnique2("ABCDEFG"));
        assertTrue("mixcase, no dup", App.hasAllUnique2("abcCBA"));
    }

    public void testWhiteSpace() {
        assertTrue("white space, no dup", App.hasAllUnique(" "));
        assertFalse("double space, dup", App.hasAllUnique("  "));
        assertTrue("mixed space, no dup", App.hasAllUnique(" \t"));
        assertTrue("mixed space no dup2", App.hasAllUnique(" \n"));
    }

    public void testExtendedChars() {
        char [] extended = new char[3];
        extended[0] = 236;
        extended[1] = 219;
        extended[2] = 202;
        String extendedStr = new String(extended);
        assertTrue("extended chars", App.hasAllUnique(extendedStr));

        extended[2] = 236;
        extendedStr = new String(extended);
        assertFalse("extended chars", App.hasAllUnique(extendedStr));}
}
