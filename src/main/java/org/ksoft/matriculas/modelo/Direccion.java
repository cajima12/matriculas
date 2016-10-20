package org.ksoft.matriculas.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="direcciones")
public class Direccion implements Serializable {

	private static final long serialVersionUID = -2124846874040101039L;

	public enum TipoDireccion {
		DOMICILIO_PARTICULAR,
		DOMICILIO_VACACIONAL,
		DOMICILIO_EMPRESA,
		OTROS
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String direccion;
	
	private String complemento;
	
	private String telefono;
	
	@Enumerated(EnumType.STRING)
	private TipoDireccion tipoDireccion;
	
	@ManyToOne
	@JoinColumn(name="personas_id")
	private Persona persona;

	@ManyToOne
	@JoinColumn(name="localidades_id")
	private Localidades localidad;

	@ManyToOne
	@JoinColumn(name="tipo_via_id")
	private TipoVia tipoVia;
	
	private String codPostal;

	public Direccion() {
	}

	public Direccion(String direccion, String complemento, String telefono,	TipoDireccion tipoDireccion, Persona persona,
			Localidades localidad, TipoVia tipoVia, String codPostal) {
		this.direccion = direccion;
		this.complemento = complemento;
		this.telefono = telefono;
		this.tipoDireccion = tipoDireccion;
		this.persona = persona;
		this.localidad = localidad;
		this.tipoVia = tipoVia;
		this.codPostal = codPostal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public TipoDireccion getTipoDireccion() {
		return tipoDireccion;
	}

	public void setTipoDireccion(TipoDireccion tipoDireccion) {
		this.tipoDireccion = tipoDireccion;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Localidades getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidades localidad) {
		this.localidad = localidad;
	}

	public TipoVia getTipoVia() {
		return tipoVia;
	}

	public void setTipoVia(TipoVia tipoVia) {
		this.tipoVia = tipoVia;
	}

	@Override
	public String toString() {
		return "Direccion [id=" + id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((complemento == null) ? 0 : complemento.hashCode());
		result = prime * result
				+ ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((telefono == null) ? 0 : telefono.hashCode());
		result = prime * result
				+ ((tipoDireccion == null) ? 0 : tipoDireccion.hashCode());
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
		Direccion other = (Direccion) obj;
		if (complemento == null) {
			if (other.complemento != null)
				return false;
		} else if (!complemento.equals(other.complemento))
			return false;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		if (tipoDireccion != other.tipoDireccion)
			return false;
		return true;
	}

	public String getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}
	
	

	
}
