package com.quentin.starassistws.restcombo;

import java.util.List;

import com.quentin.starassistws.objetos.PaisOrigen;

public class PaisOrigenResponse {

	private String error;
	private String aviso;
	private List<PaisOrigen>lista;
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getAviso() {
		return aviso;
	}
	public void setAviso(String aviso) {
		this.aviso = aviso;
	}
	public List<PaisOrigen> getLista() {
		return lista;
	}
	public void setLista(List<PaisOrigen> lista) {
		this.lista = lista;
	}
	
	
}
