package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.dao.ImportanciaDAO;
import com.uca.capas.domain.Importancia;

@Service
public class ImportanciaServiceImpl implements ImportanciaService {
	
	@Autowired
	ImportanciaDAO importanciaDAO;
	@Override
	public List<Importancia> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return importanciaDAO.findAll();
	}
	@Override
	public Importancia findOne(Integer codigo) throws DataAccessException {
		// TODO Auto-generated method stub
		return importanciaDAO.findOne(codigo);
	}
	@Override
	public void insert(Importancia importancia) throws DataAccessException {
		// TODO Auto-generated method stub
		importanciaDAO.insert(importancia);
	}
	@Override
	public void delete(Importancia importancia) throws DataAccessException {
		// TODO Auto-generated method stub
		importanciaDAO.delete(importancia);
	}

}
