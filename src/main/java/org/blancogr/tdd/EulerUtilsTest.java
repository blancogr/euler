package org.blancogr.tdd;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class EulerUtilsTest extends TestCase {
    // newFibUpTo

    @Test
    public void testNewFibUpTo() {
        ArrayList<Long> fibs = new ArrayList<Long>(Arrays.asList(0L, 1L, 1L, 2L, 3L, 5L, 8L, 13L, 21L, 34L, 55L, 89L, 144L, 233L, 377L, 610L, 987L, 1597L, 2584L, 4181L, 6765L, 10946L, 17711L, 28657L, 46368L, 75025L, 121393L, 196418L, 317811L));
        Long bigOne = 117669030460994L ;
        assertNull(EulerUtils.newFibUbTo(-10L));
        assertEquals(Arrays.asList(1L), EulerUtils.newFibUbTo(1L));
        assertEquals(Arrays.asList(1L, 1L, 2L), EulerUtils.newFibUbTo(2L));

        assertEquals(Arrays.asList(1L, 1L, 2L, 3L, 5L, 8L), EulerUtils.newFibUbTo(8L));
        assertTrue(EulerUtils.newFibUbTo(bigOne + 1).contains(bigOne));

        // Roof number included if it is a fib
        assertTrue(EulerUtils.newFibUbTo(bigOne).contains(bigOne));
    }


    

}