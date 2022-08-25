package com.uce.edu.demo.service.funcional;

import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class MiClaseHighHorder {

	public String supplierHO(Supplier<String> sup) {
		return " en Ecuador: "+sup.get();
	}
	
	public Integer consumerHO(Consumer<String> con, LocalDateTime dia) {
		String diaString ="Consumer HighOrder Día "+dia.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault());
		con.accept(diaString);
		int diaInt = dia.getDayOfWeek().getValue();
		return diaInt;
	}
	
	public Integer predicateHO(Predicate<String> pre, String cadena) {
		return pre.test(cadena)?1:0;
	}
	
	public Integer functionHO(Function<Integer, String> fun, Integer num) {
		return fun.apply(num).length();
	}
	
	public Double unaryOHO(UnaryOperator<Double> fun, double num) {
		return fun.apply(num);
	}
}
