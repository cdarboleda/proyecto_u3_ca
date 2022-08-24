package com.uce.edu.demo.service.funcional;

import org.apache.log4j.Logger;

public class MainInterfacesFuncionales {
	
	private static final Logger logger = Logger.getLogger(MainInterfacesFuncionales.class);
	
	public static void main(String[] args) {
		
		ConsumoMetodosHighOrder metodosHO = new ConsumoMetodosHighOrder();
		
		//Supplier
		//Clases
		IPersonaSupplier<String> supplier = new PersonaSupplierImpl();
		logger.info("Supplier Clase: " + supplier.getNombre());
		//Lambdas
		IPersonaSupplier<String> supplierLambda = () -> "Cristian 2";
		logger.info("Supplier Lambda: " + supplierLambda.getNombre());
		//Metodos High Order
		String valorHO = metodosHO.consumirSupplier(() -> "Hola Mundo");
		logger.info("Supplier HighOrder: " + valorHO);
		
		String valorHO2 = metodosHO.consumirSupplier(() -> {
			String valorConsultado = "171282383";
			return valorConsultado;
			});
		logger.info("Supplier HighOrder2: " + valorHO2);
		
		//Consumer
		//Clases
		IPersonaConsumer<String> consumer = new IPersonaConsumerImpl();
		consumer.accept("Prueba Consumer");
		//Lambdas
		IPersonaConsumer<String> consumerLambda = arg -> System.out.println(arg);
		consumerLambda.accept("Prueba Consumer Lambda");
		//Metodos High Order
		metodosHO.consumirConsumer(valor -> System.out.println(valor), 2);

		//Predicate
		//Clases
		//Lambdas
		IPersonaPredicate<String> predicateLambda = (cadena) -> cadena.contains("Z");
		logger.info("Predicate Lambda: " + predicateLambda.test("Zapato"));
		//Metodos High Order
		boolean val =metodosHO.consumirPredicate((cadena) -> cadena.contains("Z"), "Zapato");
		logger.info("Predicate HighOrder2: " + val);
		
		//Function
		//Clases
		//Lambdas
		IPersonaFunction<String, Integer> functionLambda = cadena -> Integer.parseInt(cadena)-1;
		logger.info("Function Lambda: "+functionLambda.apply("7"));
		//Metodos High Order
		String valorFinalHO= metodosHO.consumirFunction(valor -> {
			String retorno = valor.toString()+"A";
			return retorno;
		}, 1);
		logger.info("Function Lambda: "+valorFinalHO);
		
		//Unary Operator
		//Clases
		//Lambdas
		IPersonaUnaryOperator<String> unaryLambda = cade -> {
			String valorFinal = cade.concat(" sufijo");
			return valorFinal;
		};
		
		logger.info("Function Lambda: "+unaryLambda.apply("Daniel"));
		

	}
}
