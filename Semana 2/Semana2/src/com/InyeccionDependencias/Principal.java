package com.InyeccionDependencias;

public class Principal {

	public static void main(String[] args) {

		
		Empleado e1 = new Empleado("Jonathan");
		
		Jefe.asignaRol(e1,diasSemana.LUNES);
		
		e1.realizaTrabajo();
		
		Empleado e2 = new Empleado ("Araceli");
		
		Jefe.asignaRol(e2,diasSemana.MARTES);
		
		e2.realizaTrabajo();
			
		Empleado e3 = new Empleado ("Kim");
		
		Jefe.asignaRol(e3,diasSemana.MIERCOLES);
		
		e3.realizaTrabajo();
		
		
		
	}

}
