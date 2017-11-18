package net.mtnboy.PrioQueue;

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

    public void testEmpty() {
        PriorityQueue<Character> pq = new PriorityQueue<Character>(10);
        assertNull(pq.getNext());
        assertTrue(pq.Insert(PriorityQueue.Priority.LOW, 'b'));
        assertEquals('b', pq.getNext().charValue());
        assertNull(pq.getNext());
    }
    public void testEnd() {
        PriorityQueue<Character> pq = new PriorityQueue<Character>(10);
        pq.Insert(PriorityQueue.Priority.HIGH, 'y');
        pq.Insert(PriorityQueue.Priority.HIGH, 'z');
        assertEquals('y', pq.getNext().charValue());
        assertEquals('z', pq.getNext().charValue());
    }
    public void testFront() {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(10);
        pq.Insert(PriorityQueue.Priority.LOW, 1);
        pq.Insert(PriorityQueue.Priority.MEDIUM, 100);
        pq.Insert(PriorityQueue.Priority.HIGH, 1000);
        assertEquals(1000, pq.getNext().intValue());
        assertEquals(100, pq.getNext().intValue());
        assertEquals(1, pq.getNext().intValue());
    }
    public void testDup() {
        PriorityQueue<Character> pq = new PriorityQueue<Character>(10);
        pq.Insert(PriorityQueue.Priority.LOW, 'f');
        pq.Insert(PriorityQueue.Priority.MEDIUM, 'f');
        pq.Insert(PriorityQueue.Priority.MEDIUM, 'f');
        pq.Insert(PriorityQueue.Priority.MEDIUM, 'f');
        assertEquals('f', pq.getNext().charValue());
        assertEquals('f', pq.getNext().charValue());
        assertEquals('f', pq.getNext().charValue());
        assertEquals('f', pq.getNext().charValue());
    }
    public void testFull() {
        PriorityQueue<Character> pq = new PriorityQueue<Character>(3);
        pq.Insert(PriorityQueue.Priority.MEDIUM, 'a');
        pq.Insert(PriorityQueue.Priority.MEDIUM, 'b');
        pq.Insert(PriorityQueue.Priority.MEDIUM, 'c');
        assertFalse(pq.Insert(PriorityQueue.Priority.MEDIUM, 'd'));
        assertEquals('a', pq.getNext().charValue());
        assertEquals('b', pq.getNext().charValue());
        assertEquals('c', pq.getNext().charValue());
        assertNull(pq.getNext());
    }

}
