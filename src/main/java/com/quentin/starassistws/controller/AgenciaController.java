package com.quentin.starassistws.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quentin.starassistws.restagencia.CrudAgenciaRequest;
import com.quentin.starassistws.restagencia.CrudAgenciaResponse;
import com.quentin.starassistws.restagencia.IniciarDatosAgenciaRequest;
import com.quentin.starassistws.restagencia.IniciarDatosAgenciaResponse;
import com.quentin.starassistws.restagencia.ListaAgenciaRequest;
import com.quentin.starassistws.restagencia.ListaAgenciaResponse;
import com.quentin.starassistws.restagencia.ListaCiudadPaisRequest;
import com.quentin.starassistws.restagencia.ListaCiudadPaisResponse;
import com.quentin.starassistws.restusuario.ListaUsuarioRequest;
import com.quentin.starassistws.restusuario.ListaUsuarioResponse;
import com.quentin.starassistws.servicio.ModuloService;
import com.quentin.starassistws.util.Utilitarios;

@Controller
@RequestMapping(value = "agencia")
public class AgenciaController {

	@Autowired
    private ModuloService moduloService;
	
	@RequestMapping(value = "listaAgencias",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ListaAgenciaResponse listaAgencias(@RequestBody ListaAgenciaRequest request, HttpServletRequest servletRequest){
	  	String ipAddress=Utilitarios.getClientIp(servletRequest); 	
	  	request.setNumeroip(ipAddress);
	  	return moduloService.listaAgencias(request); 
	}
	
	@RequestMapping(value = "iniciarDatosAgencia",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody IniciarDatosAgenciaResponse iniciarDatosAgencia(@RequestBody IniciarDatosAgenciaRequest request, HttpServletRequest servletRequest){
	  	String ipAddress=Utilitarios.getClientIp(servletRequest); 	
	  	request.setNumeroip(ipAddress);
	  	return moduloService.iniciarDatosAgencia(request); 
	}
	
	@RequestMapping(value = "listarCiudadXPais",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ListaCiudadPaisResponse listarCiudadXPais(@RequestBody ListaCiudadPaisRequest request, HttpServletRequest servletRequest){
	  	String ipAddress=Utilitarios.getClientIp(servletRequest); 	
	  	request.setNumeroip(ipAddress);
	  	return moduloService.listarCiudadXPais(request); 
	}
	
	@RequestMapping(value = "crudAgencia",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody CrudAgenciaResponse crudAgencia(@RequestBody CrudAgenciaRequest request, HttpServletRequest servletRequest){
	  	String ipAddress=Utilitarios.getClientIp(servletRequest); 	
	  	request.setNumeroip(ipAddress);
	  	return moduloService.crudAgencia(request); 
	}
	
	@RequestMapping(value = "habilitarAgencia",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody CrudAgenciaResponse habilitarAgencia(@RequestBody CrudAgenciaRequest request, HttpServletRequest servletRequest){
	  	String ipAddress=Utilitarios.getClientIp(servletRequest); 	
	  	request.setNumeroip(ipAddress);
	  	return moduloService.habilitarAgencia(request); 
	}
	
}
