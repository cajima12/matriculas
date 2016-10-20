package org.ksoft.matriculas.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.ksoft.matriculas.login.MatriculasUser;
import org.ksoft.matriculas.util.Funciones;

@SessionScoped
@ManagedBean(name="sessionBean")
public class SessionBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private MatriculasUser userLog;
		
	public SessionBean() {
		this.userLog = Funciones.getUsuarioLogado(); 
	}

	public MatriculasUser getUserLog() {
		return userLog;
	}

	public void setUserLog(MatriculasUser userLog) {
		this.userLog = userLog;
	}

	public String username() {
		return userLog.getUsername();
	}
	
}
