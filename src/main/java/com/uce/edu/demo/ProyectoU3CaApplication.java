package com.uce.edu.demo;

import java.math.BigDecimal;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.service.ITransferenciaService;

@SpringBootApplication
public class ProyectoU3CaApplication implements CommandLineRunner{

	private static final Logger logger = Logger.getLogger(ProyectoU3CaApplication.class);
	
	@Autowired
	private ITransferenciaService transferenciaService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3CaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		this.transferenciaService.realizarTransferencia("4542121", "11212131", new BigDecimal(2));
	}

}
