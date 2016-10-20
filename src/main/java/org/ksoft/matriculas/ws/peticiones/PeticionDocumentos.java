package org.ksoft.matriculas.ws.peticiones;

import java.io.Serializable;

/**
 * DTO que contiene los campos por los que se puede filtrar el listado de Documentos
 * 
 * @author CJM
 *
 */
public class PeticionDocumentos implements Serializable {

	private static final long serialVersionUID = -6047687791081474584L;


	/**
	 * Indica si sólo debe devolver los documentos de una unidad
	 */
	private Long idUnidad;
	
	/**
	 * Indica si sólo debe devolver los documentos de una unidad
	 */
	private String refInternaUnidad;
	
	/**
	 * Indica si sólo debe devolver los metadatos de un documento
	 */
	private String idDocumento;

	public String getRefInternaUnidad() {
		return refInternaUnidad;
	}

	public void setRefInternaUnidad(String refInternaUnidad) {
		this.refInternaUnidad = refInternaUnidad;
	}

	public String getIdDocumento() {
		return idDocumento;
	}

	public void setIdDocumento(String idDocumento) {
		this.idDocumento = idDocumento;
	}

	public Long getIdUnidad() {
		return idUnidad;
	}

	public void setIdUnidad(Long idUnidad) {
		this.idUnidad = idUnidad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idDocumento == null) ? 0 : idDocumento.hashCode());
		result = prime * result + ((idUnidad == null) ? 0 : idUnidad.hashCode());
		result = prime * result + ((refInternaUnidad == null) ? 0 : refInternaUnidad.hashCode());
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
		PeticionDocumentos other = (PeticionDocumentos) obj;
		if (idDocumento == null) {
			if (other.idDocumento != null)
				return false;
		} else if (!idDocumento.equals(other.idDocumento))
			return false;
		if (idUnidad == null) {
			if (other.idUnidad != null)
				return false;
		} else if (!idUnidad.equals(other.idUnidad))
			return false;
		if (refInternaUnidad == null) {
			if (other.refInternaUnidad != null)
				return false;
		} else if (!refInternaUnidad.equals(other.refInternaUnidad))
			return false;
		return true;
	}
	


}
