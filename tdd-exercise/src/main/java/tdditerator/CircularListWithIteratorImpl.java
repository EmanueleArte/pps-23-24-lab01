package tdditerator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

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
    public Iterator<Optional<Integer>> forwardIterator() {
        return new Iterator<>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                this.currentIndex = circularizeIndex(this.currentIndex);
                return this.currentIndex < size();
            }

            @Override
            public Optional<Integer> next() {
                this.currentIndex = circularizeIndex(this.currentIndex);
                return Optional.of(list.get(this.currentIndex++));
            }

            private int circularizeIndex(int index) {
                return size() == 0 ? 0 : index % size();
            }
        };
    }

    @Override
    public Iterator<Optional<Integer>> backwardIterator() {
        return new Iterator<>() {

            private int currentIndex = size();

            @Override
            public boolean hasNext() {
                return this.currentIndex >= 0 && size() > 0;
            }

            @Override
            public Optional<Integer> next() {
                this.currentIndex = circularizeIndex(this.currentIndex);
                return Optional.of(list.get(this.currentIndex));
            }

            private int circularizeIndex(int index) {
                return --index < 0 ? size() - 1 : index;
            }
        };
    }


}
