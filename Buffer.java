
import java.util.concurrent.Semaphore;

public class Buffer {

	private static final int uIniciales = 50;
	private static Semaphore sUnidades  = new Semaphore(uIniciales,true);
	


	public static int getuIniciales() {
		return uIniciales;
	}
	
	public static Semaphore getsUnidades() {
		return sUnidades ;
	}
	
}
