package tdditerator;

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

}
