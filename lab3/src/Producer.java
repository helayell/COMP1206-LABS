import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.threading.FactoryWorker;
import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.threading.NumberQueue;

import java.util.Random;

public class Producer extends FactoryWorker {
    public Producer(int id, NumberQueue belt) {
        super("Producer", id, belt);
    }

    @Override
    public void message(int i) {
        // Adjusted to access fields directly or use assumed getters
        System.out.println("Producer " + this.id + " added " + i + " to the belt.");
    }

    @Override
    public int action() {
        Random random = new Random();
        int producedNumber = random.nextInt(100); // Generate a random number
        this.belt.enqueue(producedNumber); // Directly accessing 'belt' field
        return producedNumber;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                int number = action();
                message(number);
            } catch (Exception e) {
                messageError();
                break; // Exit if interrupted or if the belt is full
            }
        }
    }
}
