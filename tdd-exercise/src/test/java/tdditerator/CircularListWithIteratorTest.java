package tdditerator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularListIterator implementation
 */
public class CircularListWithIteratorTest {

    private CircularListWithIterator circularList;

    @BeforeEach
    void beforeEach() {
        circularList = new CircularListWithIteratorImpl();
    }

    @Test
    public void testEmptyList() {
        assertTrue(circularList.isEmpty());
    }

    @Test
    public void testAddElement() {
        final int element = 1;
        circularList.add(element);
        assertFalse(circularList.isEmpty());
    }

    @Test
    public void testListSize() {
        assertEquals(circularList.size(), 0);
        final int element = 1;
        circularList.add(element);
        circularList.add(element);
        assertEquals(circularList.size(), 2);
    }

    @Test
    public void testNextElement() {
        assertFalse(circularList.forwardIterator().hasNext());
        final int element = 1;
        circularList.add(element);
        assertTrue(circularList.forwardIterator().hasNext());
        assertEquals(circularList.forwardIterator().next().orElse(null), element);
    }

    @Test
    public void testNextElementCircular() {
        final int element1 = 1;
        final int element2 = 2;
        final int element3 = 3;
        circularList.add(element1);
        circularList.add(element2);
        circularList.add(element3);
        final Iterator<Optional<Integer>> forwardIterator = circularList.forwardIterator();
        assertEquals(forwardIterator.next().orElse(null), element1);
        assertEquals(forwardIterator.next().orElse(null), element2);
        assertEquals(forwardIterator.next().orElse(null), element3);
        assertTrue(forwardIterator.hasNext());
        assertEquals(forwardIterator.next().orElse(null), element1);
    }

    @Test
    public void testPreviousElement() {
        final int element1 = 1;
        final int element2 = 2;
        circularList.add(element1);
        circularList.add(element2);
        assertEquals(circularList.backwardIterator().next().orElse(null), element2);
    }

}