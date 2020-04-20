package productorConsumidor;

public class Consumidor extends Thread {
	private Buffer buffer;
	public Consumidor (Buffer buffer) {
		this.buffer=buffer;
	}
	public void run() {
		int valor;
		for(int i=0; i<10; i++) {
			valor=buffer.recoger();
			System.out.println(i+" Consumidor: "+valor);
			try {
				sleep(100);
			}catch (InterruptedException e) { }
		}
	}

}

