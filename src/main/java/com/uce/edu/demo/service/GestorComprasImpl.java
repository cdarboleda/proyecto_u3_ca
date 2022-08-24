package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.ProyectoU3CaApplication;

@Service
public class GestorComprasImpl implements IGestorComprasService {

	@Autowired
	private IFacturaService facturaService;
	@Autowired
	private IFacturaElectronicaService electronicaService;

	private static final Logger logger = Logger.getLogger(ProyectoU3CaApplication.class);
	
	//Funcionalidad padre
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void registrarCompraProducto(String cedula, String numeroFactura, List<String> listaCodigos) {
		
		logger.info("-----Creacion de factura y actualizacion de stock-----");
		//Creacion de factura y actualizacion de stock
		BigDecimal subTotalFE= this.facturaService.crearFactura(cedula, numeroFactura, listaCodigos);
		
		logger.info("\n----------\n");
		
		logger.info("-----Insercion de factura electronica-----");
		//Insercion de factura electronica
		//Monto de factura a factura electronica		
		this.electronicaService.insertarFacturaE(numeroFactura, subTotalFE);
		
	}
}
