package ProjectV2;

public class Ventas implements Cafe {
	
	private String nombreCliente;
	private double dinero;
	

	    public Ventas(String nombreCliente, double dinero) {
		this.nombreCliente = nombreCliente;
		this.dinero = dinero;
	}
	    
	    @Override

		public String comprar()	{
		if (dinero >= 85.00 && dinero <= 95.00)
			
			return (nombreCliente + ", te alcanza para el café Americano y te sobra " + (dinero - 85.00));
			
	
		else if (dinero >= 95.00 && dinero < 120.00) 
				
				return (nombreCliente + ", te alcanza para el café Latte y te sobra " + (dinero - 95.00));
				
	    
		else if (dinero >= 120.00) 
					
					return (nombreCliente + ", te alcanza para el café Toffee y te sobra " + (dinero - 120.00));
					
					else
						
					return ("Lo siento, no te alcanza para nada");
			
			    }
	   

	public String getNombreCliente() {
			return nombreCliente;
		}

		public void setNombreCliente(String nombreCliente) {
			this.nombreCliente = nombreCliente;
		}

	public double getDinero() {
		return dinero;
	}


	public void setDinero(double dinero) {
		this.dinero = dinero;
	}
	
	

}
