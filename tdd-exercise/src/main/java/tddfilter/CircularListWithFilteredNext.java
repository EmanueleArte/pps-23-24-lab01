package tddfilter;

import tdd.CircularList;

import java.util.Optional;
import java.util.function.Predicate;

/**
 * An extension of {@link tdd.CircularList} that provides also a method that returns the next element
 * that satisfies a given condition.
 */
public interface CircularListWithFilteredNext extends CircularList {

    /**
     * Provides the next element of the list that satisfies a given condition.
     * @param condition the condition to satisfy
     * @return the next element that satisfies a given condition, If no such element is found
     * the method should return an empty Optional
     */
    Optional<Integer> filteredNext(Predicate<Integer> condition);
}
