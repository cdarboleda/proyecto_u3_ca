package com.uce.edu.demo.service;

import java.math.BigDecimal;

public interface ITransferenciaService {
	public void realizarTransferencia(String numeroCuentaOrigen, String numeroCuentaDestino, BigDecimal monto);
	public void realizarTransferenciaFachada(String numeroCuentaOrigen, String numeroCuentaDestino, BigDecimal monto);
}
