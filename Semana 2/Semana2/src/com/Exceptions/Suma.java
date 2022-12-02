package com.Exceptions;

public class Suma {

	public static void main(String[] args) {


		Suma e = new Suma();		
		
		try {
			
		    int x = 20;
		    int y = 0;
			int res = (x/y);
			System.out.println(res);
		}
		
		catch(ArithmeticException a) {
			e.printStackTrace();
			System.out.println("No se puede ejecutar");
		
		}
		finally {
			if (e != null) {
				try {
					e.close();
				} catch (Exception a) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("Programa continua...");
	}



	private void printStackTrace() {
		
	}

	private void close() throws Exception {
		System.out.println("La suma falló");
	}

	@Override
	public String toString() {
		return "Suma []";

	}
	
	}


