package com.InyeccionDependencias;

public class Empleado {

	private String nombre;
	private TipoPuesto tipo;

	
	public Empleado(String nombre) {
		this.nombre = nombre;
	}

	void realizaTrabajo(){
		System.out.println(nombre);
		tipo.trabajar();
	}

	public TipoPuesto getTipo() {
		return tipo;
	}

	public void setTipo(TipoPuesto tipo) {
		this.tipo = tipo;
	}


	
}

