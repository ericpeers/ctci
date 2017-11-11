package net.mtnboy.StringPermute;

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

    public void testNull(){
        assertTrue(App.permute(null, null));
        assertFalse(App.permute(null, "hello"));
        assertFalse(App.permute("", null));
    }
    public void testEmpty() {
        assertTrue(App.permute("", ""));
        assertFalse(App.permute("", " "));
        assertFalse(App.permute("a", ""));
    }
    public void testShort() {
        assertTrue(App.permute("a", "a"));
        assertTrue(App.permute("aa", "aa"));
        assertFalse(App.permute("b", "a"));
        assertFalse(App.permute("b", "aa"));
        assertFalse(App.permute("bb", "ab"));

    }
    public void testDup() {
        assertTrue(App.permute("aaa", "aaa"));
        assertTrue(App.permute("aab", "aba"));
        assertFalse(App.permute("aabbcc", "ababcd"));
        assertTrue(App.permute("aabbccdd", "dabcbcad"));
    }

}
