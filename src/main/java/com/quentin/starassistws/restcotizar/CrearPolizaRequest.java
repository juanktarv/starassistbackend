package com.quentin.starassistws.restcotizar;

import java.util.ArrayList;
import java.util.List;

import com.quentin.starassistws.objetos.Destino;
import com.quentin.starassistws.objetos.DetallePasajero;
import com.quentin.starassistws.objetos.FechaViaje;
import com.quentin.starassistws.objetos.Origen;
import com.quentin.starassistws.objetos.PersonaContacto;
import com.quentin.starassistws.objetos.Plan;

public class CrearPolizaRequest {

	private Destino destinoSelec;
	private Origen origenSelec;
	private FechaViaje fechaSelec;
	private List<DetallePasajero> detallePasajero;
	private Plan planSeleccionado;
	private PersonaContacto personaContacto;
	private String[] pasajeros;
	private Integer tcodiusua;
	private String formaPago;
	private Integer cantidadPersonas;
	
	public CrearPolizaRequest() {
		this.destinoSelec=new Destino();
		this.origenSelec=new Origen();
		this.fechaSelec=new FechaViaje();
		this.detallePasajero=new ArrayList<>();
		this.personaContacto=new PersonaContacto();
		this.formaPago="";
		this.cantidadPersonas=0;
		this.planSeleccionado=new Plan();
	}
	
	public Destino getDestinoSelec() {
		return destinoSelec;
	}
	public void setDestinoSelec(Destino destinoSelec) {
		this.destinoSelec = destinoSelec;
	}
	public Origen getOrigenSelec() {
		return origenSelec;
	}
	public void setOrigenSelec(Origen origenSelec) {
		this.origenSelec = origenSelec;
	}
	public FechaViaje getFechaSelec() {
		return fechaSelec;
	}
	public void setFechaSelec(FechaViaje fechaSelec) {
		this.fechaSelec = fechaSelec;
	}
	public List<DetallePasajero> getDetallePasajero() {
		return detallePasajero;
	}
	public void setDetallePasajero(List<DetallePasajero> detallePasajero) {
		this.detallePasajero = detallePasajero;
	}
	public Plan getPlanSeleccionado() {
		return planSeleccionado;
	}
	public void setPlanSeleccionado(Plan planSeleccionado) {
		this.planSeleccionado = planSeleccionado;
	}
	public PersonaContacto getPersonaContacto() {
		return personaContacto;
	}
	public void setPersonaContacto(PersonaContacto personaContacto) {
		this.personaContacto = personaContacto;
	}
	public String[] getPasajeros() {
		return pasajeros;
	}
	public void setPasajeros(String[] pasajeros) {
		this.pasajeros = pasajeros;
	}
	public Integer getTcodiusua() {
		return tcodiusua;
	}
	public void setTcodiusua(Integer tcodiusua) {
		this.tcodiusua = tcodiusua;
	}
	public String getFormaPago() {
		return formaPago;
	}
	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}
	public Integer getCantidadPersonas() {
		return cantidadPersonas;
	}
	public void setCantidadPersonas(Integer cantidadPersonas) {
		this.cantidadPersonas = cantidadPersonas;
	}
	
	
}
