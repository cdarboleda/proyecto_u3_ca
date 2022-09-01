package com.uce.edu.demo.hilos.paralelo;

public class ProcesoDataBaseParalelo extends Thread{
	
	private String nombre, cedula;
	
	public ProcesoDataBaseParalelo(String nombre, String cedula) {
		// TODO Auto-generated constructor stub
		this.cedula = cedula;
		this.nombre = nombre;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.procesoDataBase(nombre, cedula);
	}
	
	private void procesoDataBase(String nombre, String cedula) {
		long tiempoInicial = System.currentTimeMillis();
		System.out.println("Hilo: "+Thread.currentThread().getName()+ " Inicio, ------ Procesando en la base de datos al usuario: " + nombre + " de cédula " + cedula);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido= (tiempoFinal-tiempoInicial)/1000;
		System.out.println("Hilo: "+Thread.currentThread().getName()+" Fin, ------ Procesamiento finalizado en: "+tiempoTranscurrido+ " seg");
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	

}
