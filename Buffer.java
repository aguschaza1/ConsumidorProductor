import java.util.Stack;
import java.util.concurrent.Semaphore;

public class Buffer {

    private Stack content;

    private Semaphore mutex = new Semaphore(1, true);
    private Semaphore hayData = new Semaphore(0, true);
    private Semaphore haySpace = new Semaphore(25, true);

    public Buffer() {
        content = new Stack();
    }

    public char pull() {
        try {
            hayData.acquire();
            mutex.acquire();
            char x = (char) content.pop();
            System.out.println("Consumidor toma:" + x + "\n");


            System.out.println("Se libero el Consumidor\n");
            haySpace.release();
            mutex.release();
        } catch (InterruptedException e) {
            e.printStackTrace();

        }

        public void put(char value) {
            haySpace.tryAcquire();
            try {
                mutex.acquire();

                content.push(value);
                System.out.println("Productor ingresa:");
                System.out.println(value);
                System.out.println("\n");

                System.out.println("Se libero el Productor\n");
                hayData.release();
                mutex.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
