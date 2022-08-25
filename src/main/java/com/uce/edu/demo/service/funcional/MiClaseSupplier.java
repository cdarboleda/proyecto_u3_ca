package com.uce.edu.demo.service.funcional;

import java.time.LocalDateTime;
import java.util.function.Supplier;

public class MiClaseSupplier implements Supplier<String>{

	@Override
	public String get() {
		// TODO Auto-generated method stub
		return LocalDateTime.now().toString();
	}
	
}
