package com.uce.edu.demo.hilos.paralelo;

public class MainParalelo {

	public static void main(String[] args) {
		
		long tiempoInicial = System.currentTimeMillis();
		ProcesoDataBaseParalelo proceso1 = new ProcesoDataBaseParalelo("Cristian", "1751146786");
		ProcesoDataBaseParalelo proceso2 = new ProcesoDataBaseParalelo("David", "1351478965");
		ProcesoDataBaseParalelo proceso3 = new ProcesoDataBaseParalelo("Elena", "1785479632");
		ProcesoDataBaseParalelo proceso4 = new ProcesoDataBaseParalelo("Carlos", "1852147863");
		ProcesoDataBaseParalelo proceso5 = new ProcesoDataBaseParalelo("Esteban", "1725693791");
		
		proceso1.start();
		proceso2.start();
		proceso3.start();
		proceso4.start();
		proceso5.start();
			
		long tiempoFinal = System.currentTimeMillis();
		
		long tiempoTranscurrido= (tiempoFinal-tiempoInicial)/1000;
		
		System.out.println(tiempoTranscurrido + " seg");

	}

}
