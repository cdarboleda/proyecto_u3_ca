package com.uce.edu.demo.service.funcional;

@FunctionalInterface
public interface IPersonaFunction<R, T> {
	public T apply(R arg);
}
