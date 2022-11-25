package ProjectV1;

public class Cafeteria {

	public static void main(String[] args) {
		
		
		Ventas din = new Ventas ("Kenia", 200.00);
		
		String res = din.comprar();
		
		System.out.println(res);
		
	}

}
