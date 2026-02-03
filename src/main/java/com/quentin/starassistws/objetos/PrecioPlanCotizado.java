package com.quentin.starassistws.objetos;

public class PrecioPlanCotizado {

	private Integer id_precio;
	private Integer id_plan;
	private String nombre_plan;
	private Double precio_total;
	private String simbolo_moneda;
	private String descripcion_cobertura;
	private String imagen;
	private Double valor_descuento;
	private String nombre_destino;
	
	
	public Integer getId_plan() {
		return id_plan;
	}
	public void setId_plan(Integer id_plan) {
		this.id_plan = id_plan;
	}
	public Integer getId_precio() {
		return id_precio;
	}
	public void setId_precio(Integer id_precio) {
		this.id_precio = id_precio;
	}
	public String getNombre_plan() {
		return nombre_plan;
	}
	public void setNombre_plan(String nombre_plan) {
		this.nombre_plan = nombre_plan;
	}
	public Double getPrecio_total() {
		return precio_total;
	}
	public void setPrecio_total(Double precio_total) {
		this.precio_total = precio_total;
	}
	public String getSimbolo_moneda() {
		return simbolo_moneda;
	}
	public void setSimbolo_moneda(String simbolo_moneda) {
		this.simbolo_moneda = simbolo_moneda;
	}
	public String getDescripcion_cobertura() {
		return descripcion_cobertura;
	}
	public void setDescripcion_cobertura(String descripcion_cobertura) {
		this.descripcion_cobertura = descripcion_cobertura;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public Double getValor_descuento() {
		return valor_descuento;
	}
	public void setValor_descuento(Double valor_descuento) {
		this.valor_descuento = valor_descuento;
	}
	public String getNombre_destino() {
		return nombre_destino;
	}
	public void setNombre_destino(String nombre_destino) {
		this.nombre_destino = nombre_destino;
	}
	
	
	
}
