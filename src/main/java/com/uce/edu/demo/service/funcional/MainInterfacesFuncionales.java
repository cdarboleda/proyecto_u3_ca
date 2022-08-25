package com.uce.edu.demo.service.funcional;

import java.time.LocalDateTime;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import org.apache.log4j.Logger;

public class MainInterfacesFuncionales {
	
	private static final Logger logger = Logger.getLogger(MainInterfacesFuncionales.class);
	
	public static void main(String[] args) {
		
		MiClaseHighHorder miClaseHighHorder = new MiClaseHighHorder();
		
		//Supplier
		Supplier<String> supplier = new MiClaseSupplier();//Clases
		logger.info("Supplier Clase Fecha y Hora actual: " + supplier.get());
		Supplier<String> supplierLambda = () -> LocalDateTime.now().plusYears(5l).toString();//Lambdas
		logger.info("Supplier Lambda Fecha y Hora actual mas 5 años: " + supplierLambda.get());
		String valorHO = miClaseHighHorder.supplierHO(() -> LocalDateTime.now().toString());//Metodos High Order
		logger.info("Supplier HighOrder Fecha y Hora actual: " + valorHO);
		
		//Consumer
		Consumer<String> consumer = new MiClaseConsumer();//Clases
		consumer.accept("consumer clase: en mayúsculas");
		Consumer<String> consumerLambda = arg -> System.out.println(arg.toLowerCase());;//Lambdas
		consumerLambda.accept("consumer lambda: EN MINÚSCULAS");
		int valorHighOrder =miClaseHighHorder.consumerHO(arg -> System.out.println(arg.toUpperCase()), LocalDateTime.now());
		logger.info("y el día en número: " + valorHighOrder);//Metodos High Order
		
		//Predicate
		Predicate<String> predicate = new MiClasePredicate();
		logger.info("Predicate Clase String en blanco?: "+predicate.test("a"));//Clases
		Predicate<String> predicateLambda = (cadena) -> cadena.isBlank();
		logger.info("Predicate Lambda String en blanco?: " + predicateLambda.test(""));//Lambdas
		int valorIntdeBoolean=miClaseHighHorder.predicateHO((cadena) -> cadena.isBlank(), "");//Metodos High Order
		logger.info("Predicate HighOrder String en blanco?: " + valorIntdeBoolean);
		
		//Function
		Function<String, Integer> function = new MiClaseFunction();//Clases
		int num =function.apply("Tres");
		logger.info("Function Clase Numero String a Integer: "+ num); 
		Function<Integer, String> functionLambda = entero -> {//Lambdas
			switch(entero) {
			case 1: return "Uno";
			case 2: return "Dos";	
			case 3: return "Tres";
			case 4: return "Cuatro";
			case 5: return "Cinco";
			}return "Cero";};
		logger.info("Function Lambda Numero Integer a String: "+functionLambda.apply(2));
		int valorFinalHO= miClaseHighHorder.functionHO(valor -> functionLambda.apply(valor), 1);//Metodos High Order
		logger.info("Function HighOrder Longitud de caracteres de un numero: "+valorFinalHO);
		
		//Unary Operator
		UnaryOperator<Double> unaryOperator = new MiClaseUnaryOperator();//Clases
		logger.info("UnaryOperator Clase Multiplicar por un random: "+unaryOperator.apply(2d));
		UnaryOperator<Integer> unaryOperatorLambda = numero -> numero%2==0?1:0;
		logger.info("UnaryOperator Lambda Si es par devuele 1 else 0: "+unaryOperatorLambda.apply(5));//Lambdas
		logger.info("UnaryOperator HighOrder Devuelve el 'iva' de un double: "+miClaseHighHorder.unaryOHO((arg)-> arg*0.12, 5d));

	}
}
