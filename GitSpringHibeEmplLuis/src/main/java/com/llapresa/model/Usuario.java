package com.llapresa.model;

// Generated 25-abr-2014 21:04:13 by Hibernate Tools 3.6.0

/**
 * Usuario generated by hbm2java
 */
public class Usuario implements java.io.Serializable {

	private Integer idUsuario;
	private String login;
	private String password;

	public Usuario() {
	}

	public Usuario(String login, String password) {
		this.login = login;
		this.password = password;
	}

	public Integer getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
