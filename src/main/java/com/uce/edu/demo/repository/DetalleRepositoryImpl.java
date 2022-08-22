package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Detalle;

@Repository
@Transactional
public class DetalleRepositoryImpl implements IDetalleRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Detalle detalle) {
		// TODO Auto-generated method stub
		this.entityManager.persist(detalle);
	}

}
