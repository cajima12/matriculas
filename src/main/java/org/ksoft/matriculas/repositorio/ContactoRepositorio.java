package org.ksoft.matriculas.repositorio;

import org.ksoft.matriculas.modelo.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.marcaconsultoria.paginacion.interfaces.PaginacionTabla;

@Repository
@Transactional
public interface ContactoRepositorio extends JpaRepository<Contacto, Long>, PaginacionTabla<Contacto> {

	
}
