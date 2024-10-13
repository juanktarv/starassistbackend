package com.quentin.starassistws.objetos;

import java.util.List;

public class CotizarResponse {

	private String aviso;
	private String error;
	private Integer tedadmayo;
	private List<PasajeroError> listaErrorEdad;
	private List<PrecioPlanCotizado> lista;
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
	public Integer getTedadmayo() {
		return tedadmayo;
	}
	public void setTedadmayo(Integer tedadmayo) {
		this.tedadmayo = tedadmayo;
	}
	public List<PasajeroError> getListaErrorEdad() {
		return listaErrorEdad;
	}
	public void setListaErrorEdad(List<PasajeroError> listaErrorEdad) {
		this.listaErrorEdad = listaErrorEdad;
	}
	public List<PrecioPlanCotizado> getLista() {
		return lista;
	}
	public void setLista(List<PrecioPlanCotizado> lista) {
		this.lista = lista;
	}
	
	
}
