package com.quentin.starassistws.restcombo;

public class PaisOrigenRequest {

	private String numeroip;
	private Integer id_pais;
	private Integer id_usuario;
	
	public PaisOrigenRequest() {
		this.id_pais=0;
		this.id_usuario=0;
		this.numeroip="";
	}
	
	public String getNumeroip() {
		return numeroip;
	}

	public void setNumeroip(String numeroip) {
		this.numeroip = numeroip;
	}

	public Integer getId_pais() {
		return id_pais;
	}

	public void setId_pais(Integer id_pais) {
		this.id_pais = id_pais;
	}

	public Integer getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}
	
	
}
