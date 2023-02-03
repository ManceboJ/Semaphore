import java.util.Random;

public class Cliente extends Thread {
	
	private static int clienteCount = 0;
	private int idCliente;
	
	public Cliente() {
		idCliente = ++clienteCount;
		start();
	}
	
	@Override
	public void run() {
		while(true) {
			
			// calcula un número aleatorio de unidades a reservar
			Random rdmNum = new Random();
			int udReservadas = rdmNum.nextInt(Buffer.getuIniciales() -1 + 1) + 1; // reserva entre [uIniciales y 1]
			
			// Informa si no hay recursos suficiente                     
			if(udReservadas > Buffer.getsUnidades().availablePermits())
                       System.out.println("Cliente " + idCliente + " esperando a que haya " + 
                    		   					udReservadas + " unidades derecursos disponibles");
        
			// solicita reservar al semaforo las unidades indicadas en udReservadas
			try {
				Buffer.getsUnidades().acquire(udReservadas);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
					
			System.out.println("Cliente " + idCliente + " ha reservado " + udReservadas + " unidades del recursos");
			
			// el hilo espera un tiempo aleatorio que dura la reserva
			int sleepTime = rdmNum.nextInt(1000 -500 + 1) + 500; // Rango(max - min + 1) + min;
			try {
				sleep(sleepTime);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			
			// Solicita devolver las unidades reservadas (udReservadas) al semáforo
			Buffer.getsUnidades().release(udReservadas);

            System.out.println("Cliente " + idCliente + " ha liberado " + udReservadas + " unidades del recursos");
            
			// el hilo espera un tiempo aleatorio hasta solicitar una nueva reserva
			sleepTime = rdmNum.nextInt(1000 -500 + 1) + 500; // Rango(max - min + 1) + min;
			try {
				sleep(sleepTime);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}	
		}			
	}		
}
