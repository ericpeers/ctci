package net.mtnboy.String20;

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

    /**
     * Rigourous Test :-)
     */
    public void testEmpties() {
        assertEquals(App.string_20(""), "");
        assertEquals(App.string_20(null), null);
    }

    public void testNoSpace() {
        assertEquals(App.string_20("EricPeers"), "EricPeers");
    }

    public void testOnlySpace() {
        assertEquals(App.string_20(" "), "%20");
        assertEquals(App.string_20("  "), "%20%20");
        assertEquals(App.string_20("   "), "%20%20%20");
    }

    public void testSpaceBoundary() {
        assertEquals(App.string_20(" ab"), "%20ab");
        assertEquals(App.string_20("ab cd"), "ab%20cd");
        assertEquals(App.string_20("xy "), "xy%20");
    }

    public void testMultiSpace() {
        assertEquals(App.string_20(" ab cd de "), "%20ab%20cd%20de%20");
    }
}
