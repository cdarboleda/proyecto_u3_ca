package com.uce.edu.demo.hilos.tradicional;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		long tiempoInicial = System.currentTimeMillis();
		Cajero cajero1 = new Cajero("Cristian", Arrays.asList("Pepito", "Juan", "Daniel", "Pedro"));
		Cajero cajero2 = new Cajero("David", Arrays.asList("Pepito2", "Juan2", "Daniel2"));
		Cajero cajero3 = new Cajero("Jorge", Arrays.asList("Pepito3", "Juan3"));
		
		PCCajero gestorAtencion = new PCCajero();
		gestorAtencion.procesar(cajero1);
		gestorAtencion.procesar(cajero2);
		gestorAtencion.procesar(cajero3);
		long tiempoFinal = System.currentTimeMillis();
		
		long tiempoTranscurrido= (tiempoFinal-tiempoInicial)/1000;
		
		System.out.println(tiempoTranscurrido + " seg");
	}
}
