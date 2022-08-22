package com.uce.edu.demo.service;

import java.util.List;

public interface IGestorComprasService {
	public void registrarCompraProducto(String cedula, String numeroFactura, List<String> listaCodigos);
	
}
