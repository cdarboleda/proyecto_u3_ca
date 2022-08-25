package com.uce.edu.demo.service.funcional;

import java.util.function.Predicate;

public class MiClasePredicate implements Predicate<String>{

	@Override
	public boolean test(String t) {
		// TODO Auto-generated method stub
		return t.isBlank()?true:false;
	}

}
