package com.quentin.starassistws.restusuario;

import com.quentin.starassistws.objetousuario.Usuario;

public class CrudUsuarioRequest {

	private Usuario usuario;
	private Integer idusuario;
	private String 	numeroip;
	private String tipo_operacion;
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Integer getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}
	public String getNumeroip() {
		return numeroip;
	}
	public void setNumeroip(String numeroip) {
		this.numeroip = numeroip;
	}
	public String getTipo_operacion() {
		return tipo_operacion;
	}
	public void setTipo_operacion(String tipo_operacion) {
		this.tipo_operacion = tipo_operacion;
	}
	
	
}
