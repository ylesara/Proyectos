package com.LambdasV0;

import java.util.*;

public class Principal {

	public static void main(String[] args) {

		List<Utiles> ListaUtiles = new ArrayList<>();
		ListaUtiles.add(new Utiles("Cuaderno", 18.00));
		ListaUtiles.add(new Utiles("Lápiz", 3.00));
		ListaUtiles.add(new Utiles("Resistol", 8.50));
		ListaUtiles.add(new Utiles("Sacapuntas", 4.50));
		ListaUtiles.add(new Utiles("Tijeras", 25.00));
		
		
		System.out.println("PRODUCTO MENOR DE 20 PESOS");
		
		mostrarUtiles(ListaUtiles, uti -> uti.getPrecio()<20.00); 
		
	}
	
	static void mostrarUtiles(List<Utiles> lista, 
			Predicado p ) {

		for(Utiles u :lista) {
			
			if (p.prueba(u)) 
			System.out.println(u);
			
		}
	}
}
