package com.quentin.starassistws.restagencia;

import java.util.List;

import com.quentin.startassistws.objetoagencia.Ciudad;

public class ListaCiudadPaisResponse {

	private String aviso;
	private String error;
	private List<Ciudad> listaCiudad;
	public String getAviso() {
		return aviso;
	}
	public void setAviso(String aviso) {
		this.aviso = aviso;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public List<Ciudad> getListaCiudad() {
		return listaCiudad;
	}
	public void setListaCiudad(List<Ciudad> listaCiudad) {
		this.listaCiudad = listaCiudad;
	}
	
	
}
