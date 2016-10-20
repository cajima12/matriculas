package org.ksoft.matriculas.repositorio;

import java.util.List;

import org.ksoft.matriculas.modelo.Localidades;
import org.ksoft.matriculas.modelo.Provincias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.marcaconsultoria.paginacion.interfaces.PaginacionTabla;

@Repository
@Transactional
public interface LocalidadesRepositorio extends JpaRepository<Localidades, Long>, PaginacionTabla<Localidades> {

	public List<Localidades> findByProvincia( Provincias provincia );
}
