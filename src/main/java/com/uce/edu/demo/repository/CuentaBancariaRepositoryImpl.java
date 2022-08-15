package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.demo.repository.modelo.CuentaBancaria;

@Repository
@Transactional
public class CuentaBancariaRepositoryImpl implements ICuentaBancariaRepository {
	
	private static final Logger logger = Logger.getLogger(CuentaBancariaRepositoryImpl.class);

	@PersistenceContext
	private EntityManager entityManager;
	
	//lo usamos en transferencia Service (realizarTransferencia), debe tener una transaccion
	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		this.entityManager.merge(cuentaBancaria);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)//No necesita una transacción
	public CuentaBancaria buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		logger.info("Transacción activa buscarPorNumero: "+ TransactionSynchronizationManager.isActualTransactionActive());
		String sql = "SELECT c FROM CuentaBancaria c WHERE c.numero = :numero";
		TypedQuery<CuentaBancaria> myQuery = this.entityManager.createQuery(sql, CuentaBancaria.class);
		myQuery.setParameter("numero", numero);
		return myQuery.getSingleResult();
	}

}
