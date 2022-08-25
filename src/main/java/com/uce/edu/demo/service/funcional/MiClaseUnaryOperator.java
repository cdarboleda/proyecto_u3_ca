package com.uce.edu.demo.service.funcional;

import java.util.function.UnaryOperator;

public class MiClaseUnaryOperator implements UnaryOperator<Double> {

	@Override
	public Double apply(Double t) {
		// TODO Auto-generated method stub
		return t*Math.random();
	}

}
