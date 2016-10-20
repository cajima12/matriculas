package org.ksoft.matriculas.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the "TIPO_VIA" database table.
 * 
 */
@Entity
@Table(name="tipo_via")
public class TipoVia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	private String descripcion;
	
	@Column(name="nombre_corto")
	private String nombreCorto;
	
	
	
	public TipoVia() {
	}

	
	public TipoVia(String id) {
		super();
		this.id = id;
	}


	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getNombreCorto() {
		return nombreCorto;
	}
	
	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}

	@Override
	public String toString() {
		return "TipoVia [id=" + id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((nombreCorto == null) ? 0 : nombreCorto.hashCode());
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
		TipoVia other = (TipoVia) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombreCorto == null) {
			if (other.nombreCorto != null)
				return false;
		} else if (!nombreCorto.equals(other.nombreCorto))
			return false;
		return true;
	}
	

	
}