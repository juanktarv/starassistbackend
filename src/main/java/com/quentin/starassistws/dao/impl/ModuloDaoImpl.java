package com.quentin.starassistws.dao.impl;


import java.math.BigDecimal;
import java.sql.CallableStatement;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Repository;

import com.quentin.starassistws.dao.ModuloDAO;
import com.quentin.starassistws.dao.SimpleJdbcDao;
import com.quentin.starassistws.objetos.CotizarRequest;
import com.quentin.starassistws.objetos.CotizarResponse;
import com.quentin.starassistws.objetos.ParametroCorreo;
import com.quentin.starassistws.objetos.PasajeroError;
import com.quentin.starassistws.objetos.PrecioPlanCotizado;
import com.quentin.starassistws.objetousuario.Usuario;
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
import com.quentin.starassistws.util.Constante;
import com.quentin.starassistws.util.EnvioCorreo;
import com.quentin.startassistws.objetoagencia.Agencia;
import com.quentin.startassistws.objetoagencia.Ciudad;
import com.quentin.startassistws.objetoagencia.Pais;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.JDBCType;

@Repository
public class ModuloDaoImpl extends SimpleJdbcDao implements ModuloDAO{
	
	
	@Override
	public ValidarUsuarioResponse validarUsuario (ValidarUsuarioRequest request) {
		ValidarUsuarioResponse rpta= new ValidarUsuarioResponse();
		Connection cn= null;	
		CallableStatement cs = null;
		Usuario usuario= new Usuario();
		
		try {
			
//			System.out.println("login:"+request.getLogin()+" password:"+request.getPassword());
			
			cn=jdbcTemplate.getDataSource().getConnection();
			cn.setAutoCommit(false);
			cs = cn.prepareCall("{call buscarporloginclave(?,?,?,?,?)}");
			
			cs.setString(1, request.getLogin());
			cs.setString(2, request.getPassword());
			cs.registerOutParameter(3, java.sql.Types.REF_CURSOR);
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.VARCHAR);
			
			cs.execute();
			
			if(cs.getString(4)!=null){
				rpta.setAviso(cs.getString(4));
			}
			
			if(cs.getString(5)!=null){
				rpta.setError(cs.getString(5));
			} else{
				
				ResultSet rs = (ResultSet) cs.getObject(3);
				if(rs!=null) {
					while (rs.next()) {
						usuario.setIdusuario(rs.getInt("idusuario"));
						usuario.setNombre(rs.getString("nombre"));
						usuario.setApellido_paterno(rs.getString("apellido_paterno"));
						usuario.setApellido_materno(rs.getString("apellido_materno"));
						usuario.setDni(rs.getString("dni"));
						usuario.setEmail(rs.getString("email"));
					}
					
				}
			}
			
			rpta.setUsuario(usuario);
			
		}catch (Exception e) {
			e.printStackTrace();
			rpta.setError("Error login : "+e.getMessage());
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
            	rpta.setError("Error cerrando conexion login : "+e.getMessage());
            }
        }
		return rpta;
	}
	
	@Override
	public ListaUsuarioResponse listaUsuarios (ListaUsuarioRequest request) {
		ListaUsuarioResponse rpta= new ListaUsuarioResponse();
		Connection cn= null;	
		CallableStatement cs = null;
		
		List<Usuario>lista=new ArrayList<Usuario>();
		
		try {
			
//			System.out.println("idusuario:"+request.getIdusuario());
			
			cn=jdbcTemplate.getDataSource().getConnection();
			cn.setAutoCommit(false);
			cs = cn.prepareCall("{call listausuarios(?,?,?,?,?)}");
			
			
			
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, java.sql.Types.REF_CURSOR);
			
			cs.setInt(4, request.getIdusuario());
			cs.setString(5, request.getNumeroip());
			
			cs.execute();
			
			if(cs.getString(1)!=null){
				rpta.setAviso(cs.getString(1));
			}
			
			if(cs.getString(2)!=null){
				rpta.setError(cs.getString(2));
			} else{
				
				ResultSet rs = (ResultSet) cs.getObject(3);
				if(rs!=null) {
					while (rs.next()) {
						Usuario usuario=new Usuario();
//						System.out.println( "direccion: "+rs.getString("direccion"));
						usuario.setIdusuario(rs.getInt("idusuario"));
						usuario.setNombre(rs.getString("nombre"));
						usuario.setApellido_paterno(rs.getString("apellido_paterno"));
						usuario.setApellido_materno(rs.getString("apellido_materno"));
						usuario.setDni(rs.getString("dni"));
						usuario.setEmail(rs.getString("email"));
						usuario.setFecha_registro(rs.getString("fecha_registro"));
						usuario.setLogin(rs.getString("login"));
						usuario.setPassword(rs.getString("password"));
						usuario.setTelefono(rs.getString("telefono"));
						usuario.setId_agencia(rs.getInt("id_agencia"));
						usuario.setDireccion(rs.getString("direccion"));
						usuario.setDesc_agencia(rs.getString("desc_agencia")==null?"":rs.getString("desc_agencia"));
						usuario.setHabilitado(rs.getInt("habilitado"));
						
						lista.add(usuario);
					}
					
				}
			}
			
			rpta.setLista(lista);
			
		}catch (Exception e) {
			e.printStackTrace();
			rpta.setError("Error login : "+e.getMessage());
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
            	rpta.setError("Error cerrando conexion login : "+e.getMessage());
            }
        }
		return rpta;
	}
	
	@Override
	public CotizarResponse cotizar(CotizarRequest request) {
		CotizarResponse rpta= new CotizarResponse();
		Connection cn= null;	
		CallableStatement cs = null;
		
		List<PasajeroError> listaErrorEdad=new ArrayList<>();
		List<PrecioPlanCotizado> lista=new ArrayList<>();
		try {
			cn=jdbcTemplate.getDataSource().getConnection();
			cn.setAutoCommit(false);
			
			// Crear tabla temporal
			Statement stmt = cn.createStatement();
			stmt.execute("CREATE TEMPORARY TABLE t_polizapasatemp (tedadpasa INTEGER, tsecupasa INTEGER)");

			stmt.execute("CREATE TEMPORARY TABLE t_precioplantemp (id_precio INTEGER, id_plan INTEGER, monto NUMERIC)");
			
			Statement statement = cn.createStatement();			
			String []listaPasajero=request.getTlistpasa().split(",");
			for(int i=0; i<listaPasajero.length; i++) {
				int edad=Integer.parseInt(listaPasajero[i]);
				String sql="insert into t_polizapasatemp(tedadpasa,tsecupasa) values ("+edad+","+(i+1)+")";
//				System.out.println( " slq =====>"+sql);
				statement.addBatch(sql);
			}
			statement.executeBatch();
			statement.close();
			
			
			
			cs = cn.prepareCall("{ call cotizar(?,?,?,?,?,"
											 + "?,?,?,?,?,"
											 + "?,?,?)}");
			

			
			
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.REF_CURSOR);//lista
			cs.registerOutParameter(4, Types.REF_CURSOR);//listaErrorEdad
			cs.registerOutParameter(5, Types.INTEGER);
			cs.setInt(6, request.getTcodiusua());
			cs.setInt(7, request.getTcantviaj());
			cs.setString(8, request.getTnumetele());
			cs.setInt(9, request.getTcantdias());
			cs.setString(10, request.getTcorrviaj());
			cs.setInt(11, request.getTiddestin());
			cs.setInt(12, request.getTidorigen());
			cs.setInt(13, request.getThabimult());
			
			cs.execute();
			
			if(cs.getString(1)!=null){
				rpta.setAviso(cs.getString(1));
			}
			
			if(cs.getString(2)!=null){
				rpta.setError(cs.getString(2));
			} else{
				
				ResultSet rs = (ResultSet) cs.getObject(3);
				if(rs!=null) {
					while (rs.next()) {
						PrecioPlanCotizado obj=new PrecioPlanCotizado();
						obj.setId_plan(rs.getInt("id_plan"));
						obj.setId_precio(rs.getInt("id_precio"));
						obj.setMonto(rs.getDouble("monto"));
						lista.add(obj);
						
					}
					
				}
				
				rs = (ResultSet) cs.getObject(4);
				if(rs!=null) {
					while (rs.next()) {
						PasajeroError obj=new PasajeroError();
						obj.setTedadpasa(rs.getInt("tedadpasa"));
						obj.setTmenserro(rs.getString("tmenserro"));
						obj.setTsecupasa(rs.getInt("tsecupasa"));
						listaErrorEdad.add(obj);
						
					}
					
				}
			}
			
			rpta.setLista(lista);
			rpta.setListaErrorEdad(listaErrorEdad);
			
		}catch (Exception e) {
			e.printStackTrace();
			rpta.setError("Error cotizar : "+e.getMessage());
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
            	rpta.setError("Error cerrando conexion cotizar : "+e.getMessage());
            }
        }
		return rpta;
	}

	@Override
	public ListaAgenciaResponse listaAgencias(ListaAgenciaRequest request) {
		// TODO Auto-generated method stub
		ListaAgenciaResponse rpta= new ListaAgenciaResponse();
		Connection cn= null;	
		CallableStatement cs = null;
		
		List<Agencia>lista=new ArrayList<Agencia>();
		
		try {
			cn=jdbcTemplate.getDataSource().getConnection();
			cn.setAutoCommit(false);
			cs = cn.prepareCall("{call listaagencias(?,?,?,?,?)}");
			
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, java.sql.Types.REF_CURSOR);
			
			cs.setInt(4, request.getIdusuario());
			cs.setString(5, request.getNumeroip());
			
			cs.execute();
			
			if(cs.getString(1)!=null){
				rpta.setAviso(cs.getString(1));
			}
			
			if(cs.getString(2)!=null){
				rpta.setError(cs.getString(2));
			} else{
				
				ResultSet rs = (ResultSet) cs.getObject(3);
				if(rs!=null) {
					while (rs.next()) {
						Agencia obj=new Agencia();
						obj.setId_agencia(rs.getInt("id_agencia"));
						obj.setId_pais(rs.getInt("id_pais"));
						obj.setId_ciudad(rs.getInt("id_ciudad"));
						obj.setRazon_social(rs.getString("razon_social"));
						obj.setNit(rs.getString("nit"));
						obj.setDireccion(rs.getString("direccion"));
						obj.setTelefono(rs.getString("telefono"));
						obj.setRnt(rs.getString("rnt"));
						obj.setEmail(rs.getString("email"));
						obj.setPersona_referencia(rs.getString("persona_referencia"));
						obj.setEstado(rs.getString("estado"));
						obj.setCodigo_descuento(rs.getString("codigo_descuento"));
						obj.setPorcentaje_descuento(rs.getDouble("porcentaje_descuento"));
						obj.setDes_pais(rs.getString("des_pais"));
						obj.setDes_ciudad(rs.getString("des_ciudad"));
						obj.setHabilitado(rs.getInt("habilitado"));
						lista.add(obj);
					}
					
				}
			}
			
			rpta.setLista(lista);
			
		}catch (Exception e) {
			e.printStackTrace();
			rpta.setError("Error listaAgencias : "+e.getMessage());
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
            	rpta.setError("Error cerrando conexion listaAgencias : "+e.getMessage());
            }
        }
		return rpta;
	}

	@Override
	public IniciarDatosAgenciaResponse iniciarDatosAgencia(IniciarDatosAgenciaRequest request) {
		// TODO Auto-generated method stub
		IniciarDatosAgenciaResponse rpta= new IniciarDatosAgenciaResponse();
		Connection cn= null;	
		CallableStatement cs = null;
		
		List<Pais>lista=new ArrayList<Pais>();
		
		try {
			
			cn=jdbcTemplate.getDataSource().getConnection();
			cn.setAutoCommit(false);
			cs = cn.prepareCall("{call inicdataagen(?,?,?,?,?)}");
			
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, java.sql.Types.REF_CURSOR);
			cs.setInt(4, request.getIdusuario());
			cs.setString(5, request.getNumeroip());
			
			cs.execute();
			
			if(cs.getString(1)!=null){
				rpta.setAviso(cs.getString(1));
			}
			
			if(cs.getString(2)!=null){
				rpta.setError(cs.getString(2));
			} else{
				
				ResultSet rs = (ResultSet) cs.getObject(3);
				if(rs!=null) {
					while (rs.next()) {
						Pais obj=new Pais();
						obj.setCode_image(rs.getString("code_image"));
						obj.setCodigo_postal(rs.getString("codigo_postal"));
						obj.setContinente(rs.getString("continente"));
						obj.setId_pais(rs.getInt("id_pais"));
						obj.setNombre(rs.getString("nombre"));
						lista.add(obj);
					}
					
				}
			}
			
			rpta.setListaPais(lista);
			
		}catch (Exception e) {
			e.printStackTrace();
			rpta.setError("Error iniciarDatosAgencia : "+e.getMessage());
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
            	rpta.setError("Error cerrando conexion iniciarDatosAgencia : "+e.getMessage());
            }
        }
		return rpta;
	}

	@Override
	public ListaCiudadPaisResponse listarCiudadXPais(ListaCiudadPaisRequest request) {
		// TODO Auto-generated method stub
		ListaCiudadPaisResponse rpta= new ListaCiudadPaisResponse();
		Connection cn= null;	
		CallableStatement cs = null;
		
		List<Ciudad>lista=new ArrayList<Ciudad>();
		
		try {
			
//			System.out.println("idusuario:"+request.getIdusuario());
			
			cn=jdbcTemplate.getDataSource().getConnection();
			cn.setAutoCommit(false);
			cs = cn.prepareCall("{call listciudxpais(?,?,?,?,?,"
												  + "?)}");
			
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, java.sql.Types.REF_CURSOR);
			
			cs.setInt(4, request.getIdusuario());
			cs.setString(5, request.getNumeroip());
			cs.setInt(6, request.getId_pais());
			
			cs.execute();
			
			if(cs.getString(1)!=null){
				rpta.setAviso(cs.getString(1));
			}
			
			if(cs.getString(2)!=null){
				rpta.setError(cs.getString(2));
			} else{
				
				ResultSet rs = (ResultSet) cs.getObject(3);
				if(rs!=null) {
					while (rs.next()) {
						Ciudad obj=new Ciudad();
						obj.setId_ciudad(rs.getInt("id_ciudad"));
						obj.setId_pais(rs.getInt("id_pais"));
						obj.setNombre(rs.getString("nombre"));
						lista.add(obj);
					}
					
				}
			}
			
			rpta.setListaCiudad(lista);
			
		}catch (Exception e) {
			e.printStackTrace();
			rpta.setError("Error listarCiudadXPais : "+e.getMessage());
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
            	rpta.setError("Error cerrando conexion listarCiudadXPais : "+e.getMessage());
            }
        }
		return rpta;
	}

	@Override
	public CrudAgenciaResponse crudAgencia(CrudAgenciaRequest request) {
		// TODO Auto-generated method stub
		CrudAgenciaResponse rpta= new CrudAgenciaResponse();
		Connection cn= null;	
		CallableStatement cs = null;
		
		
		try {
			
//			System.out.println("idusuario:"+request.getIdusuario());
//			System.out.println("id_pais:"+request.getAgencia().getId_pais());
			
			cn=jdbcTemplate.getDataSource().getConnection();
			//cn.setAutoCommit(false);
			cs = cn.prepareCall("{call crud_agencia("
												  +"?,?,?,?,?,"
												  +"?,?,?,?,?,"
												  +"?,?,?,?,?,"
												  +"?,?,?,?"
												+ ")}");
			
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.INTEGER);
			
			cs.setInt(4, request.getIdusuario());
			cs.setString(5, request.getNumeroip());
			cs.setInt(6, request.getAgencia()==null?0:request.getAgencia().getId_pais());
			cs.setInt(7, request.getAgencia()==null?0:request.getAgencia().getId_ciudad());
			cs.setString(8, request.getAgencia().getRazon_social());
			cs.setString(9, request.getAgencia().getNit()==null?"":request.getAgencia().getNit());
			cs.setString(10, request.getAgencia().getDireccion()==null?"":request.getAgencia().getDireccion());
			cs.setString(11, request.getAgencia().getTelefono()==null?"":request.getAgencia().getTelefono());
			cs.setString(12, request.getAgencia().getRnt()==null?"":request.getAgencia().getRnt());
			cs.setString(13, request.getAgencia().getEmail()==null?"":request.getAgencia().getEmail());
			cs.setString(14, request.getAgencia().getPersona_referencia()==null?"":request.getAgencia().getPersona_referencia());
			cs.setString(15, request.getAgencia().getEstado()==null?"":request.getAgencia().getEstado());
			cs.setString(16, request.getAgencia().getCodigo_descuento()==null?"": request.getAgencia().getCodigo_descuento());
			cs.setDouble(17, request.getAgencia().getPorcentaje_descuento()==null?0:request.getAgencia().getPorcentaje_descuento());
			cs.setInt(18, request.getAgencia().getId_agencia());
			cs.setString(19, request.getTipo_operacion()==null?"":request.getTipo_operacion());
			
			cs.execute();
			
			if(cs.getString(1)!=null){
				rpta.setAviso(cs.getString(1));
			}
			
			if(cs.getString(2)!=null){
				rpta.setError(cs.getString(2));
			}
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
			rpta.setError("Error crudAgencia : "+e.getMessage());
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
            	rpta.setError("Error cerrando conexion crudAgencia : "+e.getMessage());
            }
        }
		return rpta;
	}
	
	@Override
	public CrudAgenciaResponse habilitarAgencia(CrudAgenciaRequest request) {
		// TODO Auto-generated method stub
		CrudAgenciaResponse rpta= new CrudAgenciaResponse();
		Connection cn= null;	
		CallableStatement cs = null;
		
		
		try {
			
			cn=jdbcTemplate.getDataSource().getConnection();
			cs = cn.prepareCall("{call habilitar_agencia("
												  +"?,?,?,?,?,"
												  +"?,?,?,?,?,"
												  +"?,?,?,?,?,"
												  +"?,?,?,?"
												+ ")}");
			
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.INTEGER);
			
			cs.setInt(4, request.getIdusuario());
			cs.setString(5, request.getNumeroip());
			cs.setInt(6, request.getAgencia()==null?0:request.getAgencia().getId_pais());
			cs.setInt(7, request.getAgencia()==null?0:request.getAgencia().getId_ciudad());
			cs.setString(8, request.getAgencia().getRazon_social());
			cs.setString(9, request.getAgencia().getNit()==null?"":request.getAgencia().getNit());
			cs.setString(10, request.getAgencia().getDireccion()==null?"":request.getAgencia().getDireccion());
			cs.setString(11, request.getAgencia().getTelefono()==null?"":request.getAgencia().getTelefono());
			cs.setString(12, request.getAgencia().getRnt()==null?"":request.getAgencia().getRnt());
			cs.setString(13, request.getAgencia().getEmail()==null?"":request.getAgencia().getEmail());
			cs.setString(14, request.getAgencia().getPersona_referencia()==null?"":request.getAgencia().getPersona_referencia());
			cs.setString(15, request.getAgencia().getEstado()==null?"":request.getAgencia().getEstado());
			cs.setString(16, request.getAgencia().getCodigo_descuento()==null?"": request.getAgencia().getCodigo_descuento());
			cs.setDouble(17, request.getAgencia().getPorcentaje_descuento()==null?0:request.getAgencia().getPorcentaje_descuento());
			cs.setInt(18, request.getAgencia().getId_agencia());
			cs.setString(19, request.getTipo_operacion()==null?"":request.getTipo_operacion());
			
			cs.execute();
			
			if(cs.getString(1)!=null){
				rpta.setAviso(cs.getString(1));
			}
			
			if(cs.getString(2)!=null){
				rpta.setError(cs.getString(2));
			}
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
			rpta.setError("Error crudAgencia : "+e.getMessage());
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
            	rpta.setError("Error cerrando conexion crudAgencia : "+e.getMessage());
            }
        }
		return rpta;
	}

	@Override
	public CrudUsuarioResponse crudUsuario(CrudUsuarioRequest request) {
		// TODO Auto-generated method stub
		CrudUsuarioResponse rpta= new CrudUsuarioResponse();
		Connection cn= null;	
		CallableStatement cs = null;
		
		
		try {
			
//			System.out.println("crudUsuario -- idusuario:"+request.getIdusuario()+" usuario Edit"+request.getUsuario().getIdusuario());
	
			
			cn=jdbcTemplate.getDataSource().getConnection();
			//cn.setAutoCommit(false);
			cs = cn.prepareCall("{call crud_usuario("
												  +"?,?,?,?,?," +"?,?,?,?,?,"
												  +"?,?,?,?,?," +"?,?,?,?,?,"
												  +"?,?,?,?,?," +"?,?,?,?"
												+ ")}");
			
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.INTEGER);
			cs.registerOutParameter(4, Types.VARCHAR);
			
			cs.setInt(5, request.getIdusuario());
			cs.setString(6, request.getNumeroip());
			
			cs.setString(7, request.getTipo_operacion());
			cs.setString(8, request.getUsuario().getDni()==null?"":request.getUsuario().getDni());
			cs.setString(9, request.getUsuario().getNombre()==null?"":request.getUsuario().getNombre());
			cs.setString(10, request.getUsuario().getApellido_paterno()==null?"":request.getUsuario().getApellido_paterno());
			cs.setString(11, request.getUsuario().getApellido_materno()==null?"":request.getUsuario().getApellido_materno());
			cs.setString(12, request.getUsuario().getEmail()==null?"":request.getUsuario().getEmail());
			cs.setString(13, request.getUsuario().getDireccion()==null?"":request.getUsuario().getDireccion());
			cs.setString(14, request.getUsuario().getTelefono()==null?"":request.getUsuario().getTelefono());
			cs.setString(15, request.getUsuario().getLogin()==null?"":request.getUsuario().getLogin());
			cs.setString(16, request.getUsuario().getPassword()==null?"":request.getUsuario().getPassword());
			cs.setInt(17, request.getUsuario().getId_agencia());
			cs.setInt(18, request.getUsuario().getIdusuario());
			
			cs.registerOutParameter(19, Types.VARCHAR);
			cs.registerOutParameter(20, Types.VARCHAR);
			cs.registerOutParameter(21, Types.VARCHAR);
			cs.registerOutParameter(22, Types.VARCHAR);
			cs.registerOutParameter(23, Types.VARCHAR);
			cs.registerOutParameter(24, Types.VARCHAR);
			cs.registerOutParameter(25, Types.VARCHAR);
			cs.registerOutParameter(26, Types.VARCHAR);
			cs.registerOutParameter(27, Types.VARCHAR);
			cs.registerOutParameter(28, Types.VARCHAR);
			cs.registerOutParameter(29, Types.VARCHAR);
			
			
			cs.execute();
			
			if(cs.getString(1)!=null){
				rpta.setAviso(cs.getString(1));
			}
			
			if(cs.getString(2)!=null){
				rpta.setError(cs.getString(2));
			}else {
				if(request.getTipo_operacion().equalsIgnoreCase("I")) {
					String codigo="";
					
					if(cs.getString(4)!=null) {
						codigo=cs.getString(4);
					}
					//PARAMETROS
					ParametroCorreo parametro=new ParametroCorreo();
					if(cs.getString(19)!=null) {
						parametro.setCopia_oculto(cs.getString(19));
					}
					if(cs.getString(20)!=null) {
						parametro.setCopia_normal(cs.getString(20));
					}
					if(cs.getString(21)!=null) {
						parametro.setUsuario_correo(cs.getString(21));
					}
					if(cs.getString(22)!=null) {
						parametro.setPassword_correo(cs.getString(22));
					}
					if(cs.getString(23)!=null) {
						parametro.setAsunto(cs.getString(23));
					}
					if(cs.getString(24)!=null) {
						parametro.setSaludo_inicio(cs.getString(24));
					}
					if(cs.getString(25)!=null) {
						parametro.setPresentacion(cs.getString(25));
					}
					if(cs.getString(26)!=null) {
						parametro.setCuerpo_mensaje(cs.getString(26));
					}
					if(cs.getString(27)!=null) {
						parametro.setSaludo_despedida(cs.getString(27));
					}
					if(cs.getString(28)!=null) {
						parametro.setFirma_correo(cs.getString(28));
					}
					if(cs.getString(29)!=null) {
						parametro.setCorreo_contacto(cs.getString(29));
					}
					 
					
					EnvioCorreo envio=new EnvioCorreo();
					envio.sendEmail(
									parametro.getAsunto(), 			//asunto, 
									parametro.getUsuario_correo(),	//username, 
									parametro.getPassword_correo(),	//password, 
									request.getUsuario().getEmail(),//destinatario, 
									parametro.getCopia_normal(),	//correosCopiasNormales, 
									parametro.getCopia_oculto(),	//correosCopiasOcultas, 
									parametro.getSaludo_inicio(),	//saludoInicio 
									parametro.getPresentacion(),	//presentacion 
									parametro.getCuerpo_mensaje().replaceAll("_USUARIO_", request.getUsuario().getLogin()==null?"":request.getUsuario().getLogin()
																	  ).replaceAll("_AGENCIA_", request.getUsuario().getDesc_agencia()==null?"":request.getUsuario().getDesc_agencia()
																	  ).replaceAll("_CODIGO_", codigo==null?"": codigo),//cuerpoMensaje 
									parametro.getSaludo_despedida(), //saludoDespedida 
									parametro.getFirma_correo(),	//firma 
									parametro.getCorreo_contacto()	//correContacto
									);
				}
					
			}
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
			rpta.setError("Error crudUsuario : "+e.getMessage());
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
            	rpta.setError("Error cerrando conexion crudUsuario : "+e.getMessage());
            }
        }
		return rpta;
	}
	
	@Override
	public CrudUsuarioResponse habilitarUsuario(CrudUsuarioRequest request) {
		// TODO Auto-generated method stub
		CrudUsuarioResponse rpta= new CrudUsuarioResponse();
		Connection cn= null;	
		CallableStatement cs = null;
		
		try {
			cn=jdbcTemplate.getDataSource().getConnection();
			//cn.setAutoCommit(false);
			cs = cn.prepareCall("{call habilitar_usuario("
												  +"?,?,?,?,?," +"?,?,?,?,?,"
												  +"?,?,?,?,?," +"?,?,?,?,?,"
												  +"?,?,?,?,?," +"?,?,?,?"
												+ ")}");
			
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.INTEGER);
			cs.registerOutParameter(4, Types.VARCHAR);
			
			cs.setInt(5, request.getIdusuario());
			cs.setString(6, request.getNumeroip());
			
			cs.setString(7, request.getTipo_operacion());
			cs.setString(8, request.getUsuario().getDni()==null?"":request.getUsuario().getDni());
			cs.setString(9, request.getUsuario().getNombre()==null?"":request.getUsuario().getNombre());
			cs.setString(10, request.getUsuario().getApellido_paterno()==null?"":request.getUsuario().getApellido_paterno());
			cs.setString(11, request.getUsuario().getApellido_materno()==null?"":request.getUsuario().getApellido_materno());
			cs.setString(12, request.getUsuario().getEmail()==null?"":request.getUsuario().getEmail());
			cs.setString(13, request.getUsuario().getDireccion()==null?"":request.getUsuario().getDireccion());
			cs.setString(14, request.getUsuario().getTelefono()==null?"":request.getUsuario().getTelefono());
			cs.setString(15, request.getUsuario().getLogin()==null?"":request.getUsuario().getLogin());
			cs.setString(16, request.getUsuario().getPassword()==null?"":request.getUsuario().getPassword());
			cs.setInt(17, request.getUsuario().getId_agencia());
			cs.setInt(18, request.getUsuario().getIdusuario());
			
			cs.registerOutParameter(19, Types.VARCHAR);
			cs.registerOutParameter(20, Types.VARCHAR);
			cs.registerOutParameter(21, Types.VARCHAR);
			cs.registerOutParameter(22, Types.VARCHAR);
			cs.registerOutParameter(23, Types.VARCHAR);
			cs.registerOutParameter(24, Types.VARCHAR);
			cs.registerOutParameter(25, Types.VARCHAR);
			cs.registerOutParameter(26, Types.VARCHAR);
			cs.registerOutParameter(27, Types.VARCHAR);
			cs.registerOutParameter(28, Types.VARCHAR);
			cs.registerOutParameter(29, Types.VARCHAR);
			
			
			cs.execute();
			
			if(cs.getString(1)!=null){
				rpta.setAviso(cs.getString(1));
			}
			
			if(cs.getString(2)!=null){
				rpta.setError(cs.getString(2));
			}else {
				if(request.getTipo_operacion().equalsIgnoreCase("I")) {
					String codigo="";
					
					if(cs.getString(4)!=null) {
						codigo=cs.getString(4);
					}
					//PARAMETROS
					ParametroCorreo parametro=new ParametroCorreo();
					if(cs.getString(19)!=null) {
						parametro.setCopia_oculto(cs.getString(19));
					}
					if(cs.getString(20)!=null) {
						parametro.setCopia_normal(cs.getString(20));
					}
					if(cs.getString(21)!=null) {
						parametro.setUsuario_correo(cs.getString(21));
					}
					if(cs.getString(22)!=null) {
						parametro.setPassword_correo(cs.getString(22));
					}
					if(cs.getString(23)!=null) {
						parametro.setAsunto(cs.getString(23));
					}
					if(cs.getString(24)!=null) {
						parametro.setSaludo_inicio(cs.getString(24));
					}
					if(cs.getString(25)!=null) {
						parametro.setPresentacion(cs.getString(25));
					}
					if(cs.getString(26)!=null) {
						parametro.setCuerpo_mensaje(cs.getString(26));
					}
					if(cs.getString(27)!=null) {
						parametro.setSaludo_despedida(cs.getString(27));
					}
					if(cs.getString(28)!=null) {
						parametro.setFirma_correo(cs.getString(28));
					}
					if(cs.getString(29)!=null) {
						parametro.setCorreo_contacto(cs.getString(29));
					}
					 
					
					EnvioCorreo envio=new EnvioCorreo();
					envio.sendEmail(
									parametro.getAsunto(), 			//asunto, 
									parametro.getUsuario_correo(),	//username, 
									parametro.getPassword_correo(),	//password, 
									request.getUsuario().getEmail(),//destinatario, 
									parametro.getCopia_normal(),	//correosCopiasNormales, 
									parametro.getCopia_oculto(),	//correosCopiasOcultas, 
									parametro.getSaludo_inicio(),	//saludoInicio 
									parametro.getPresentacion(),	//presentacion 
									parametro.getCuerpo_mensaje().replaceAll("_USUARIO_", request.getUsuario().getLogin()==null?"":request.getUsuario().getLogin()
																	  ).replaceAll("_AGENCIA_", request.getUsuario().getDesc_agencia()==null?"":request.getUsuario().getDesc_agencia()
																	  ).replaceAll("_CODIGO_", codigo==null?"": codigo),//cuerpoMensaje 
									parametro.getSaludo_despedida(), //saludoDespedida 
									parametro.getFirma_correo(),	//firma 
									parametro.getCorreo_contacto()	//correContacto
									);
				}
					
			}
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
			rpta.setError("Error crudUsuario : "+e.getMessage());
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
            	rpta.setError("Error cerrando conexion crudUsuario : "+e.getMessage());
            }
        }
		return rpta;
	}
	/*
	public Connection getConnectionRemota throws Exception{
		Connection conn = null;
		String url = "";
		String username="";
		String password="";
		Class.forName("");
		
		conn = DriverManager.getConnection(url, username, password);
		return conn;
	}
	*/

	
	
	

}