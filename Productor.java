package productorConsumidor;

public class Productor extends Thread {
    private Buffer buffer;
    private final String letras = "abcdefghijklmnopqrstuvxyz";

    public Productor(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        for(int i = 0; i < 30; ++i) {
            char c = "abcdefghijklmnopqrstuvxyz".charAt((int)(Math.random() * (double)"abcdefghijklmnopqrstuvxyz".length()));
            this.buffer.poner(c);
            System.out.println(i + " Productor: " + c);

            try {
                sleep(400L);
            } catch (InterruptedException var4) {
            }
        }

    }
}
