package tdditerator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularListIterator implementation
 */
public class CircularListIteratorTest {

    private CircularListIterator circularList;

    @BeforeEach
    void beforeEach() {
        circularList = new CircularListIteratorImpl();
    }

    @Test
    public void testEmptyList() {
        assertTrue(circularList.isEmpty());
    }

}