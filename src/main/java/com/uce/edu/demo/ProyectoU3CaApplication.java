package com.uce.edu.demo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Factura;
import com.uce.edu.demo.service.IFacturaService;

@SpringBootApplication
public class ProyectoU3CaApplication implements CommandLineRunner{

	private static final Logger logger = Logger.getLogger(ProyectoU3CaApplication.class);
	
	@Autowired
	private IFacturaService facturaService;

	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3CaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//JOIN FETCH
		logger.info("JOIN FETCH");
		List<Factura> listaFacturaFetch = this.facturaService.buscarFacturaJoinFetch(15);
		listaFacturaFetch.stream().forEach(x -> logger.info("Factura: Fecha: "+x.getFecha()+" Numero: "+x.getNumero()+" Detalles: "+ x.getDetalles()));
		logger.info("\n");
		
		//WHERE
		logger.info("WHERE");
		List<Factura> listaFacturaFetch2 = this.facturaService.buscarFacturaJoinWhere(15);
		listaFacturaFetch2.stream().forEach(x -> logger.info("Factura: Fecha: "+x.getFecha()+" Numero: "+x.getNumero()));
		
		
	}

}
