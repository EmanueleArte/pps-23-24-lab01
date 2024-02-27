package tdditerator;

import java.util.ArrayList;
import java.util.Iterator;
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

    @Override
    public void add(int element) {
        this.list.add(element);
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public Iterator<Integer> forwardIterator() {
        return this.list.listIterator();
    }

}
