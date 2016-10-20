package org.ksoft.matriculas.repositorio;

import org.ksoft.matriculas.modelo.TipoVia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.marcaconsultoria.paginacion.interfaces.PaginacionTabla;

@Repository
@Transactional
public interface TipoViaRepositorio extends JpaRepository<TipoVia, String>, PaginacionTabla<TipoVia> {

}
