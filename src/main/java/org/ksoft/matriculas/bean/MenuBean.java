package org.ksoft.matriculas.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
@SuppressWarnings("unused")
public class MenuBean {	
	
	
	// Accesos a la página principal	
	public String goToMenuPrincipal(){
		return "/pages/secure/busquedas/loginLayout.xhtml?faces-redirect=true";
	}	
	
	public String goToDashboard(){
		return "/pages/secure/principal/index.xhtml?faces-redirect=true";
	}	

	public String goToArbolDocumentod(){
		return "/pages/secure/herramientas/arbolDocumentos.xhtml?faces-redirect=true";
	}	

	/* PANEL DE CONTROL - MANTENIMIENTOS */
	public String goToMantenimientoPadre() {
		return "/pages/secure/mantenimientos/padre.xhtml?faces-redirect=true";
	}
	
}