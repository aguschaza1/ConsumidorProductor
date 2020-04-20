import java.util.concurrent

public Class Main{
	public static void main(String [] args){

		buffer buffer = new buffer(); 	//creo el buffer que se va a pasar como argumento

		int prodAmount = 10;			//cantidad de productores
		int consAmount = 10;			//cantidad de consumidores

		for (int i = 0; i < prodAmount; i++) {
			producer producer[i] = new producer(buffer);	//genero los productores
		}
		for (int i = 0; i < consAmount; i++) {
			consumer consumer[i] = new consumer(buffer);	//genero los consumidores
		}
		for (int i = 0;i < prodAmount ; i++) {
			producer[i].run();								//arranco los prductores
		}
		for (int i = 0; i < consAmount; i++) {
			consumer[i].run();								//arranco los consumidores
		}
	}	
}
