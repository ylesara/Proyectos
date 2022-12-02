package com.LambdasV1;

import java.util.*;
import java.util.function.Predicate;

public class Principal implements AutoCloseable {

	public static void main(String[] args) throws Exception {

		List<Utiles> ListaUtiles = new ArrayList<>();
		ListaUtiles.add(new Utiles("Cuaderno", 18.00, 2));
		ListaUtiles.add(new Utiles("Lápiz", 3.00, 10));
		ListaUtiles.add(new Utiles("Resistol", 8.50, 8));
		ListaUtiles.add(new Utiles("Sacapuntas", 4.50, 20));
		ListaUtiles.add(new Utiles("Tijeras", 25.00, 3));
		
		
		System.out.println("PRODUCTOS MENOR DE 20 PESOS");
		
		try {
			Thread.sleep(1000);
			mostrarUtiles(ListaUtiles, uti -> uti.getPrecio()<20.00); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
		System.out.println("PRODUCTO MAS CARO");
		
		try {
			Thread.sleep(1000);
			ListaUtiles.removeIf(r -> r.getPrecio()<25.00);
			ListaUtiles.forEach(System.out::println);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("PRODUCTOS AGOTADOS");
		
		
		try {
			Thread.sleep(1000);
			mostrarUtiles(ListaUtiles, uti -> uti.getCantidad()==0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		finally {
			
            System.out.println("Error, no hay productos agotados");
 
        }
		
		
	}
	
	static void mostrarUtiles(List<Utiles> lista, 
			Predicate<Utiles> t ) {

		for(Utiles u :lista) {
			
			if (t.test(u)) 
			System.out.println(u);
			
		}
	}

	@Override
	public void close() throws Exception {
		
	}
}
