package org.ksoft.matriculas.modelo.dto;

import java.io.Serializable;

import org.ksoft.matriculas.modelo.TipoVia;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;


public class TipoViaDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	
	private String descripcion;
	
	private String nombreCorto;
	
	public TipoViaDto() {
	}
	
	public TipoViaDto(String id) {
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
		return "TipoViaDto [id=" + id + "]";
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
		TipoViaDto other = (TipoViaDto) obj;
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
	
	/**
	 * Se mapean los datos al dto.
	 * 
	 * @param from
	 * @return
	 */
    public static TipoViaDto toDto(TipoVia from) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setFieldMatchingEnabled(true);
		modelMapper.getConfiguration().setAmbiguityIgnored(true);

		PropertyMap<TipoVia, TipoViaDto> orderMap = new PropertyMap<TipoVia, TipoViaDto>() {
			protected void configure() {
			}
		};
		modelMapper.addMappings(orderMap);
		TipoViaDto dto = modelMapper.map(from, TipoViaDto.class);		
		return dto;    	
    }

    
    /**
     * Se mapean los datos del dto a entidad
     * 
     * @param dto
     * @return
     */
    public static TipoVia toEntidad(final TipoViaDto dto) {
        
    	PropertyMap<TipoViaDto, TipoVia> mapeo = new PropertyMap<TipoViaDto, TipoVia>() {

            @Override
            protected void configure() {            	
            }
        };

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setFieldMatchingEnabled(true);
        modelMapper.addMappings(mapeo);        
     
        TipoVia entidad = modelMapper.map(dto, TipoVia.class);
        return entidad;
    }
	
}