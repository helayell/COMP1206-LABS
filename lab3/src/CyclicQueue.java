import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.threading.NumberQueue;

public class CyclicQueue implements NumberQueue {

  private int[] queue;
  private int head;
  private int tail;
  public int size;
  public int capacity;

  public CyclicQueue(int capacity) {
    this.capacity = capacity;
    this.queue = new int[capacity];
    this.head = 0;
    this.size = 0;
    this.tail = 0;
  }

  @Override
  public void enqueue(int i) {
    if (size == capacity) {
      throw new IndexOutOfBoundsException("Queue is full");
    }
    queue[tail] = i;
    tail = (tail + 1) % capacity;
    size++;
  }

  @Override
  public int dequeue() {
    if (size == 0) {
      throw new IndexOutOfBoundsException("Queue is empty");
    }
    int item = queue[head];
    head = (head + 1) % capacity;
    size--;
      return item;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }
}
