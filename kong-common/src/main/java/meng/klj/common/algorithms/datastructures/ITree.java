package meng.klj.common.algorithms.datastructures;

import java.util.Collection;

public interface ITree<T> {

    int size();

    boolean add(T value);

    T remove(T value);

    void clear();

    boolean contains(T value);

    boolean validate(T value);

    Collection<T> toCollection();
}
