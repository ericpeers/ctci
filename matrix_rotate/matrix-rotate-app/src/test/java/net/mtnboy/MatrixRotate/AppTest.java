package net.mtnboy.MatrixRotate;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Assert;
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

    //01  20
    //23  31
    public void test2 () {
        int [][] array = {{0,1}, {2,3}};
        int [][] a90 = {{2,0},{3,1}};
        Matrix matrix = new Matrix(array, 2);
        matrix.rotate90WasteRam();
        //need to use array comparator otherwise we just get a simple
        //reference comparison
        Assert.assertArrayEquals(matrix.getVals(), a90);


    }
    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
