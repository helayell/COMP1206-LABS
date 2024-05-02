public class Gate  implements Runnable{
    private Counter counter;
    private int numberOfGuests;

    public Gate(Counter counter, int numberOfGuests) {
        this.counter = counter;
        this.numberOfGuests = numberOfGuests;
    }
    @Override
    public void run() {
        for (int i = 0; i<numberOfGuests; i++){
            counter.addOne();
        }

    }
}
