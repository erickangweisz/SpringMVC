package com.jonatan.tutorial.service;

import java.util.List;

import com.jonatan.tutorial.model.Provincia;

public interface ProvinciaService {
	
	public void addProvincia(Provincia p);

	public void updateProvincia(Provincia p);

	public List<Provincia> listProvincias();

	public Provincia getProvinciaByCodigo(String codigo);

	public void removeProvincia(String codigo);
	
}
