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
        int [][] array = {{0, 1}, {2,3}}; //note that last element is 0th in init.
        int [][] a90 = {{2,0},{3,1}};
        Matrix matrix = new Matrix(array, 2);
        matrix.rotate90WasteRam();
        //need to use array comparator otherwise we just get a simple
        //reference comparison
        Assert.assertArrayEquals(matrix.getVals(), a90);

    }

    //012  630
    //345  741
    //678  852
    public void test3 () {
        int [][] array = {{0,1,2},{3,4,5},{6,7,8}};
        int [][] a90 = {{6,3,0}, {7,4,1}, {8,5,2}};
        Matrix matrix = new Matrix(array, 3);
        matrix.rotate90WasteRam();
        //need to use array comparator otherwise we just get a simple
        //reference comparison
        Assert.assertArrayEquals(matrix.getVals(), a90);

    }

    public void test4() {
        int[][] array = {{0, 1, 2, 3}, {4, 5, 6, 7}, {8, 9, 10, 11}, {12, 13, 14, 15}};
        int[][] a90 = {{12, 8, 4, 0}, {13, 9, 5, 1}, {14, 10, 6, 2}, {15, 11, 7, 3}};
        Matrix matrix = new Matrix(array, 4);
        matrix.rotate90WasteRam();
        //need to use array comparator otherwise we just get a simple
        //reference comparison
        Assert.assertArrayEquals(matrix.getVals(), a90);
    }
}


