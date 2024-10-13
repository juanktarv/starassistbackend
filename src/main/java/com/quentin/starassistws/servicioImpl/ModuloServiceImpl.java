package com.quentin.starassistws.servicioImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quentin.starassistws.dao.ModuloDAO;
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
import com.quentin.starassistws.servicio.ModuloService;

@Service
public class ModuloServiceImpl implements ModuloService{
	
    @Autowired
    private ModuloDAO moduloDAO;

	@Override
	public CotizarResponse cotizar(CotizarRequest request) {
		// TODO Auto-generated method stub
		return moduloDAO.cotizar(request);
	}

	@Override
	public ValidarUsuarioResponse validarUsuario(ValidarUsuarioRequest request) {
		// TODO Auto-generated method stub
		return moduloDAO.validarUsuario(request);
	}

	@Override
	public ListaUsuarioResponse listaUsuarios(ListaUsuarioRequest request) {
		// TODO Auto-generated method stub
		return moduloDAO.listaUsuarios(request);
	}

	@Override
	public ListaAgenciaResponse listaAgencias(ListaAgenciaRequest request) {
		// TODO Auto-generated method stub
		return moduloDAO.listaAgencias(request);
	}

	@Override
	public IniciarDatosAgenciaResponse iniciarDatosAgencia(IniciarDatosAgenciaRequest request) {
		// TODO Auto-generated method stub
		return moduloDAO.iniciarDatosAgencia(request);
	}

	@Override
	public ListaCiudadPaisResponse listarCiudadXPais(ListaCiudadPaisRequest request) {
		// TODO Auto-generated method stub
		return moduloDAO.listarCiudadXPais(request);
	}

	@Override
	public CrudAgenciaResponse crudAgencia(CrudAgenciaRequest request) {
		// TODO Auto-generated method stub
		return moduloDAO.crudAgencia(request);
	}

	@Override
	public CrudUsuarioResponse crudUsuario(CrudUsuarioRequest request) {
		// TODO Auto-generated method stub
		return moduloDAO.crudUsuario(request);
	}


	@Override
	public CrudAgenciaResponse habilitarAgencia(CrudAgenciaRequest request) {
		// TODO Auto-generated method stub
		return moduloDAO.habilitarAgencia(request);
	}

	@Override
	public CrudUsuarioResponse habilitarUsuario(CrudUsuarioRequest request) {
		// TODO Auto-generated method stub
		return moduloDAO.habilitarUsuario(request);
	}
	

}

