public class Zoo {
    public static void main(String[] args) {
        final Counter counter = new Counter();
        int expectedGuests = 0;

        int[] guestsPerGate = {100, 200, 150, 250, 300};

        Thread[] gateThreads = new Thread[guestsPerGate.length];
        for (int i = 0; i < guestsPerGate.length; i++) {
            expectedGuests += guestsPerGate[i];
            Gate gate = new Gate(counter, guestsPerGate[i]);
            gateThreads[i] = new Thread(gate);
            gateThreads[i].start();
        }

        // Wait for all gate threads to finish
        for (Thread gateThread : gateThreads) {
            try {
                gateThread.join();
            } catch (InterruptedException e) {
                System.err.println("A gate thread was interrupted.");
            }
        }

        // Print the expected and actual number of guests
        System.out.println("Expected guests: " + expectedGuests);
        System.out.println("Actual guests counted: " + counter.getCounter());

        // Check if the numbers differ
        if (expectedGuests != counter.getCounter()) {
            System.out.println("expected guests are not counted accurately!");
        } else {
            System.out.println("All guests have been counted accurately.");
        }
    }
}
