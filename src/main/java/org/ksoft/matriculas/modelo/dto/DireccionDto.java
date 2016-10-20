package org.ksoft.matriculas.modelo.dto;

import java.io.Serializable;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.ksoft.matriculas.modelo.Direccion;
import org.ksoft.matriculas.modelo.Localidades;
import org.ksoft.matriculas.modelo.Persona;
import org.ksoft.matriculas.modelo.TipoVia;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

public class DireccionDto implements Serializable {

	private static final long serialVersionUID = -2124846874040101039L;

	public enum TipoDireccion {
		DOMICILIO_PARTICULAR,
		DOMICILIO_VACACIONAL,
		DOMICILIO_EMPRESA,
		OTROS
	}
	
	private Long id;

	private String direccion;
	
	private String complemento;
	
	private String telefono;
	
	@Enumerated(EnumType.STRING)
	private TipoDireccion tipoDireccion;
	
	private Persona persona;

	private Localidades localidad;

	private TipoVia tipoVia;
	
	private String codPostal;

	public DireccionDto() {
	}

	public DireccionDto(String direccion, String complemento, String telefono,	TipoDireccion tipoDireccion, Persona persona,
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

	public String getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}
	
	@Override
	public String toString() {
		return "DireccionDto [id=" + id + "]";
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
		DireccionDto other = (DireccionDto) obj;
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
	
	public static DireccionDto toDto( Direccion from ) {
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setFieldMatchingEnabled(true);		
	
	 PropertyMap<Direccion, DireccionDto> map = new PropertyMap<Direccion, DireccionDto>() {
	 
		 protected void configure() {
         }
	 };
	 
	 modelMapper.addMappings(map);
	 DireccionDto dto = modelMapper.map(from, DireccionDto.class);
	
	 return dto;
	 
	}

	
}
