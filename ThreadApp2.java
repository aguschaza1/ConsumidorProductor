package productorConsumidor;

public class ThreadApp2 {
		
	public static void main(String[] args) {
		Buffer b=new Buffer(); 					//aca crea el buffer
		Productor p=new Productor(b);			//crea el prod y cons con el buffer incluido en ambos
		Consumidor c=new Consumidor(b);
										//les da star a ambos
		c.start();
	
		p.start();
		
		
		try {
			System.in.read();					//
		}catch (Exception e) {     }
	}
}
