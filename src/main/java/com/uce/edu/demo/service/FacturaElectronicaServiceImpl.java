package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IFacturaElectronicaRepository;
import com.uce.edu.demo.repository.modelo.FacturaElectronica;

@Service
public class FacturaElectronicaServiceImpl implements IFacturaElectronicaService{

	@Autowired
	private IFacturaElectronicaRepository facturaElectronicaRepository;
	
	@Transactional(value = TxType.REQUIRES_NEW)
	public void insertarFacturaE(String numeroFactura, BigDecimal monto) {
		FacturaElectronica facturaElectronica = new FacturaElectronica();
		facturaElectronica.setNumeroFactura(numeroFactura);
		facturaElectronica.setMonto(monto);
		facturaElectronica.setFecha(LocalDateTime.now());
				
		this.facturaElectronicaRepository.insertar(facturaElectronica);
	}
}
