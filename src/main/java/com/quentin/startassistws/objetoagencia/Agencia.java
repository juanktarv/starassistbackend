package com.quentin.startassistws.objetoagencia;

public class Agencia implements java.io.Serializable {

	
private static final long serialVersionUID = 1L;
	
	private Integer id_agencia;
	private Integer id_pais;
	private Integer id_ciudad;
	private String razon_social;
	private String nit;
	private String direccion;
	private String telefono;
	private String rnt;
	private String email;
	private String persona_referencia;
	private String estado;
	private Double porcentaje_descuento;
	private String codigo_descuento;

	private String des_pais;
	private String des_ciudad;
	private Integer habilitado;
	
	public Agencia() {
		this.id_agencia=0;
		this.id_pais=0;
		this.id_ciudad=0;
		this.porcentaje_descuento=0.0;
	}
	
	public Integer getId_agencia() {
		return id_agencia;
	}
	
	public void setId_agencia(Integer id_agencia) {
		this.id_agencia = id_agencia;
	}
	
	public Integer getId_pais() {
		return id_pais;
	}
	
	public void setId_pais(Integer id_pais) {
		this.id_pais = id_pais;
	}
	
	public Integer getId_ciudad() {
		return id_ciudad;
	}
	
	public void setId_ciudad(Integer id_ciudad) {
		this.id_ciudad = id_ciudad;
	}
	
	public String getRazon_social() {
		return razon_social;
	}
	
	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}
	
	public String getNit() {
		return nit;
	}
	
	public void setNit(String nit) {
		this.nit = nit;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getRnt() {
		return rnt;
	}
	
	public void setRnt(String rnt) {
		this.rnt = rnt;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPersona_referencia() {
		return persona_referencia;
	}
	
	public void setPersona_referencia(String persona_referencia) {
		this.persona_referencia = persona_referencia;
	}

	public String getDes_pais() {
		return des_pais;
	}

	public void setDes_pais(String des_pais) {
		this.des_pais = des_pais;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Double getPorcentaje_descuento() {
		return porcentaje_descuento;
	}

	public void setPorcentaje_descuento(Double porcentaje_descuento) {
		this.porcentaje_descuento = porcentaje_descuento;
	}

	public String getCodigo_descuento() {
		return codigo_descuento;
	}

	public void setCodigo_descuento(String codigo_descuento) {
		this.codigo_descuento = codigo_descuento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getDes_ciudad() {
		return des_ciudad;
	}

	public void setDes_ciudad(String des_ciudad) {
		this.des_ciudad = des_ciudad;
	}

	public Integer getHabilitado() {
		return habilitado;
	}

	public void setHabilitado(Integer habilitado) {
		this.habilitado = habilitado;
	}			
	
	
}
