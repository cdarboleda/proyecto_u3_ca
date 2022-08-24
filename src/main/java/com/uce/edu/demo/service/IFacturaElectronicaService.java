package com.uce.edu.demo.service;

import java.math.BigDecimal;

public interface IFacturaElectronicaService {
	public void insertarFacturaE(String numeroFactura, BigDecimal monto);
}
