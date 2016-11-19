package com.jonatan.tutorial.dao;

import java.util.List;

import com.jonatan.tutorial.model.Provincia;

public interface ProvinciaDAO {
	
	public void addProvincia(Provincia p);

	public void updateProvincia(Provincia p);

	public List<Provincia> listProvincias();

	public Provincia getProvinciaByCodigo(String codigo);

	public void removeProvincia(String codigo);
	
}
