package tddfilter;

import jdk.jshell.spi.ExecutionControl;
import tdd.CircularListImpl;

import java.util.Optional;
import java.util.function.Predicate;

/**
 * Implementation of {@link CircularListWithFilteredNext} and also an extension of
 * {@link CircularListImpl}.
 */
public class CircularListWithFilteredNextImpl extends CircularListImpl implements CircularListWithFilteredNext {

    @Override
    public Optional<Integer> filteredNext(Predicate<Integer> condition) {
        if (this.size() == 0) {
            return Optional.empty();
        }
        return null;
    }
}
