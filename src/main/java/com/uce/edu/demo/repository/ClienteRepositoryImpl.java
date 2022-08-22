package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Cliente;

@Repository
@Transactional
public class ClienteRepositoryImpl implements IClienteRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertar(Cliente cliente) {
		// TODO Auto-generated method stub
		this.entityManager.persist(cliente);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Cliente buscar(String cedula) {
		// TODO Auto-generated method stub
		String sql = "SELECT c FROM Cliente c WHERE c.cedula = :cedula";
		TypedQuery<Cliente> query = this.entityManager.createQuery(sql, Cliente.class);
		query.setParameter("cedula", cedula);
		
		Cliente cliente = null;
		try {
			cliente = query.getSingleResult();
		}catch(Exception e) {
			//throw new RuntimeException();
		}
		return cliente;
	}

}
