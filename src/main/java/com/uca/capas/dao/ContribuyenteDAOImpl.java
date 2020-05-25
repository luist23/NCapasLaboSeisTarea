package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Contribuyente;
import com.uca.capas.domain.Estudiante;

@Repository
public class ContribuyenteDAOImpl  implements ContribuyenteDAO{

	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;
	
	@Override
	public List<Contribuyente> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM contribuyente");
		Query query = entityManager.createNativeQuery(sb.toString(), Contribuyente.class);
		List<Contribuyente> resultset = query.getResultList();
		
		return resultset;
	}

	@Override
	@Transactional
	public Contribuyente findOne(Integer codigo) throws DataAccessException {
		// TODO Auto-generated method stub
		return entityManager.find(Contribuyente.class, codigo);
	}

	@Override
	@Transactional
	public void insert(Contribuyente contribuyente) throws DataAccessException {
		// TODO Auto-generated method stub
		entityManager.persist(contribuyente);	
		
	}

	@Override
	public void delete(Contribuyente contribuyente) throws DataAccessException {
		// TODO Auto-generated method stub
		entityManager.remove(contribuyente);
		
	}

}
