package com.uce.edu.demo.service.funcional;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

public class MainInterfacesFuncionales {
	
	public static boolean prueba(Integer numero) {
		return numero>=3;
	}
	
	public static void imprimir(String numero) {
		 logger.info(numero);
	}
	
	
	private static final Logger logger = Logger.getLogger(MainInterfacesFuncionales.class);
	
	public static void main(String[] args) {
		
		MiClaseHighHorder miClaseHighHorder = new MiClaseHighHorder();
		
		//JAVA
		//Suplier 
		logger.info("Java Supplier");
		Stream<String> test = Stream.generate(()-> "Edison 3").limit(2);
		test.forEach(cadena -> System.out.println(cadena));
		
		//Java
		//Consumer
		logger.info("Java Consumer");
		List<Integer> listaNumeros= Arrays.asList(1,2,3,4,5);
		listaNumeros.forEach(System.out::println);
		
		//Java
		//Predicate
		logger.info("Java Predicate");
		Stream<Integer> nuevaLista = listaNumeros.stream().filter(numero-> prueba(numero));
		listaNumeros.forEach(System.out::println);
		
		//Java
		//Function
		logger.info("Java Function");
		Stream<String> listaCambiada = listaNumeros.stream().map(numeroLista -> {
			Integer valor = numeroLista +1;
			return "Num: "+valor.toString();
		});
		
		listaCambiada.forEach(valor -> imprimir(valor));
	}
}
