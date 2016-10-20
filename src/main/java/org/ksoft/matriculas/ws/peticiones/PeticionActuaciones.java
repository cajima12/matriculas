package org.ksoft.matriculas.ws.peticiones;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO que contiene los campos por los que se puede filtrar el listado de actuaciones
 * 
 * @author RCHZ
 *
 */
public class PeticionActuaciones implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8531804500447083398L;

	private String clave;
	
	private Date fechaComienzo;
	
	private String nombreFase;

	/**
	 * Indica si sólo debe devolver masivos
	 */
	private Boolean masivo;
	
	/**
	 * Evento asociado a la actuacion 
	 */
	private String evento;
	
	/**
	 * Indica si sólo debe devolver actuaciones asociadas al administrador
	 */
	private Boolean administrador;
	
	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public Date getFechaComienzo() {
		return fechaComienzo;
	}

	public void setFechaComienzo(Date fechaComienzo) {
		this.fechaComienzo = fechaComienzo;
	}

	public String getNombreFase() {
		return nombreFase;
	}

	public void setNombreFase(String nombreFase) {
		this.nombreFase = nombreFase;
	}

	public Boolean getMasivo() {
		return masivo;
	}

	public void setMasivo(Boolean masivo) {
		this.masivo = masivo;
	}

	public String getEvento() {
		return evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}

	public Boolean getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Boolean administrador) {
		this.administrador = administrador;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((administrador == null) ? 0 : administrador.hashCode());
		result = prime * result + ((clave == null) ? 0 : clave.hashCode());
		result = prime * result + ((evento == null) ? 0 : evento.hashCode());
		result = prime * result + ((fechaComienzo == null) ? 0 : fechaComienzo.hashCode());
		result = prime * result + ((masivo == null) ? 0 : masivo.hashCode());
		result = prime * result + ((nombreFase == null) ? 0 : nombreFase.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PeticionActuaciones other = (PeticionActuaciones) obj;
		if (administrador == null) {
			if (other.administrador != null)
				return false;
		} else if (!administrador.equals(other.administrador))
			return false;
		if (clave == null) {
			if (other.clave != null)
				return false;
		} else if (!clave.equals(other.clave))
			return false;
		if (evento == null) {
			if (other.evento != null)
				return false;
		} else if (!evento.equals(other.evento))
			return false;
		if (fechaComienzo == null) {
			if (other.fechaComienzo != null)
				return false;
		} else if (!fechaComienzo.equals(other.fechaComienzo))
			return false;
		if (masivo == null) {
			if (other.masivo != null)
				return false;
		} else if (!masivo.equals(other.masivo))
			return false;
		if (nombreFase == null) {
			if (other.nombreFase != null)
				return false;
		} else if (!nombreFase.equals(other.nombreFase))
			return false;
		return true;
	}



	

}
