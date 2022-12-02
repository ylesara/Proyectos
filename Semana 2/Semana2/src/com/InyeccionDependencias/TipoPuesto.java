package com.InyeccionDependencias;

public abstract class TipoPuesto {
	
	String funcion;
	
	public TipoPuesto(String funcion) {
		this.funcion = funcion;
	}
	
	abstract void trabajar();

}
