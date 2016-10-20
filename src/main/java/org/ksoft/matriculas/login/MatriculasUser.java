package org.ksoft.matriculas.login;

import java.util.Collection;

import org.ksoft.matriculas.modelo.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class MatriculasUser extends User{

    private static final long serialVersionUID = 194833354736835618L;
    
    private Usuario usuario;
    
    public MatriculasUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked,
            Collection<? extends GrantedAuthority> authorities, Usuario usuario) {
       super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
       this.usuario = usuario;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }
}
