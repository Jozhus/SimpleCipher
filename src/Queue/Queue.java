package Queue;

public class Queue<T> implements QueueADT<T> {
    private Node head, rear;
    private int count;

    public Queue() {
        this.head = this.rear = null;
        this.count = 0;
    }

    @Override
    public void enqueue(T item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            this.head = this.rear = newNode;
        }
        else {
            this.rear.setNext(newNode);
            this.rear = newNode;
        }

        count++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) throw new RuntimeException("The queue is empty!");

        T result = (T) this.head.getData();
        this.head = this.head.getNext();
        count--;

        return result;
    }

    @Override
    public T first() {
        if (isEmpty()) {
            throw new RuntimeException("The stack is empty!");
        }

        return (T) this.head.getData();
    }

    @Override
    public boolean isEmpty() {
        return (this.head == null);
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public String toString() {
        String result = "";

        for (int i = 0; i < count; i++) {
            T popped = dequeue();
            result += popped + " ";
            enqueue(popped);
        }

        return result;
    }
}
