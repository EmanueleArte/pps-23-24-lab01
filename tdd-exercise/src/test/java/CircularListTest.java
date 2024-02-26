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

}
