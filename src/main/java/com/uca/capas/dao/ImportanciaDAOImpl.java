package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Estudiante;
import com.uca.capas.domain.Importancia;

@Repository
public class ImportanciaDAOImpl implements ImportanciaDAO {

	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;
	
	@Override
	public List<Importancia> findAll() throws DataAccessException {
		
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM importancia");
		Query query = entityManager.createNativeQuery(sb.toString(), Importancia.class);
		List<Importancia> resultset = query.getResultList();
		
		return resultset;
	}

	@Override
	@Transactional
	public Importancia findOne(Integer codigo) throws DataAccessException {
		// TODO Auto-generated method stub
		return entityManager.find(Importancia.class, codigo);
	}

	@Override
	@Transactional
	public void insert(Importancia importancia) throws DataAccessException {
		// TODO Auto-generated method stub
		entityManager.persist(importancia);	
		
	}

	@Override
	public void delete(Importancia importancia) throws DataAccessException {
		// TODO Auto-generated method stub
		entityManager.remove(importancia);
		
	}

}
