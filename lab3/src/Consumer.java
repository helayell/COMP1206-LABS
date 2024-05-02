import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.threading.FactoryWorker;
import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.threading.NumberQueue;

public class Consumer extends FactoryWorker {
    public Consumer(int id, NumberQueue belt) {
        super("Consumer", id, belt);
    }

    @Override
    public void message(int i) {

        System.out.println("Consumer " + this.id + " picked " + i + " from the belt.");
    }

    @Override
    public int action() {
        int consumedNumber = this.belt.dequeue();
        return consumedNumber;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                int number = action();
                message(number);
            } catch (Exception e) {
                messageError();
                break;
            }
        }
    }
}
