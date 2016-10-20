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
@Table(name="contactos")
public class Contacto implements Serializable {

	private static final long serialVersionUID = 3185223286276237764L;
	
	public enum TipoContacto {
		FIJO,
		MOVIL,
		EMAIL,
		OTROS
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String contacto;
	
	@Enumerated(EnumType.STRING)
	private TipoContacto tipoContacto;
	
	@ManyToOne
	@JoinColumn(name="persona_id")
	private Persona persona;

	public Contacto() {

	}

	public Contacto(String contacto, TipoContacto tipoContacto, Persona persona) {
		this.contacto = contacto;
		this.tipoContacto = tipoContacto;
		this.persona = persona;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public TipoContacto getTipoContacto() {
		return tipoContacto;
	}

	public void setTipoContacto(TipoContacto tipoContacto) {
		this.tipoContacto = tipoContacto;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Override
	public String toString() {
		return "Contacto [id=" + id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((contacto == null) ? 0 : contacto.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((tipoContacto == null) ? 0 : tipoContacto.hashCode());
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
		Contacto other = (Contacto) obj;
		if (contacto == null) {
			if (other.contacto != null)
				return false;
		} else if (!contacto.equals(other.contacto))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (tipoContacto != other.tipoContacto)
			return false;
		return true;
	}
	
	

}
