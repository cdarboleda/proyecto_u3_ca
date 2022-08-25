package com.uce.edu.demo.service.funcional;

import java.util.function.Function;

public class MiClaseFunction implements Function<String, Integer> {

	@Override
	public Integer apply(String t) {
		// TODO Auto-generated method stub
		switch(t) {
		case "Uno":
			return 1;
		case "Dos":
			return 2;	
		case "Tres":
			return 3;
		case "Cuatro":
			return 4;
		case "Cinco":
			return 5;
		}
		return 0;
	}

}
