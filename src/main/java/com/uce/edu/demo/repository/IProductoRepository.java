package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.Producto;

public interface IProductoRepository {
	public void actualizar(Producto producto);
	public Producto buscar(String nombre);
}
