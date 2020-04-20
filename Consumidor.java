package productorConsumidor;

public class Consumidor extends Thread {
	private Buffer buffer;
	public Consumidor (Buffer buffer) {
		this.buffer=buffer;
	}
	public void run() {
		Consumidor.popElement();
		try {
				sleep(Math.random());
			}catch (InterruptedException e) { }
		}
	}

}

