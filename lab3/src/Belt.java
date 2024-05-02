public class Belt extends CyclicQueue {

    public Belt(int capacity) {
        super(capacity);
    }

    @Override
    public synchronized void enqueue(int i) {

        while (size == capacity) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        super.enqueue(i);
        notifyAll();
    }

    @Override
    public synchronized int dequeue() {

        while (size == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return -1;
            }
        }

        int item = super.dequeue();
        notifyAll();
        return item;
    }
}
