package com.InyeccionDependencias;

public class Jefe {

	static TipoPuesto rh = new Rh("Lunes ");
	static TipoPuesto ve = new Ventas("Martes ");
	static TipoPuesto mk = new Mkt("Miercoles ");
	
	static void asignaRol(Empleado e, diasSemana ds){
		
		switch(ds) {
		
		case LUNES: e.setTipo(rh);
			break;
		case MARTES: e.setTipo(ve);
			break;
		default: e.setTipo(mk);
			
		
		}
		
	}
	
}
