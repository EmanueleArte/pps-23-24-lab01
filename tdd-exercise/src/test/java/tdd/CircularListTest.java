package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private CircularList circularList;

    @BeforeEach
    void beforeEach() {
        circularList = new CircularListImpl();
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
        final int element = 1;
        circularList.add(element);
        assertEquals(circularList.next().orElse(null), element);
    }

    @Test
    public void testNextElementCircular() {
        final int element1 = 1;
        final int element2 = 2;
        final int element3 = 3;
        circularList.add(element1);
        circularList.add(element2);
        circularList.add(element3);
        assertEquals(circularList.next().orElse(null), element1);
        assertEquals(circularList.next().orElse(null), element2);
        assertEquals(circularList.next().orElse(null), element3);
        assertEquals(circularList.next().orElse(null), element1);
    }

    @Test
    public void testPreviousElement() {
        final int element = 1;
        circularList.add(element);
        circularList.add(element + 1);
        circularList.next();
        assertEquals(circularList.previous().orElse(null), element);
    }

    @Test
    public void testPreviousElementCircular() {
        final int element1 = 1;
        final int element2 = 2;
        final int element3 = 3;
        circularList.add(element1);
        circularList.add(element2);
        circularList.add(element3);
        assertEquals(circularList.previous().orElse(null), element3);
        assertEquals(circularList.previous().orElse(null), element2);
        assertEquals(circularList.previous().orElse(null), element1);
        assertEquals(circularList.previous().orElse(null), element3);
    }

    @Test
    public void testReset() {
        final int element1 = 1;
        final int element2 = 2;
        final int element3 = 3;
        circularList.add(element1);
        circularList.add(element2);
        circularList.add(element3);
        circularList.next();
        circularList.next();
        circularList.reset();
        assertEquals(circularList.next().orElse(null), element1);
    }

}
