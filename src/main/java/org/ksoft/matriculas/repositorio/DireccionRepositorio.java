package org.ksoft.matriculas.repositorio;

import java.util.List;

import org.ksoft.matriculas.modelo.Direccion;
import org.ksoft.matriculas.modelo.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.marcaconsultoria.paginacion.interfaces.PaginacionTabla;

@Repository
@Transactional
public interface DireccionRepositorio extends JpaRepository<Direccion, Long>, PaginacionTabla<Direccion> {

	List<Direccion> findByPersona(Persona persona);

}
