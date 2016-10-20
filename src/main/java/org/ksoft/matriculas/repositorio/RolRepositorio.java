package org.ksoft.matriculas.repositorio;

import org.ksoft.matriculas.modelo.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.marcaconsultoria.paginacion.interfaces.PaginacionTabla;

@Repository
@Transactional
public interface RolRepositorio extends JpaRepository<Rol, Long>, PaginacionTabla<Rol> {
	
	public Rol findByRol(String rol);
	
}
