package org.ksoft.matriculas.login;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.codec.digest.DigestUtils;
import org.ksoft.matriculas.modelo.Usuario;
import org.ksoft.matriculas.repositorio.UsuarioRepositorio;
import org.ksoft.matriculas.util.Funciones;
import org.primefaces.context.RequestContext;

@ManagedBean
@RequestScoped
public class CambiarClaveBean implements Serializable {

	private static final long serialVersionUID = -7950932882717718773L;
	
	@ManagedProperty("#{usuarioRepositorio}")
	private UsuarioRepositorio usuarioRepositorio;
	
	private String claveActual;
	private String claveNueva;
	private String claveNuevaBis;
	
	public void reset() {
		claveActual = null;
		claveNueva = null;
		claveNuevaBis = null;
	}
	
	
	public void abrirVentana() {
		reset();
		RequestContext.getCurrentInstance().execute("PF('dialogoSubir').show();");
	}
	
	public void submit() {
		Usuario usuario = Funciones.getUsuarioLogado().getUsuario();
		if ( usuario.getPassword().equals(DigestUtils.md5Hex(claveActual))) {
			if (claveNueva.equals(claveNuevaBis)) {
				try {
					usuario.setPassword(DigestUtils.md5Hex(claveNueva));
					usuarioRepositorio.save(usuario);
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se ha modificado la contraseña."));
					reset();
					RequestContext.getCurrentInstance().execute("PF('dialogoSubir').hide();");
				} catch (Exception e) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ocurrió un error durante el proceso de guardado. Inténtelo de nuevo."));
				}	
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Las clave nueva y su repetición no coinciden."));	
			}
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("La contraseña actual no se introdujo correctamente."));
		}
	}
	
	public void setUsuarioRepositorio(UsuarioRepositorio usuarioRepositorio) {
		this.usuarioRepositorio = usuarioRepositorio;
	}

	public String getClaveActual() {
		return claveActual;
	}

	public void setClaveActual(String claveActual) {
		this.claveActual = claveActual;
	}

	public String getClaveNueva() {
		return claveNueva;
	}

	public void setClaveNueva(String claveNueva) {
		this.claveNueva = claveNueva;
	}

	public String getClaveNuevaBis() {
		return claveNuevaBis;
	}

	public void setClaveNuevaBis(String claveNuevaBis) {
		this.claveNuevaBis = claveNuevaBis;
	}
}
