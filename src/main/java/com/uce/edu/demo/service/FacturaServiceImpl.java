package com.uce.edu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IFacturaRepository;
import com.uce.edu.demo.repository.modelo.Factura;

@Service
public class FacturaServiceImpl implements IFacturaService {

	@Autowired
	private IFacturaRepository facturaRepository;

	@Override
	public Factura consultar(String numeroFactura) {
		// TODO Auto-generated method stub
		return this.facturaRepository.consultar(numeroFactura);
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
