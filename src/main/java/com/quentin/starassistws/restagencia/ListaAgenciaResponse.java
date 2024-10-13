package com.quentin.starassistws.restagencia;

import java.util.List;

import com.quentin.startassistws.objetoagencia.Agencia;

public class ListaAgenciaResponse {

	private String aviso;
	private String error;
	private List<Agencia>lista;
	
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
	public List<Agencia> getLista() {
		return lista;
	}
	public void setLista(List<Agencia> lista) {
		this.lista = lista;
	}
	
	
	
}
