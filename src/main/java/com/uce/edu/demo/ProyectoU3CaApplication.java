package com.uce.edu.demo;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.service.IGestorComprasService;

@SpringBootApplication
public class ProyectoU3CaApplication implements CommandLineRunner{

	private static final Logger logger = Logger.getLogger(ProyectoU3CaApplication.class);
	
	@Autowired
	private IGestorComprasService gestorComprasService;	
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3CaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//EN la base de datos ya tenemos 3 productos ingresados y un cliente en especifico
		List<String> listaNombres = Arrays.asList("Yogurt", "Chocolate Nestle", "Cerveza");
		this.gestorComprasService.registrarCompraProducto("1751146786", "F008", listaNombres);
	}

}
