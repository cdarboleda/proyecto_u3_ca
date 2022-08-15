package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.demo.repository.modelo.Hotel;

@Repository
@Transactional
public class HotelRepositoryImpl implements IHotelRepository{
	
	private static final Logger logger = Logger.getLogger(HotelRepositoryImpl.class);

	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public void insertar(Hotel h) {
		// TODO Auto-generated method stub
		this.entityManager.persist(h);
	}
	
	@Override
	public List<Hotel> buscarHotelJoinWhere(String tipoHabitacion) {
		// TODO Auto-generated method stub
		//SELECT * FROM public.hotel ho, habitacion ha WHERE ho.hote_id = ha.habi_id_hotel;
		String sql = "SELECT h FROM Hotel h, Habitacion ha WHERE h =ha.hotel AND ha.tipo = :tipoHabitacion";
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery(sql, Hotel.class);
		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
		
		return myQuery.getResultList();
	}

	@Override
	//@Transactional(value = TxType.MANDATORY)
	public List<Hotel> buscarHotelJoinFetch(String tipoHabitacion) {
		// TODO Auto-generated method stub
		logger.info("Transacción activa Repository: "+ TransactionSynchronizationManager.isActualTransactionActive());
		String sql = "SELECT h FROM Hotel h JOIN FETCH h.habitaciones ha WHERE ha.tipo = :tipoHabitacion";
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery(sql, Hotel.class);
		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
		
		return myQuery.getResultList();
	}
	
	@Override
	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		String sql = "SELECT h FROM Hotel h JOIN h.habitaciones ha WHERE ha.tipo = :tipoHabitacion";
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery(sql, Hotel.class);
		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
		
		List<Hotel> hoteles = myQuery.getResultList();
		
		//Traida bajo demanda
		for(Hotel h:hoteles) {
			h.getHabitaciones().size();
		}
		
		return hoteles;
	}

	@Override
	public List<Hotel> buscarHotelOuterLeftJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		String sql = "SELECT h FROM Hotel h LEFT JOIN h.habitaciones ha WHERE ha.tipo = :tipoHabitacion";
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery(sql, Hotel.class);
		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelOuterRightJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		String sql = "SELECT h FROM Hotel h RIGHT JOIN h.habitaciones ha WHERE ha.tipo = :tipoHabitacion";
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery(sql, Hotel.class);
		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelInnerJoin() {
		// TODO Auto-generated method stub
		String sql = "SELECT h FROM Hotel h JOIN h.habitaciones ha";
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery(sql, Hotel.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelOuterLeftJoin() {
		// TODO Auto-generated method stub
		String sql = "SELECT h FROM Hotel h LEFT JOIN h.habitaciones ha";
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery(sql, Hotel.class);
		return myQuery.getResultList();
	}

}
