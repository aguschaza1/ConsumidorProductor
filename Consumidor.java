
Public class Consumidor extends Thread {
  private Buffer buffer;
  
  public Consumidor(Buffer buffer) {this.buffer = buffer;  }
  
  public Consumidor(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        for(int i = 0; i < 20; ++i) {
            char valor = this.buffer.recoger();
            System.out.println(i + " Consumidor: " + valor);

            try {
                sleep(100L);
            } catch (InterruptedException var4) {
            }
        }

    }
}
