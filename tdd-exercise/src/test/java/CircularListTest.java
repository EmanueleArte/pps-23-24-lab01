import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.CircularList;
import tdd.CircularListImpl;

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

}
