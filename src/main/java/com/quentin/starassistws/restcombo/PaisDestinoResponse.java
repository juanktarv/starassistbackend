package com.quentin.starassistws.restcombo;

import java.util.List;

import com.quentin.starassistws.objetos.Destino;
import com.quentin.starassistws.objetos.PaisDestino;

public class PaisDestinoResponse {

	private String error;
	private String aviso;
	private List<PaisDestino> listapais;
	private List<Destino> listadestino;
	
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
	public List<PaisDestino> getListapais() {
		return listapais;
	}
	public void setListapais(List<PaisDestino> listapais) {
		this.listapais = listapais;
	}
	public List<Destino> getListadestino() {
		return listadestino;
	}
	public void setListadestino(List<Destino> listadestino) {
		this.listadestino = listadestino;
	}
	
	
	
	
}
