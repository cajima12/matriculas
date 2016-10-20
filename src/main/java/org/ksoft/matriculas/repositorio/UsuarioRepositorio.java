package org.ksoft.matriculas.repositorio;

import java.util.List;

import org.ksoft.matriculas.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.marcaconsultoria.paginacion.interfaces.PaginacionTabla;

@Repository
@Transactional
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>, PaginacionTabla<Usuario> {

	Usuario findByUsername(String username);
	
	Usuario findByUsernameAndVerificadoTrue(String username);
	
	Usuario findByNif(String nif);

	public Usuario findByVerificadoTrue(Boolean verificado);

	@Query("SELECT DISTINCT(u) FROM Usuario u LEFT JOIN FETCH u.roles ORDER BY u.apellido1,u.apellido2 ,u.nombre ")
	List<Usuario> findAllFetchRoles();
}
