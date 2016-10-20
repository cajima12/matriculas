package org.ksoft.matriculas.servicio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.ksoft.matriculas.modelo.Direccion;
import org.ksoft.matriculas.modelo.Localidades;
import org.ksoft.matriculas.modelo.Persona;
import org.ksoft.matriculas.modelo.Provincias;
import org.ksoft.matriculas.modelo.TipoVia;
import org.ksoft.matriculas.repositorio.DireccionRepositorio;
import org.ksoft.matriculas.repositorio.LocalidadesRepositorio;
import org.ksoft.matriculas.repositorio.ProvinciasRepositorio;
import org.ksoft.matriculas.repositorio.TipoViaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DireccionServicio implements Serializable {

	private static final long serialVersionUID = -1514524841698644128L;
	
	@Autowired DireccionRepositorio direccionRepo;
	@Autowired TipoViaRepositorio tipoViaRepo;
	@Autowired ProvinciasRepositorio provinciaRepo;
	@Autowired LocalidadesRepositorio localidadRepo;
	
	public List<Direccion> getDireccionesPersona( Persona persona ) {
		return direccionRepo.findByPersona(persona);
	}
	
	public List<TipoVia> getTiposVia() {
		return tipoViaRepo.findAll();
	}
	
	public List<TipoVia> filtrarTiposViasAutocompletar( String query ) {
        List<TipoVia> tiposVias = getTiposVia();
        List<TipoVia> viasFiltradas = new ArrayList<TipoVia>();
        for (int i = 0; i < tiposVias.size(); i++) {
        	TipoVia via = tiposVias.get(i);
            if(via.getNombreCorto().toUpperCase().startsWith(query.toUpperCase())) {
            	viasFiltradas.add(via);
            }
        }
        return viasFiltradas;
	}

	public List<Provincias> filtrarProvinciasAutocompletar( String query ) {
        List<Provincias> provincias = getProvincias();
        List<Provincias> provinciasFiltradas = new ArrayList<Provincias>();
        for (int i = 0; i < provincias.size(); i++) {
        	Provincias provincia = provincias.get(i);
            if(provincia.getNombre().toUpperCase().startsWith(query.toUpperCase())) {
            	provinciasFiltradas.add(provincia);
            }
        }
        return provinciasFiltradas;
	}

	public List<Localidades> filtrarLocalidadesAutocompletar( String query, Provincias provincia ) {
        List<Localidades> localidades = getLocalidadesProvincia(provincia);
        List<Localidades> localidadesFiltradas = new ArrayList<Localidades>();
        for (int i = 0; i < localidades.size(); i++) {
        	Localidades localidad = localidades.get(i);
            if(localidad.getNombre().toUpperCase().startsWith(query.toUpperCase())) {
            	localidadesFiltradas.add(localidad);
            }
        }
        return localidadesFiltradas;
	}
	
	public List<Provincias> getProvincias() {
		return provinciaRepo.findAll();
	}
	
	public List<Localidades> getLocalidades() {
		return localidadRepo.findAll();
	}

	public List<Localidades> getLocalidadesProvincia( Provincias provincia ) {
		return localidadRepo.findByProvincia(provincia);
	}
}
