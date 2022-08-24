package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Producto;

@Repository
@Transactional
public class ProductoRepositoryImpl implements IProductoRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value = TxType.MANDATORY)//REQUIRED es por defecto
	public void actualizar(Producto producto) {
		// TODO Auto-generated method stub
		this.entityManager.merge(producto);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Producto buscar(String nombre) {
		// TODO Auto-generated method stub
		String sql = "SELECT p FROM Producto p WHERE p.nombre = :nombre";
		TypedQuery<Producto> query = this.entityManager.createQuery(sql, Producto.class);
		query.setParameter("nombre", nombre);
		return query.getSingleResult();
	}

}
