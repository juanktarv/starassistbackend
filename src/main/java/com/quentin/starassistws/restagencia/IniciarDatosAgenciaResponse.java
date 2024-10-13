package com.quentin.starassistws.restagencia;

import java.util.List;

import com.quentin.startassistws.objetoagencia.Pais;

public class IniciarDatosAgenciaResponse {

	private String aviso;
	private String error;
	private List<Pais>listaPais;
	
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
	public List<Pais> getListaPais() {
		return listaPais;
	}
	public void setListaPais(List<Pais> listaPais) {
		this.listaPais = listaPais;
	}
	
	
}
