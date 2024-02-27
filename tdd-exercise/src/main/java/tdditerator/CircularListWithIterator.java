package tdditerator;

import java.util.Iterator;
import java.util.Optional;

/**
 * Represents a list of integers, that provides bidirectional and circular iterators.
 * Example: with a list like {1,2,3}, the call of forwardIterator() returns an iterator that goes
 * forward through the list, and the call of backwardIterator() returns an iterator that goes
 * backward through the list.
 */
public interface CircularListWithIterator {

    /**
     * Checks if the list is empty
     * @return true if the list is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Adds an element to the list, namely, after the last inserted one.
     * @param element the element to be added to the list
     */
    void add(final int element);

    /**
     * Provides the current size of the list
     * @return the size of the list
     */
    int size();

    /**
     * Provides an iterator that goes forward through the list.
     * @return an iterator that goes forward through the list
     */
    Iterator<Optional<Integer>> forwardIterator();

}
