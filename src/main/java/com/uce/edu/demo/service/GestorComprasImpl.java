package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.ProyectoU3CaApplication;
import com.uce.edu.demo.repository.IClienteRepository;
import com.uce.edu.demo.repository.IFacturaElectronicaRepository;
import com.uce.edu.demo.repository.IFacturaRepository;
import com.uce.edu.demo.repository.IProductoRepository;
import com.uce.edu.demo.repository.modelo.Cliente;
import com.uce.edu.demo.repository.modelo.Detalle;
import com.uce.edu.demo.repository.modelo.Factura;
import com.uce.edu.demo.repository.modelo.FacturaElectronica;
import com.uce.edu.demo.repository.modelo.Producto;

@Service
public class GestorComprasImpl implements IGestorComprasService {

	@Autowired
	private IClienteRepository clienteRepository;
	@Autowired
	private IFacturaRepository facturaRepository;
	@Autowired
	private IProductoRepository productoRepository;
	@Autowired
	private IFacturaElectronicaRepository facturaElectronicaRepository;
	
	private static final Logger logger = Logger.getLogger(ProyectoU3CaApplication.class);
	
	//Funcionalidad padre
	@Override
	public void registrarCompraProducto(String cedula, String numeroFactura, List<String> listaCodigos) {
		
		logger.info("-----Creacion de factura y actualizacion de stock-----");
		//Creacion de factura y actualizacion de stock
		Factura factura = this.crearFactura(cedula, numeroFactura, listaCodigos);
		
		logger.info("\n----------\n");
		
		logger.info("-----Insercion de factura electronica-----");
		//Insercion de factura electronica
		//Monto de factura a factura electronica
		BigDecimal subTotalFE = new BigDecimal(0);
		
		for (Detalle d: factura.getDetalles()) {
			subTotalFE=subTotalFE.add(d.getSubtotal());
		}
		this.insertarFacturaE(numeroFactura, subTotalFE);
		
	}
	
	@Transactional(value = TxType.REQUIRES_NEW)
	public void insertarFacturaE(String numeroFactura, BigDecimal monto) {
		FacturaElectronica facturaElectronica = new FacturaElectronica();
		facturaElectronica.setNumeroFactura(numeroFactura);
		facturaElectronica.setMonto(monto);
		facturaElectronica.setFecha(LocalDateTime.now());
				
		this.facturaElectronicaRepository.insertar(facturaElectronica);
	}
	
	@Transactional(value = TxType.REQUIRES_NEW)
	public Factura crearFactura(String cedula, String numeroFactura, List<String> listaCodigos) {
		//Buscar cliente
		Cliente cliente = this.clienteRepository.buscar(cedula);
		
		//Crear factura vacia
		Factura factura = new Factura();
		factura.setNumero(numeroFactura);
		factura.setCliente(cliente);
		factura.setFecha(LocalDateTime.now());
		this.facturaRepository.insertar(factura);
		
		Factura facturaDB = this.facturaRepository.consultar(numeroFactura);
		
		//lista de codigo de barras, convertido en lista de detalles
		List<Detalle > listaDetalle = listaCodigos.stream().map(x -> {
			Producto p = this.productoRepository.buscar(x);	
			Detalle detalle = new Detalle();
			int cantidad = 1;
			detalle.setCantidad(cantidad);
			detalle.setProducto(p);
			
			//Actualizar Stock de producto
			p.setStock(p.getStock()-cantidad);
			this.productoRepository.actualizar(p);
			BigDecimal aux = p.getPrecio().multiply(new BigDecimal(cantidad));
			detalle.setSubtotal(aux);
			
			detalle.setFactura(facturaDB);
			return detalle;
		}).collect(Collectors.toList());
		
		//Actualizar factura (añadir detalles con productos)
		facturaDB.setDetalles(listaDetalle);
		this.facturaRepository.actualizar(facturaDB);	
		return facturaDB;
	}

}
