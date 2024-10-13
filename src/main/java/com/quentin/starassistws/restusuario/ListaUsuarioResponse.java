package com.quentin.starassistws.restusuario;

import java.util.List;

import com.quentin.starassistws.objetousuario.Usuario;

public class ListaUsuarioResponse {

	private String aviso;
	private String error;
	private List<Usuario>lista;
	
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
	public List<Usuario> getLista() {
		return lista;
	}
	public void setLista(List<Usuario> lista) {
		this.lista = lista;
	}
	
	
}
