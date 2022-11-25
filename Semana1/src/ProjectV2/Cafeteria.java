package ProjectV2;

import java.util.*;

public class Cafeteria {

	public static void main(String[] args) {
		
		List<Cafe>tipoCafe = getCoffee();
		
		for(Cafe caf:tipoCafe) {
			
			System.out.println(caf.comprar());
			
		}
		}
	
	static List<Cafe> getCoffee() {
		
		return List.of(
				
				new Ventas ("Kenia", 120.00));
		
	
	
		
	}

}
