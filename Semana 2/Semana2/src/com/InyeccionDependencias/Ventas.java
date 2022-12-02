package com.InyeccionDependencias;

public class Ventas extends TipoPuesto {
	

	public Ventas(String funcion) {
		super(funcion);
	}

	@Override
	public void trabajar() {
		System.out.println("Ventas: " + funcion + "Vende casas");
	}
}
