package com.jonatan.tutorial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jonatan.tutorial.dao.ProvinciaDAO;
import com.jonatan.tutorial.model.Provincia;

@Service
public class ProvinciaServiceImpl implements ProvinciaService {

	@Autowired
	private ProvinciaDAO provinciaDAO;
	
	public void setProvinciaDAO(ProvinciaDAO provinciaDAO) {
		this.provinciaDAO = provinciaDAO;
	}
	
	@Override
	@Transactional
	public void addProvincia(Provincia p) {
		this.provinciaDAO.addProvincia(p);
	}

	@Override
	@Transactional
	public void updateProvincia(Provincia p) {
		this.provinciaDAO.updateProvincia(p);
	}

	@Override
	@Transactional
	public List<Provincia> listProvincias() {
		return this.provinciaDAO.listProvincias();
	}

	@Override
	@Transactional
	public Provincia getProvinciaByCodigo(String codigo) {
		return this.provinciaDAO.getProvinciaByCodigo(codigo);
	}

	@Override
	@Transactional
	public void removeProvincia(String codigo) {
		this.provinciaDAO.removeProvincia(codigo);
	}

}
