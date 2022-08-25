package com.uce.edu.demo.service.funcional;

import java.util.function.Consumer;

public class MiClaseConsumer implements Consumer<String>{

	@Override
	public void accept(String t) {
		// TODO Auto-generated method stub
		System.out.println(t.toUpperCase());
	}

}
