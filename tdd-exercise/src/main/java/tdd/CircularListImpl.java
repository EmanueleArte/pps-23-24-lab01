package tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Implementation of {@link CircularList}.
 */
public class CircularListImpl implements CircularList {

    private int currentIndex = 0;
    private final List<Integer> list;

    public CircularListImpl() {
        this.list = new ArrayList<>();
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
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        if (this.list.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(this.list.get(this.currentIndex++ % this.list.size()));
    }

    @Override
    public Optional<Integer> previous() {
        if (this.list.isEmpty()) {
            return Optional.empty();
        }
        this.currentIndex = --this.currentIndex < 0 ? this.list.size() - 1 : this.currentIndex;
        return Optional.of(this.list.get(this.currentIndex));
    }

    @Override
    public void reset() {
        this.currentIndex = 0;
    }
}
