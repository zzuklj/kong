package meng.klj.common.algorithms.datastructures.interfaces;

/**
 * fifo
 * @param <T>
 */
public interface IQueue<T> {

    /**
     * add first
     * @param value
     * @return
     */
    boolean offer(T value);

    /**
     * remove last
     * @return
     */
    T poll();

    /**
     * get last
     * @return
     */
    T peek();

    boolean remove(T value);

    /**
     * Clear the entire queue.
     */
     void clear();

    /**
     * Does the queue contain the value.
     *
     * @param value to find in the queue.
     * @return True if the queue contains the value.
     */
     boolean contains(T value);

    /**
     * Get the size of the queue.
     *
     * @return size of the queue.
     */
     int size();

    /**
     * Validate the queue according to the invariants.
     *
     * @return True if the queue is valid.
     */
     boolean validate();

    /**
     * Get this Queue as a Java compatible Queue
     *
     * @return Java compatible Queue
     */
     java.util.Queue<T> toQueue();

    /**
     * Get this Queue as a Java compatible Collection
     *
     * @return Java compatible Collection
     */
     java.util.Collection<T> toCollection();




}
