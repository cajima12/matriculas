package org.ksoft.matriculas.ws.peticiones;

import java.io.Serializable;

/**
 * DTO que contiene los campos por los que se puede filtrar el listado de Firmantes
 * 
 * @author CJM
 *
 */
public class PeticionFirmantes implements Serializable {

	private static final long serialVersionUID = 600451446902612783L;

	private String nif;
	
	private String nombre;
	
	private Long idUnidad;
	
	private String codUnidad;
	
	private Integer orden;
	
	private Boolean firmaBoe;

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getIdUnidad() {
		return idUnidad;
	}

	public void setIdUnidad(Long idUnidad) {
		this.idUnidad = idUnidad;
	}

	public String getCodUnidad() {
		return codUnidad;
	}

	public void setCodUnidad(String codUnidad) {
		this.codUnidad = codUnidad;
	}
	
	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	public Boolean getFirmaBoe() {
		return firmaBoe;
	}

	public void setFirmaBoe(Boolean firmaBoe) {
		this.firmaBoe = firmaBoe;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codUnidad == null) ? 0 : codUnidad.hashCode());
		result = prime * result + ((firmaBoe == null) ? 0 : firmaBoe.hashCode());
		result = prime * result + ((idUnidad == null) ? 0 : idUnidad.hashCode());
		result = prime * result + ((nif == null) ? 0 : nif.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((orden == null) ? 0 : orden.hashCode());
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
		PeticionFirmantes other = (PeticionFirmantes) obj;
		if (codUnidad == null) {
			if (other.codUnidad != null)
				return false;
		} else if (!codUnidad.equals(other.codUnidad))
			return false;
		if (firmaBoe == null) {
			if (other.firmaBoe != null)
				return false;
		} else if (!firmaBoe.equals(other.firmaBoe))
			return false;
		if (idUnidad == null) {
			if (other.idUnidad != null)
				return false;
		} else if (!idUnidad.equals(other.idUnidad))
			return false;
		if (nif == null) {
			if (other.nif != null)
				return false;
		} else if (!nif.equals(other.nif))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (orden == null) {
			if (other.orden != null)
				return false;
		} else if (!orden.equals(other.orden))
			return false;
		return true;
	}

	
	
}
