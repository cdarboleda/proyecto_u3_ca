package com.uce.edu.demo.hilos.tradicional;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Nombre Hilo: " +Thread.currentThread().getName());
		long tiempoInicial = System.currentTimeMillis();
		Cajero cajero1 = new Cajero("Cristian", Arrays.asList("Pepito", "Juan"));
		Cajero cajero2 = new Cajero("David", Arrays.asList("Pepito2", "Juan2"));
		Cajero cajero3 = new Cajero("Jorge", Arrays.asList("Pepito3", "Juan3"));
		
		PCCajero gestorAtencion = new PCCajero();
		gestorAtencion.procesar(cajero1);
		PCCajero gestorAtencion2 = new PCCajero();
		gestorAtencion.procesar(cajero2);
		PCCajero gestorAtencion3 = new PCCajero();
		gestorAtencion.procesar(cajero3);
		long tiempoFinal = System.currentTimeMillis();
		
		long tiempoTranscurrido= (tiempoFinal-tiempoInicial)/1000;
		
		System.out.println(tiempoTranscurrido + " seg");
	}
}
