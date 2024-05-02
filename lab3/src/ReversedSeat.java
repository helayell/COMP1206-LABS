import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.threading.Seat;
import java.util.concurrent.locks.ReentrantLock;

public class ReversedSeat implements Seat {
    ReentrantLock fork1, fork2;

    @Override
    public void assignForks(ReentrantLock leftFork, ReentrantLock rightFork) {
        fork1 = leftFork;
        fork2 = rightFork;
    }

    @Override
    public void askFork1() {
        fork2.lock();
    }

    @Override
    public void askFork2() {
        fork1.lock();
    }
}
