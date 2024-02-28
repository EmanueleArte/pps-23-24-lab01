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
        assertEquals(0, circularList.size());
        final int element = 1;
        circularList.add(element);
        circularList.add(element);
        assertEquals(2, circularList.size());
    }

    @Test
    public void testNextElement() {
        final int element = 1;
        circularList.add(element);
        assertEquals(element, circularList.next().orElse(null));
    }

    @Test
    public void testNextElementCircular() {
        final int element1 = 1;
        final int element2 = 2;
        final int element3 = 3;
        circularList.add(element1);
        circularList.add(element2);
        circularList.add(element3);
        assertEquals(element1, circularList.next().orElse(null));
        assertEquals(element2, circularList.next().orElse(null));
        assertEquals(element3, circularList.next().orElse(null));
        assertEquals(element1, circularList.next().orElse(null));
    }

    @Test
    public void testPreviousElement() {
        final int element = 1;
        circularList.add(element);
        circularList.add(element + 1);
        circularList.next();
        assertEquals(element, circularList.previous().orElse(null));
    }

    @Test
    public void testPreviousElementCircular() {
        final int element1 = 1;
        final int element2 = 2;
        final int element3 = 3;
        circularList.add(element1);
        circularList.add(element2);
        circularList.add(element3);
        assertEquals(element3, circularList.previous().orElse(null));
        assertEquals(element2, circularList.previous().orElse(null));
        assertEquals(element1, circularList.previous().orElse(null));
        assertEquals(element3, circularList.previous().orElse(null));
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
        assertEquals(element1, circularList.next().orElse(null));
    }

}
