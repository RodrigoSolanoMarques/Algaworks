package com.algaworks.brewer.model;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class UsuarioGrupoId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "codigo_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "codigo_grupo")
    private Grupo grupo;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsuarioGrupoId that = (UsuarioGrupoId) o;

        if (usuario != null ? !usuario.equals(that.usuario) : that.usuario != null) return false;
        return grupo != null ? grupo.equals(that.grupo) : that.grupo == null;
    }

    @Override
    public int hashCode() {
        int result = usuario != null ? usuario.hashCode() : 0;
        result = 31 * result + (grupo != null ? grupo.hashCode() : 0);
        return result;
    }
}
