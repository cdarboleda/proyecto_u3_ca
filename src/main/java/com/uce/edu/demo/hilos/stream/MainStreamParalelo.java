package com.uce.edu.demo.hilos.stream;

import java.util.Arrays;

import com.uce.edu.demo.hilos.paralelo.CajeroParalelo;
import com.uce.edu.demo.hilos.paralelo.PCCajeroParalelo;

public class MainStreamParalelo {

	public static void main(String[] args) {
		System.out.println("Nombre Hilo: " +Thread.currentThread().getName());
		long tiempoInicial = System.currentTimeMillis();
		CajeroParalelo cajero1 = new CajeroParalelo("Cristian", Arrays.asList("Pepito"));
		CajeroParalelo cajero2 = new CajeroParalelo("David", Arrays.asList("Pepito2"));
		CajeroParalelo cajero3 = new CajeroParalelo("Jorge", Arrays.asList("Pepito3"));
		
		CajeroParalelo cajero4 = new CajeroParalelo("Cristian", Arrays.asList("Juan"));
		CajeroParalelo cajero5 = new CajeroParalelo("David", Arrays.asList("Juan2"));
		CajeroParalelo cajero6 = new CajeroParalelo("Jorge", Arrays.asList("Juan3"));
		
		PCCajeroParalelo gestorAtencion = new PCCajeroParalelo(cajero1);
		gestorAtencion.start();
		PCCajeroParalelo gestorAtencion2 = new PCCajeroParalelo(cajero2);
		gestorAtencion2.start();
		PCCajeroParalelo gestorAtencion3 = new PCCajeroParalelo(cajero3);
		gestorAtencion3.start();
		PCCajeroParalelo gestorAtencion4 = new PCCajeroParalelo(cajero4);
		gestorAtencion4.start();
		PCCajeroParalelo gestorAtencion5 = new PCCajeroParalelo(cajero5);
		gestorAtencion5.start();
		PCCajeroParalelo gestorAtencion6 = new PCCajeroParalelo(cajero6);
		gestorAtencion6.start();
		
		
		long tiempoFinal = System.currentTimeMillis();
		
		long tiempoTranscurrido= (tiempoFinal-tiempoInicial)/1000;
		
		System.out.println(tiempoTranscurrido + " seg");

	}

}