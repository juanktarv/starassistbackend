package com.quentin.starassistws.objetousuario;

public class Usuario {

	private Integer idusuario;
	private String nombre;
	private String login;
	private String password;
	private String fecha_registro;
	private String fecha_mod;
	private String apellido_paterno;
	private String apellido_materno;
	private String dni;
	private String email;
	private String direccion;
	private Integer estado;
	private String fecha_acceso;
	private Integer es_nuevo;
	private Integer id_agencia;
	private String telefono;
	private String desc_agencia;
	
	private Integer habilitado;

	public Usuario() {
		this.id_agencia = 0;
		this.idusuario = 0;
	}

	public Integer getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(String fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	public String getFecha_mod() {
		return fecha_mod;
	}

	public void setFecha_mod(String fecha_mod) {
		this.fecha_mod = fecha_mod;
	}

	public String getApellido_paterno() {
		return apellido_paterno;
	}

	public void setApellido_paterno(String apellido_paterno) {
		this.apellido_paterno = apellido_paterno;
	}

	public String getApellido_materno() {
		return apellido_materno;
	}

	public void setApellido_materno(String apellido_materno) {
		this.apellido_materno = apellido_materno;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public String getFecha_acceso() {
		return fecha_acceso;
	}

	public void setFecha_acceso(String fecha_acceso) {
		this.fecha_acceso = fecha_acceso;
	}

	public Integer getEs_nuevo() {
		return es_nuevo;
	}

	public void setEs_nuevo(Integer es_nuevo) {
		this.es_nuevo = es_nuevo;
	}

	public Integer getId_agencia() {
		return id_agencia;
	}

	public void setId_agencia(Integer id_agencia) {
		this.id_agencia = id_agencia;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDesc_agencia() {
		return desc_agencia;
	}

	public void setDesc_agencia(String desc_agencia) {
		this.desc_agencia = desc_agencia;
	}

	public Integer getHabilitado() {
		return habilitado;
	}

	public void setHabilitado(Integer habilitado) {
		this.habilitado = habilitado;
	}
	
}
