package com.uce.edu.demo.service.funcional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

public class MainInterfacesFuncionales {
	
	
	private static final Logger logger = Logger.getLogger(MainInterfacesFuncionales.class);
	
	public static void main(String[] args) {
		
		//JAVA
		//Supplier 
		logger.info("Java Stream Supplier");
		logger.info("Se utilizó el método Collectors.toCollection(Supplier)");
		Stream<String> streamString = Stream.of("A", "B", "C");
		List<String> streamStringProcesado = streamString.collect(Collectors.toCollection(() -> new ArrayList<String>()));
		logger.info(streamStringProcesado);
		logger.info("\n");

		//Java
		//Consumer
		logger.info("Java Stream Consumer");
		logger.info("Se utilizó el método peek(Consumer)");
		Stream<Integer> streamNumeros= Stream.of(1,2,3,4,5,6,7,8,9,10);
		List<Integer> listaNumeros=streamNumeros.filter(n-> n%2==0).peek(n->logger.info("El número "+n+" sí es par!")).collect(Collectors.toList());
		listaNumeros.forEach(s->logger.info(s));
		logger.info("\n");
		
		//Java
		//Predicate
		logger.info("Java Stream Predicate");
		logger.info("Se utilizó el anyMatch(Predicate)");
		Stream<Integer> streamEdades = Stream.of(20,40,22,18,25,23);
		if(streamEdades.anyMatch(n->n>30)) logger.info("Almenos un elemento de la lista es mayor o igual a 30");
		logger.info("\n");
		
		//Java
		//Function
		logger.info("Java Stream Function");
		logger.info("Se utilizó map para convertir los length de varios string en enteros, y un reduce para sumarlos");
		Stream<String> streamString2 = Stream.of("Uno", "Dos", "Tres", "Cuatro", "Cinco");
		int suma = streamString2.map(numeroS ->numeroS.length()).reduce(0, (total,  n) -> total+n);//Valor inicial de total, Acumulador
		logger.info("Suma de los length del stream: " + suma);

	}
}
