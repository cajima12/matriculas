package org.ksoft.matriculas.repositorio;

import java.util.List;

import org.ksoft.matriculas.modelo.Persona;
import org.ksoft.matriculas.modelo.Persona.TipoPersona;
import org.ksoft.matriculas.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.marcaconsultoria.paginacion.interfaces.PaginacionTabla;

@Repository
@Transactional
public interface PersonaRepositorio extends JpaRepository<Persona, Long>, PaginacionTabla<Persona> {

	public List<Persona> findAllByTipoPersonaAndUsuario(TipoPersona tipoPersona, Usuario usuario);
	
	public List<Persona> findAllByUsuario(Usuario usuario);
	
}
