package ProjectV1;

public class Americano {

	private String nombre;
	private double precio = 85.00;
	
	
	
	public Americano(String nombre, double precio) {
		this.nombre = nombre;
		this.precio = precio;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public double getPrecio() {
		return precio;
	}



	public void setPrecio(double precio) {
		this.precio = precio;
	}
	

	
}
