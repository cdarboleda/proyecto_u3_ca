package com.uce.edu.demo.service.funcional;

import org.apache.log4j.Logger;

public class MainInterfacesFuncionales {
	
	private static final Logger logger = Logger.getLogger(MainInterfacesFuncionales.class);
	
	public static void main(String[] args) {
		
		//Supplier
		//Clases
		IPersonaSupplier<String> supplier = new PersonaSupplierImpl();
		logger.info("Supplier Clase: " + supplier.getNombre());
		//Lambdas
		IPersonaSupplier<String> supplierLambda = () -> "Cristian 2";
		logger.info("Supplier Lambda: " + supplierLambda.getNombre());
		
		//Consumer
		//Clases
		IPersonaConsumer<String> consumer = new IPersonaConsumerImpl();
		consumer.accept("Prueba Consumer");
		//Lambdas
		IPersonaConsumer<String> consumerLambda = arg -> System.out.println(arg);
		consumerLambda.accept("Prueba Consumer Lambda");
		//Predicate
		//Clases
		//Lambdas
		
		//Function
		//Clases
		//Lambdas
		
		//Unary Operator
		//Clases
		//Lambdas
		
	}
}
