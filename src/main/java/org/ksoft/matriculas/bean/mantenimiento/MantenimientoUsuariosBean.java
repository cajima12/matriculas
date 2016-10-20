package org.ksoft.matriculas.bean.mantenimiento;

import java.sql.Timestamp;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.ksoft.matriculas.modelo.Usuario;
import org.ksoft.matriculas.repositorio.UsuarioRepositorio;

@ManagedBean(name = "mantenimientoUsuariosBean")
@ViewScoped
public class MantenimientoUsuariosBean extends MantenimientoGenericoBean<Usuario, Long> {

	private static final long serialVersionUID = -774535204839807754L;
	private static final Logger log = Logger.getLogger(MantenimientoUsuariosBean.class);

	@ManagedProperty("#{usuarioRepositorio}")
	private UsuarioRepositorio usuarioRepo;
	
	// la contraseña almacenada en BBDD está codificada en MD5, hay que tenerlo en cuenta para las comprobaciones
	private String claveAnterior;


	@Override
	public void guardar() {
		try {
			//CONTRASEÑA
			if (claveAnterior == null || !claveAnterior.equals(getInstancia().getPassword())) {
				getInstancia().setPassword(DigestUtils.md5Hex(getInstancia().getPassword()));
			}

			//FECHA CREACION
			if (getInstancia().getId() <= 0) {
				getInstancia().setFechaCreacion(new Timestamp(new Date().getTime()));
			}

			super.guardar();

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ocurrió un error en el proceso de guardado"));
		}
	}

	@Override
	public void setInstancia(Usuario instancia) {
		if (instancia != null) {
			claveAnterior = instancia.getPassword();
		} else {
			claveAnterior = null;
		}
		super.setInstancia(instancia);
	}


	public void setUsuarioRepo(UsuarioRepositorio usuarioRepo) {
		setRepositorio(usuarioRepo);
		this.usuarioRepo = usuarioRepo;
	}


}
