package org.ksoft.matriculas.servicio;

import org.ksoft.matriculas.modelo.Usuario;
import org.springframework.stereotype.Service;

@Service
public interface UsuarioServicio {
	 
    public Usuario getUsuario(String username);

}