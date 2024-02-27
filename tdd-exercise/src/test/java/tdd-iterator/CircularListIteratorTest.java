package tdd-iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private CircularListIterator circularList;

    @BeforeEach
    void beforeEach() {
        circularList = new CircularListImpl();
    }
}