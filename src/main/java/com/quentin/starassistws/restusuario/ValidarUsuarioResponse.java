package com.quentin.starassistws.restusuario;

import com.quentin.starassistws.objetousuario.Usuario;

public class ValidarUsuarioResponse {

	private String error;
	private String aviso;
	private Usuario usuario;

	
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
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
	
}
