package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Factura;

@Repository
@Transactional
public class FacturaRepositoryImpl implements IFacturaRepository {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Factura consultar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Factura.class, id);
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
