package tddfilter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.CircularList;
import tdd.CircularListImpl;

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

}
