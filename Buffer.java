package productorConsumidor;

public class Buffer {
	private char contenido;					//contenido en letras del abcdario
	private boolean disponible=false;		//se inicia en falso ya que no tiene nada cargado ?
	public Buffer()  {
	}
	public synchronized char recoger() {
		while(!disponible) {				//bucle que mientras no este disponible se duermen los que entrena recoger
			try {
				wait();						//duerme al hilo
				System.out.println("hago esperar a un hilo Consumidor\n");
			}catch(InterruptedException ex) {}
		}
		System.out.println("Se libero el Consumidor\n");
		disponible=false;					//sale del bucle ya que esta disponible entonces lo vuelve a poner no disponible y despierta al hilo
		notify();
		return contenido;
	}
	
	public synchronized void poner(char valor) {
		while(disponible) {					//si esta disponible quiere decir que esta lleno por eso duerme al hilo
			try {
				wait();						//duerme	
				System.out.println("hago esperar a un hilo Productor\n");
			}catch(InterruptedException ex) {}
		}
		System.out.println("Se libero el Productor\n");
		contenido=valor;					//salio del bucle quiere decir que esta vacio por eso lo llena con el "valor"
		disponible=true;					//cambia al estado de disponible ya que puso un elemento
		notify();							//despierta al
	}
}
