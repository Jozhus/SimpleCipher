package Queue;

public class Client {
    public static void main(String[] args) {
        Queue<Integer> q = new Queue<Integer>();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println(q.toString());
        q.dequeue();
        q.dequeue();
        System.out.println(q.toString());
        q.dequeue();
        System.out.println(q.toString());
        q.dequeue();
    }
}
