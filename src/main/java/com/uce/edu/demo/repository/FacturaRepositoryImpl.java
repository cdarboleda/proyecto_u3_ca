package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Factura;

@Repository
@Transactional
public class FacturaRepositoryImpl implements IFacturaRepository {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	//@Transactional(value = TxType.NOT_SUPPORTED)
	public Factura consultar(String numeroFactura) {
		// TODO Auto-generated method stub
		String sql = "SELECT f FROM Factura f WHERE f.numero = :numeroFactura";
		TypedQuery<Factura> query = this.entityManager.createQuery(sql, Factura.class);
		query.setParameter("numeroFactura", numeroFactura);
		return query.getSingleResult();
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertar(Factura factura) {
		// TODO Auto-generated method stub
		this.entityManager.persist(factura);
	}
	
	@Override
	@Transactional(value = TxType.REQUIRED)//REQUIRED es por defecto MANDATORY
	public void actualizar(Factura factura) {
		// TODO Auto-generated method stub
		this.entityManager.merge(factura);
	}

	@Override
	public List<Factura> buscarFacturaInnerJoin() {
		// TODO Auto-generated method stub
		String sql = "SELECT f FROM Factura f JOIN f.detalles d";
		TypedQuery<Factura> myQuery = this.entityManager.createQuery(sql, Factura.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaOuterLeftJoin() {
		// TODO Auto-generated method stub
		String sql = "SELECT f FROM Factura f LEFT JOIN f.detalles d";
		TypedQuery<Factura> myQuery = this.entityManager.createQuery(sql, Factura.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaInnerJoin(Integer cantidad) {
		// TODO Auto-generated method stub
		String sql = "SELECT f FROM Factura f JOIN f.detalles d WHERE d.cantidad >= :cantidad";
		TypedQuery<Factura> myQuery = this.entityManager.createQuery(sql, Factura.class);
		myQuery.setParameter("cantidad", cantidad);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaOuterLeftJoin(Integer cantidad) {
		// TODO Auto-generated method stub
		String sql = "SELECT f FROM Factura f LEFT JOIN f.detalles d WHERE d.cantidad >= :cantidad";
		TypedQuery<Factura> myQuery = this.entityManager.createQuery(sql, Factura.class);
		myQuery.setParameter("cantidad", cantidad);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaOuterRightJoin(Integer cantidad) {
		// TODO Auto-generated method stub
		String sql = "SELECT f FROM Factura f RIGHT JOIN f.detalles d WHERE d.cantidad >= :cantidad";
		TypedQuery<Factura> myQuery = this.entityManager.createQuery(sql, Factura.class);
		myQuery.setParameter("cantidad", cantidad);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaJoinWhere(Integer cantidad) {
		// TODO Auto-generated method stub
		String sql = "SELECT f FROM Factura f, Detalle d WHERE f = d.factura AND d.cantidad >= :cantidad";
		TypedQuery<Factura> myQuery = this.entityManager.createQuery(sql, Factura.class);
		myQuery.setParameter("cantidad", cantidad);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaJoinFetch(Integer cantidad) {
		// TODO Auto-generated method stub
		String sql = "SELECT f FROM Factura f JOIN FETCH f.detalles d WHERE d.cantidad >= :cantidad";
		TypedQuery<Factura> myQuery = this.entityManager.createQuery(sql, Factura.class);
		myQuery.setParameter("cantidad", cantidad);
		return myQuery.getResultList();
	}

}
