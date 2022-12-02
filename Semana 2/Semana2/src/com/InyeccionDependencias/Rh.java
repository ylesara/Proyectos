package com.InyeccionDependencias;

public class Rh  extends TipoPuesto {

	public Rh(String funcion) {
		super(funcion);
	}

	@Override
	public void trabajar() {
		System.out.println("RH: " + funcion + "Calcula nómina");
	}
	
}