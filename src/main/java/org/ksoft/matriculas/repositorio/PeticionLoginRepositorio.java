package org.ksoft.matriculas.repositorio;

import org.ksoft.matriculas.modelo.PeticionLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface PeticionLoginRepositorio extends JpaRepository<PeticionLogin, String>{

}
