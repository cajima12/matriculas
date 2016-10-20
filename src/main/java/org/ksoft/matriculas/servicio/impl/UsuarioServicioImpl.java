package org.ksoft.matriculas.servicio.impl;

import org.ksoft.matriculas.modelo.Usuario;
import org.ksoft.matriculas.repositorio.UsuarioRepositorio;
import org.ksoft.matriculas.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioServicioImpl implements UsuarioServicio {
   
    @Autowired
    private UsuarioRepositorio usuarioRepo;

    public Usuario getUsuario(String username) {
        return usuarioRepo.findOne(new Long(1));
    }

}