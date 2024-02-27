package tdditerator;

import java.util.ArrayList;
import java.util.List;

public class CircularListWithIteratorImpl implements CircularListWithIterator {

    private final List<Integer> list;

    public CircularListWithIteratorImpl() {
        this.list = new ArrayList<>();
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }
}
