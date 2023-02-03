
public class Programa {

	public static final int NUM_CLIENTES = 5;
		
	public static void main(String[] args) {
	
		// Crea los clientes
		for(int i =0; i < NUM_CLIENTES; i++) {
			new Cliente();
		}
		
	}

}
