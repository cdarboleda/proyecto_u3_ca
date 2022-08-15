package com.uce.edu.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.uce.edu.demo.repository.ICuentaBancariaRepository;
import com.uce.edu.demo.repository.ITransferenciaRepository;
import com.uce.edu.demo.repository.modelo.CuentaBancaria;
import com.uce.edu.demo.repository.modelo.Transferencia;
import com.uce.edu.demo.service.ITransferenciaService;

@SpringBootTest
class TransferenciaTest {
	
	@Autowired
	private ICuentaBancariaRepository bancariaRepository;
	
	@Autowired
	private ITransferenciaService transferenciaService;
	
	@Autowired
	private ITransferenciaRepository transferenciaRepository;
	
	//Comprobar si se puede realizar una transferencia segun el saldo de una cuenta y el monto asignado
	@Test
	void montoTransferencia(){
		CuentaBancaria ctaOrigen = this.bancariaRepository.buscarPorNumero("11212131");	
		BigDecimal monto = new BigDecimal(5);
		assertTrue(ctaOrigen.getSaldo().doubleValue() > monto.doubleValue(), "Comprobar Monto Válido");
	}
	
	//Comprobar validación de una transferencia
	@Test
	void insercion() {
		this.transferenciaService.realizarTransferencia("12", "11212131", "4542121", new BigDecimal(5));
		Transferencia transferenciaDB = this.transferenciaRepository.buscarPorNumero("12");
		
		CuentaBancaria ctaOrigen = this.bancariaRepository.buscarPorNumero("11212131");	
		CuentaBancaria ctaDestino = this.bancariaRepository.buscarPorNumero("4542121");	
		
		assertEquals(transferenciaDB.getCuentaOrigen().getNumero(), ctaOrigen.getNumero(),"Validar cuenta origen");
		assertEquals(transferenciaDB.getCuentaDestino().getNumero(), ctaDestino.getNumero(), "Validar cuenta destino");	
	}
	
	@Test
	void insercionCuentasIguales() {
		CuentaBancaria ctaOrigen = this.bancariaRepository.buscarPorNumero("11212131");	
		CuentaBancaria ctaDestino = this.bancariaRepository.buscarPorNumero("11212131");	
		
		assertNotEquals(ctaOrigen.getNumero(), ctaDestino.getNumero(),"Validación misma cuenta");
		
		this.transferenciaService.realizarTransferencia("649", "11212131", "4542121", new BigDecimal(5));		
	}
	
	//Comprobar que se realizó la transferencia correctamente
	@Test
	void resultadoTransferencia() {
		CuentaBancaria ctaDestino = this.bancariaRepository.buscarPorNumero("4542121");
		BigDecimal saldoDestino = ctaDestino.getSaldo();
		BigDecimal monto = new BigDecimal(5);
		this.transferenciaService.realizarTransferencia("25", "11212131", "4542121", monto);
		BigDecimal saldoFinal = this.bancariaRepository.buscarPorNumero("4542121").getSaldo();
		
		assertTrue(saldoDestino.compareTo(saldoFinal.subtract(monto))==0, "Comprobar transferencia exitosa");
		
	}

}
