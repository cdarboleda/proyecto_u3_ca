package com.uce.edu.demo.service.funcional;

@FunctionalInterface
public interface IPersonaPredicate<T> {
	public boolean test(T arg);
}
