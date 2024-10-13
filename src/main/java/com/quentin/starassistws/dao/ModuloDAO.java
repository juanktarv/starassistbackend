package com.quentin.starassistws.dao;

import java.util.List;

import com.quentin.starassistws.objetos.CotizarRequest;
import com.quentin.starassistws.objetos.CotizarResponse;
import com.quentin.starassistws.restagencia.CrudAgenciaRequest;
import com.quentin.starassistws.restagencia.CrudAgenciaResponse;
import com.quentin.starassistws.restagencia.IniciarDatosAgenciaRequest;
import com.quentin.starassistws.restagencia.IniciarDatosAgenciaResponse;
import com.quentin.starassistws.restagencia.ListaAgenciaRequest;
import com.quentin.starassistws.restagencia.ListaAgenciaResponse;
import com.quentin.starassistws.restagencia.ListaCiudadPaisRequest;
import com.quentin.starassistws.restagencia.ListaCiudadPaisResponse;
import com.quentin.starassistws.restusuario.CrudUsuarioRequest;
import com.quentin.starassistws.restusuario.CrudUsuarioResponse;
import com.quentin.starassistws.restusuario.ListaUsuarioRequest;
import com.quentin.starassistws.restusuario.ListaUsuarioResponse;
import com.quentin.starassistws.restusuario.ValidarUsuarioRequest;
import com.quentin.starassistws.restusuario.ValidarUsuarioResponse;


public interface ModuloDAO {

//	UsuarioResponse buscarPorLoginClave(UsuarioRequest request);
	CotizarResponse cotizar(CotizarRequest request);
	ValidarUsuarioResponse validarUsuario(ValidarUsuarioRequest request);
	ListaUsuarioResponse listaUsuarios(ListaUsuarioRequest request);
	CrudUsuarioResponse crudUsuario(CrudUsuarioRequest request);
	CrudUsuarioResponse habilitarUsuario(CrudUsuarioRequest request);
	
	//AGENCIA
	ListaAgenciaResponse listaAgencias(ListaAgenciaRequest request);
	IniciarDatosAgenciaResponse iniciarDatosAgencia(IniciarDatosAgenciaRequest request);
	ListaCiudadPaisResponse listarCiudadXPais(ListaCiudadPaisRequest request);
	CrudAgenciaResponse crudAgencia(CrudAgenciaRequest request);
	CrudAgenciaResponse habilitarAgencia(CrudAgenciaRequest request);
}