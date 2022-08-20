package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Transferencia;

@Repository
@Transactional 
public class TransferenciaRepositoryImpl implements ITransferenciaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	//lo usamos en transferencia Service (realizarTransferencia), debe tener una transaccion
	@Override
	@Transactional(value = TxType.MANDATORY)//el metodo que llama a este metodo debe tener una transaccion
	public void insertar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		this.entityManager.persist(transferencia);
		throw new RuntimeException();
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Transferencia buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<Transferencia> myQuery = this.entityManager.createQuery("SELECT t FROM Transferencia t WHERE t.numero = :numero", Transferencia.class);
		myQuery.setParameter("numero", numero);
		return myQuery.getSingleResult();
	}
}
