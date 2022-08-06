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
		//INNER
		logger.info("INNER JOIN");
		List<Factura> listaFactura = this.facturaService.buscarFacturaInnerJoin();
		listaFactura.stream().forEach(x -> logger.info("Factura: Fecha: "+ x.getFecha()+" Numero: "+x.getNumero()));
		
		List<Factura> listaFactura2 = this.facturaService.buscarFacturaInnerJoin(15);
		listaFactura2.stream().forEach(x -> logger.info("Factura: Fecha: "+ x.getFecha()+" Numero: "+x.getNumero()));
		
		//LEFT
		logger.info("LEFT JOIN");
		List<Factura> listaFacturaLeft = this.facturaService.buscarFacturaOuterLeftJoin();
		listaFacturaLeft.stream().forEach(x -> logger.info("Factura: Fecha: "+ x.getFecha()+" Numero: "+x.getNumero()));
		List<Factura> listaFacturaLeft2 = this.facturaService.buscarFacturaOuterLeftJoin(15);
		listaFacturaLeft2.stream().forEach(x -> logger.info("Factura: Fecha: "+ x.getFecha()+" Numero: "+x.getNumero()));;
		
		//RIGHT
		logger.info("RIGHT JOIN");
		List<Factura> listaFacturaRight = this.facturaService.buscarFacturaOuterRightJoin(15);
		listaFacturaRight.stream().forEach(x -> logger.info("Factura: Fecha: "+ x.getFecha()+" Numero: "+x.getNumero()));
	
	}

}
