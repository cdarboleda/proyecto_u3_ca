package com.uce.edu.demo.service.funcional;

public class ConsumoMetodosHighOrder {
	
	public String consumirSupplier(IPersonaSupplier<String> funcion) {
//		String valor = funcion.getNombre();
//		//Calcular/Sumar, consultar base, etc
//		Integer numero = Integer.parseInt(valor);
//		return numero;
		return funcion.getNombre().concat(" Se procesó el dato");
	}
	
	public void consumirConsumer(IPersonaConsumer<Integer> function, Integer valor) {
		function.accept(valor);
	}
	
	public boolean consumirPredicate(IPersonaPredicate<String> function, String valor) {
		return function.test(valor);
	}
	
	public String consumirFunction(IPersonaFunction<Integer, String> function, Integer valor) {
		return function.apply(valor);
	}

}
