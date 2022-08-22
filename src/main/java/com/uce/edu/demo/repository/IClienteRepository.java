package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.Cliente;

public interface IClienteRepository {
	public void insertar(Cliente cliente);
	public Cliente buscar(String cedula);
}
