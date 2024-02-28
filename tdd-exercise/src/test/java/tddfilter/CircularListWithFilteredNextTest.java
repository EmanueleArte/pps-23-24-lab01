package tddfilter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularListWithFilteredNext implementation
 */
public class CircularListWithFilteredNextTest {

    private CircularListWithFilteredNext circularList;

    @BeforeEach
    void beforeEach() {
        circularList = new CircularListWithFilteredNextImpl();
    }

    @Test
    public void testNextFilteredElementEmptyList() {
        assertNull(circularList.filteredNext(i -> i > 0).orElse(null));
    }

    @Test
    public void testNextFilteredElement() {
        final int element1 = 1;
        final int element2 = 2;
        final int element3 = 3;
        circularList.add(element1);
        circularList.add(element2);
        circularList.add(element3);
        assertNull(circularList.filteredNext(i -> i > 5).orElse(null));
        assertEquals(element3, circularList.filteredNext(i -> i > 2).orElse(null));
    }

    @Test
    public void testNextFilteredElementCircular() {
        final int element1 = 1;
        final int element2 = 2;
        final int element3 = 3;
        circularList.add(element1);
        circularList.add(element2);
        circularList.add(element3);
        circularList.next();
        assertNull(circularList.filteredNext(i -> i > 5).orElse(null));
        assertEquals(element1, circularList.filteredNext(i -> i == element1).orElse(null));
    }

}
