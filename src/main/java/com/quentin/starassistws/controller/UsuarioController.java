package com.quentin.starassistws.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quentin.starassistws.objetos.CotizarRequest;
import com.quentin.starassistws.objetos.CotizarResponse;
import com.quentin.starassistws.restagencia.CrudAgenciaRequest;
import com.quentin.starassistws.restusuario.CrudUsuarioRequest;
import com.quentin.starassistws.restusuario.CrudUsuarioResponse;
import com.quentin.starassistws.restusuario.ListaUsuarioRequest;
import com.quentin.starassistws.restusuario.ListaUsuarioResponse;
import com.quentin.starassistws.restusuario.ValidarUsuarioRequest;
import com.quentin.starassistws.restusuario.ValidarUsuarioResponse;
import com.quentin.starassistws.servicio.ModuloService;
import com.quentin.starassistws.util.Utilitarios;

@Controller
@RequestMapping(value = "usuario")
public class UsuarioController {

    @Autowired
    private ModuloService moduloService;
    
    
    @RequestMapping(value = "cotizar",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody CotizarResponse cotizar(@RequestBody CotizarRequest request, HttpServletRequest servletRequest){
    	//String ipAddress=getClientIp(servletRequest); 	
    	//request.setIpusuario(ipAddress);
    	return moduloService.cotizar(request);
    }
    
    @RequestMapping(value = "validarUsuario",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody ValidarUsuarioResponse validarUsuario(@RequestBody ValidarUsuarioRequest request, HttpServletRequest servletRequest){
    	String ipAddress=Utilitarios.getClientIp(servletRequest); 	
    	request.setIp(ipAddress);
    	return moduloService.validarUsuario(request);
    }
    
	  @RequestMapping(value = "listaUsuarios",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	  public @ResponseBody ListaUsuarioResponse listaUsuarios(@RequestBody ListaUsuarioRequest request, HttpServletRequest servletRequest){
	  	String ipAddress=Utilitarios.getClientIp(servletRequest); 	
	  	request.setNumeroip(ipAddress);
	  	return moduloService.listaUsuarios(request); 
	  }
  
	  @RequestMapping(value = "crudUsuario",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	  public @ResponseBody CrudUsuarioResponse crudUsuario(@RequestBody CrudUsuarioRequest request, HttpServletRequest servletRequest){
	  	String ipAddress=Utilitarios.getClientIp(servletRequest); 	
	  	request.setNumeroip(ipAddress);
	  	return moduloService.crudUsuario(request); 
	  }
    
	  @RequestMapping(value = "habilitarUsuario",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	  public @ResponseBody CrudUsuarioResponse habilitarUsuario(@RequestBody CrudUsuarioRequest request, HttpServletRequest servletRequest){
	  	String ipAddress=Utilitarios.getClientIp(servletRequest); 	
	  	request.setNumeroip(ipAddress);
	  	return moduloService.habilitarUsuario(request); 
	  }
    
}
