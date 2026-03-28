package com.quentin.starassistws.objetos;

import java.util.Date;

public class FechaViaje {
	
	private Date fecha_inicio;
	private Date fecha_fin;
	private Integer dias_cobertura;
	private String fecha_inicio_str;
	private String fecha_fin_str;
	public Date getFecha_inicio() {
		return fecha_inicio;
	}
	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public Date getFecha_fin() {
		return fecha_fin;
	}
	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	public Integer getDias_cobertura() {
		return dias_cobertura;
	}
	public void setDias_cobertura(Integer dias_cobertura) {
		this.dias_cobertura = dias_cobertura;
	}
	public String getFecha_inicio_str() {
		return fecha_inicio_str;
	}
	public void setFecha_inicio_str(String fecha_inicio_str) {
		this.fecha_inicio_str = fecha_inicio_str;
	}
	public String getFecha_fin_str() {
		return fecha_fin_str;
	}
	public void setFecha_fin_str(String fecha_fin_str) {
		this.fecha_fin_str = fecha_fin_str;
	}
	
	

}
