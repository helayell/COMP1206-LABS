import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.threading.UnitCounter;

public class Counter implements UnitCounter {
    private int counter = 0;

    @Override
    public synchronized void addOne() {
        counter++;
    }

    @Override
    public int getCounter() {
        return counter;
    }
}
