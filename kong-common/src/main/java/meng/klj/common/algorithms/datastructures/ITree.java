package meng.klj.common.algorithms.datastructures;

public interface ITree<T> {

    int size();

    boolean add(T value);

    T remove(T value);

    void clear();

    boolean contains(T value);

    boolean validate(T value);
}
