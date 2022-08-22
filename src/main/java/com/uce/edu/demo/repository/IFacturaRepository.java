package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Factura;

public interface IFacturaRepository {
	public Factura consultar(String numeroFactura);
	public void insertar(Factura factura);
	public void actualizar(Factura factura);
	public List<Factura> buscarFacturaInnerJoin();
	public List<Factura> buscarFacturaOuterLeftJoin();
	public List<Factura> buscarFacturaInnerJoin(Integer cantidad);
	public List<Factura> buscarFacturaOuterLeftJoin(Integer cantidad);
	public List<Factura> buscarFacturaOuterRightJoin(Integer cantidad);
	public List<Factura> buscarFacturaJoinWhere(Integer cantidad);
	public List<Factura> buscarFacturaJoinFetch(Integer cantidad);
}
