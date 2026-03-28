package com.quentin.starassistws.objetos;

public class PrecioPlanCotizado {

	private Integer id_precio;
	private Integer id_plan;
	private String nombre_plan;
	private Double precio_total;
	private Double precio_total_dolares;
	private Double tipo_cambio;
	private Integer id_tipo_cambio;
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
	public Double getPrecio_total_dolares() {
		return precio_total_dolares;
	}
	public void setPrecio_total_dolares(Double precio_total_dolares) {
		this.precio_total_dolares = precio_total_dolares;
	}
	public Double getTipo_cambio() {
		return tipo_cambio;
	}
	public void setTipo_cambio(Double titpo_cambio) {
		this.tipo_cambio = titpo_cambio;
	}
	public Integer getId_tipo_cambio() {
		return id_tipo_cambio;
	}
	public void setId_tipo_cambio(Integer id_tipo_cambio) {
		this.id_tipo_cambio = id_tipo_cambio;
	}
	
	
	
}
