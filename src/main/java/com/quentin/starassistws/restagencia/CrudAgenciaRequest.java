package com.quentin.starassistws.restagencia;

import com.quentin.startassistws.objetoagencia.Agencia;

public class CrudAgenciaRequest {	
	
	private Agencia agencia;
	private String tipo_operacion;
	private Integer idusuario;
	private String 	numeroip;
	
	public CrudAgenciaRequest() {
		this.agencia=new Agencia();
	}
	
	public Agencia getAgencia() {
		return agencia;
	}
	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}
	public String getTipo_operacion() {
		return tipo_operacion;
	}
	public void setTipo_operacion(String tipo_operacion) {
		this.tipo_operacion = tipo_operacion;
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
	
	
}
