package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ICuentaBancariaRepository;
import com.uce.edu.demo.repository.ITransferenciaRepository;
import com.uce.edu.demo.repository.modelo.CuentaBancaria;
import com.uce.edu.demo.repository.modelo.Transferencia;

@Service
public class TransferenciaServiceImpl implements ITransferenciaService {

	@Autowired
	private ICuentaBancariaRepository cuentaBancariaRepository;
	
	@Autowired
	private ITransferenciaRepository transferenciaRepository;
	
//	@Override
//	@Transactional(value = TxType.REQUIRED)//REQUIRED es por defecto
//	public void realizarTransferencia(String numero, String numeroCuentaOrigen, String numeroCuentaDestino, BigDecimal monto) {
//		// TODO Auto-generated method stub
//		//0. Buscar las cuentas origen y destino
//		//1. Restar el monto de la cuenta origen
//		//2. Sumar el monto a la cuenta destino
//		//3. Insertar transferencia
//		
//		//0.
//		CuentaBancaria ctaOrigen = this.cuentaBancariaRepository.buscarPorNumero(numeroCuentaOrigen);
//		CuentaBancaria ctaDestino = this.cuentaBancariaRepository.buscarPorNumero(numeroCuentaDestino);
//		
//		//1. 
//		ctaOrigen.setSaldo(ctaOrigen.getSaldo().subtract(monto));
//		this.cuentaBancariaRepository.actualizar(ctaOrigen);
//		//2.
//		ctaDestino.setSaldo(ctaDestino.getSaldo().add(monto));
//		this.cuentaBancariaRepository.actualizar(ctaDestino);
//		
//		//3.
//		Transferencia transferencia = new Transferencia();
//		transferencia.setCuentaOrigen(ctaOrigen);
//		transferencia.setCuentaDestino(ctaDestino);
//		transferencia.setFecha(LocalDateTime.now());
//		transferencia.setNumero(numero);
//		transferencia.setMonto(monto);
//		//id es secuencia desde la base de datos
//		this.transferenciaRepository.insertar(transferencia);
//		
//	}
	@Override
	@Transactional(value = TxType.REQUIRED)//REQUIRED es por defecto
	public void realizarTransferencia(String numeroCuentaOrigen, String numeroCuentaDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		//0. Buscar las cuentas origen y destino
		//1. Restar el monto de la cuenta origen
		//2. Sumar el monto a la cuenta destino
		//3. Insertar transferencia
		
		//0.
		CuentaBancaria ctaOrigen = this.cuentaBancariaRepository.buscarPorNumero(numeroCuentaOrigen);
		CuentaBancaria ctaDestino = this.cuentaBancariaRepository.buscarPorNumero(numeroCuentaDestino);
		
		//1. 
		BigDecimal saldoOrigen = ctaOrigen.getSaldo();
		ctaOrigen.setSaldo(ctaOrigen.getSaldo().subtract(monto));
		this.cuentaBancariaRepository.actualizar(ctaOrigen);
		//2.
		ctaDestino.setSaldo(ctaDestino.getSaldo().add(monto));
		this.cuentaBancariaRepository.actualizar(ctaDestino);
		
		//3.
		Transferencia transferencia = new Transferencia();
		transferencia.setCuentaOrigen(ctaOrigen);
		transferencia.setCuentaDestino(ctaDestino);
		transferencia.setFecha(LocalDateTime.now());
		transferencia.setMonto(monto);
		//id es secuencia desde la base de datos
		this.transferenciaRepository.insertar(transferencia);
		
		if (monto.compareTo(saldoOrigen)>0) {
			throw new RuntimeException();
		}
		
	}
}
