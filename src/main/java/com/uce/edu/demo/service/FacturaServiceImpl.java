package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IClienteRepository;
import com.uce.edu.demo.repository.IFacturaRepository;
import com.uce.edu.demo.repository.IProductoRepository;
import com.uce.edu.demo.repository.modelo.Cliente;
import com.uce.edu.demo.repository.modelo.Detalle;
import com.uce.edu.demo.repository.modelo.Factura;
import com.uce.edu.demo.repository.modelo.Producto;

@Service
public class FacturaServiceImpl implements IFacturaService {

	@Autowired
	private IFacturaRepository facturaRepository;
	@Autowired
	private IClienteRepository clienteRepository;

	@Autowired
	private IProductoRepository productoRepository;

	@Override
	public Factura consultar(String numeroFactura) {
		// TODO Auto-generated method stub
		return this.facturaRepository.consultar(numeroFactura);
	}
	
	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public BigDecimal crearFactura(String cedula, String numeroFactura, List<String> listaCodigos) {
		//Buscar cliente
		Cliente cliente = this.clienteRepository.buscar(cedula);
		
		//Crear factura vacia
		Factura factura = new Factura();
		factura.setNumero(numeroFactura);
		factura.setCliente(cliente);
		factura.setFecha(LocalDateTime.now());
		//this.facturaRepository.insertar(factura);
		
		//Factura facturaDB = this.facturaRepository.consultar(numeroFactura);
		
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
			
			detalle.setFactura(factura);
			return detalle;
		}).collect(Collectors.toList());
		
		//Actualizar factura (añadir detalles con productos)
		factura.setDetalles(listaDetalle);
		//this.facturaRepository.actualizar(facturaDB);	
		this.facturaRepository.insertar(factura);
		
		BigDecimal subTotalFE = new BigDecimal(0);
		
		for (Detalle d: factura.getDetalles()) {
			subTotalFE=subTotalFE.add(d.getSubtotal());
		}
		
		return subTotalFE;
	}

	@Override
	public List<Factura> buscarFacturaInnerJoin() {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaInnerJoin();
	}

	@Override
	public List<Factura> buscarFacturaOuterLeftJoin() {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaOuterLeftJoin(null);
	}

	@Override
	public List<Factura> buscarFacturaInnerJoin(Integer cantidad) {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaInnerJoin(cantidad);
	}

	@Override
	public List<Factura> buscarFacturaOuterLeftJoin(Integer cantidad) {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaOuterLeftJoin(cantidad);
	}

	@Override
	public List<Factura> buscarFacturaOuterRightJoin(Integer cantidad) {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaOuterRightJoin(cantidad);
	}

	@Override
	public List<Factura> buscarFacturaJoinWhere(Integer cantidad) {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaJoinWhere(cantidad);
	}

	@Override
	public List<Factura> buscarFacturaJoinFetch(Integer cantidad) {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaJoinFetch(cantidad);
	}

}
