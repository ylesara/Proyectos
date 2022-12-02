package com.LambdasV1;

public class Utiles {
	
	private String nombre;
	private double precio;
    private int cantidad;
	


	public Utiles(String nombre, double precio, int cantidad) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
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
	
	
	
	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	@Override
	
	public String toString()
	{
		return "Utiles [Nombre=" + nombre + ", Precio " + precio + ", Cantidad " + cantidad + "]";
	
				
	}
}
