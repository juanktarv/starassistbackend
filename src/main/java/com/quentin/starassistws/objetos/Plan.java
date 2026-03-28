package com.quentin.starassistws.objetos;

public class Plan {
	
	private String nombre_plan;
	private Integer id_plan;
	private Integer id_precio;
	private String nombre_destino;
	private String simbolo_moneda;
	private Double precio_total;
	private Double precio_total_dolares;
	private Double valor_descuento;
	private String imagen;
	private String descripcion_cobertura;
	private Double tipo_cambio;
	private Integer id_tipo_cambio;
	
	public Plan() {
		this.nombre_plan="";
		this.id_plan=0;
		this.id_precio=0;
		this.nombre_destino="";
		this.simbolo_moneda="";
		this.precio_total=0.0;
		this.precio_total_dolares=0.0;
		this.valor_descuento=0.0;
		this.imagen="";
		this.descripcion_cobertura="";
		this.tipo_cambio=0.0;
		this.id_tipo_cambio=0;
	}
	
	public String getNombre_plan() {
		return nombre_plan;
	}
	public void setNombre_plan(String nombre_plan) {
		this.nombre_plan = nombre_plan;
	}
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
	public String getNombre_destino() {
		return nombre_destino;
	}
	public void setNombre_destino(String nombre_destino) {
		this.nombre_destino = nombre_destino;
	}
	public String getSimbolo_moneda() {
		return simbolo_moneda;
	}
	public void setSimbolo_moneda(String simbolo_moneda) {
		this.simbolo_moneda = simbolo_moneda;
	}
	public Double getPrecio_total() {
		return precio_total;
	}
	public void setPrecio_total(Double precio_total) {
		this.precio_total = precio_total;
	}
	public Double getValor_descuento() {
		return valor_descuento;
	}
	public void setValor_descuento(Double valor_descuento) {
		this.valor_descuento = valor_descuento;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getDescripcion_cobertura() {
		return descripcion_cobertura;
	}
	public void setDescripcion_cobertura(String descripcion_cobertura) {
		this.descripcion_cobertura = descripcion_cobertura;
	}
	public Double getTipo_cambio() {
		return tipo_cambio;
	}
	public void setTipo_cambio(Double tipo_cambio) {
		this.tipo_cambio = tipo_cambio;
	}
	public Integer getId_tipo_cambio() {
		return id_tipo_cambio;
	}
	public void setId_tipo_cambio(Integer id_tipo_cambio) {
		this.id_tipo_cambio = id_tipo_cambio;
	}
	public Double getPrecio_total_dolares() {
		return precio_total_dolares;
	}
	public void setPrecio_total_dolares(Double precio_total_dolares) {
		this.precio_total_dolares = precio_total_dolares;
	}
	
	

}
