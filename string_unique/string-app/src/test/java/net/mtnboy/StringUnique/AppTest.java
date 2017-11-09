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

    public void testApp()
    {
        assertEquals(App.hasAllUnique(null), true);
        assertEquals(App.hasAllUnique(""), true);

        assertEquals(App.hasAllUnique("01234{}"), true);
        assertEquals(App.hasAllUnique("01234{}0"), false);

        assertEquals(App.hasAllUnique("abcABC"), true);
        assertEquals(App.hasAllUnique("ABCABC"), false);

        //skip long string test because I'm lazy to build a unit test for this. TBD with another test framework.

        assertEquals(App.hasAllUnique("a"), true);
        assertEquals(App.hasAllUnique("aa"), false);
    }
}
