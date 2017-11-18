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
        //matrix.rotate90WasteRam();
        matrix.rotate90InPlace();
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
        //matrix.rotate90WasteRam();
        matrix.rotate90InPlace();
        //need to use array comparator otherwise we just get a simple
        //reference comparison
        Assert.assertArrayEquals(matrix.getVals(), a90);

    }

    public void test4() {
        int[][] array = {{0, 1, 2, 3}, {4, 5, 6, 7}, {8, 9, 10, 11}, {12, 13, 14, 15}};
        int[][] a90 = {{12, 8, 4, 0}, {13, 9, 5, 1}, {14, 10, 6, 2}, {15, 11, 7, 3}};
        Matrix matrix = new Matrix(array, 4);
        //matrix.rotate90WasteRam();
        matrix.rotate90InPlace();
        //need to use array comparator otherwise we just get a simple
        //reference comparison
        Assert.assertArrayEquals(matrix.getVals(), a90);
    }

    public void test5() {
        int [][] array = {
                {0, 1, 2, 3, 4},
                {5, 6, 7, 8, 9},
                {10, 11, 12, 13, 14},
                {15, 16, 17, 18, 19},
                {20, 21, 22, 23, 24}
        };
        int [][] a90 = {
                {20, 15, 10, 5, 0},
                {21,16,11,6,1},
                {22,17,12,7,2},
                {23,18,13,8,3},
                {24,19,14,9,4}
        };
        Matrix matrix = new Matrix(array, 5);
        //matrix.rotate90WasteRam();
        matrix.rotate90InPlace();
        //need to use array comparator otherwise we just get a simple
        //reference comparison
        Assert.assertArrayEquals(matrix.getVals(), a90);
    }
}


