public class CyclicQueueTest {
    public static void main(String[] args) {
        // Create a queue with capacity of 5
        CyclicQueue queue = new CyclicQueue(5);

        // Enqueue elements
        System.out.println("Enqueuing 5 elements.");
        for (int i = 1; i <= 5; i++) {
            queue.enqueue(i);
            System.out.println("Enqueued: " + i);
        }

        // Try to enqueue one more element to see if exception is thrown
        try {
            System.out.println("Attempting to enqueue beyond capacity.");
            queue.enqueue(6);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        // Dequeue and print elements
        System.out.println("\nDequeuing all elements.");
        while (!queue.isEmpty()) {
            System.out.println("Dequeued: " + queue.dequeue());
        }

        // Check if the queue is empty
        System.out.println("\nIs the queue empty? " + queue.isEmpty());

        // Enqueue elements again to test wrapping
        System.out.println("\nEnqueuing 3 elements after wrapping.");
        for (int i = 6; i <= 8; i++) {
            queue.enqueue(i);
            System.out.println("Enqueued: " + i);
        }
    }
}
