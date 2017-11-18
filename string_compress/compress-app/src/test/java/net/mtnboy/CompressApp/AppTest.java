package net.mtnboy.CompressApp;

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

    public void testNullEmpty() {
        assertEquals(App.compress(null), null);
        assertEquals(App.compress(""), "");
    }

    public void testShort() {
        assertEquals(App.compress("a"), "a");
        assertEquals(App.compress("aaa"), "a3");
        assertEquals(App.compress("aa"), "a2");
        assertEquals(App.compress("ab"), "ab");
    }

    public void testCompress() {
        assertEquals("a3b3", App.compress("aaabbb"));
        assertEquals("a3b3a3", App.compress("aaabbbaaa"));
        assertEquals("a3b3a3c1", App.compress("aaabbbaaac"));
    }
}
