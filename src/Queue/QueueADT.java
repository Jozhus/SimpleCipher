package Queue;

public interface QueueADT<T> {

    public void enqueue(T item);

    public T dequeue();

    public T first();

    public boolean isEmpty();

    public int size();

    public String toString();
}
