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
        assertEquals(element, circularList.forwardIterator().next().orElse(null));
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
        assertEquals(element1, forwardIterator.next().orElse(null));
        assertEquals(element2, forwardIterator.next().orElse(null));
        assertEquals(element3, forwardIterator.next().orElse(null));
        assertTrue(forwardIterator.hasNext());
        assertEquals(element1, forwardIterator.next().orElse(null));
    }

    @Test
    public void testPreviousElement() {
        assertFalse(circularList.backwardIterator().hasNext());
        final int element1 = 1;
        final int element2 = 2;
        circularList.add(element1);
        circularList.add(element2);
        assertEquals(element2, circularList.backwardIterator().next().orElse(null));
    }

    @Test
    public void testPreviousElementCircular() {
        final int element1 = 1;
        final int element2 = 2;
        final int element3 = 3;
        circularList.add(element1);
        circularList.add(element2);
        circularList.add(element3);
        final Iterator<Optional<Integer>> backwardIterator = circularList.backwardIterator();
        assertEquals(element3, backwardIterator.next().orElse(null));
        assertEquals(element2, backwardIterator.next().orElse(null));
        assertEquals(element1, backwardIterator.next().orElse(null));
        assertTrue(backwardIterator.hasNext());
        assertEquals(element3, backwardIterator.next().orElse(null));
    }

    @Test
    public void testIterationWhileAddingElements() {
        assertFalse(circularList.forwardIterator().hasNext());
        final int element1 = 1;
        final int element2 = 2;
        final Iterator<Optional<Integer>> forwardIterator = circularList.backwardIterator();
        circularList.add(element1);
        assertTrue(forwardIterator.hasNext());
        assertEquals(element1, forwardIterator.next().orElse(null));
        circularList.add(element2);
        assertTrue(forwardIterator.hasNext());
        assertEquals(element2, forwardIterator.next().orElse(null));
    }

}