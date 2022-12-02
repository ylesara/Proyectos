package com.InyeccionDependencias;

public class Mkt extends TipoPuesto {
	

	public Mkt(String funcion) {
		super(funcion);
	}

	@Override
	public void trabajar() {
		System.out.println("MKT: " + funcion + "Publica en red social");
	}
}