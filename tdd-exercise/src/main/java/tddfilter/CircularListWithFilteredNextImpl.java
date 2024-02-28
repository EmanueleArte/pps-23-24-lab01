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
        int counter = 0;
        do {
            final var element = this.next();
            if (element.isPresent() && condition.test(element.get())) {
                return element;
            }
            counter++;
        } while (counter < this.size() && this.size() != 0);
        return Optional.empty();
    }
}
