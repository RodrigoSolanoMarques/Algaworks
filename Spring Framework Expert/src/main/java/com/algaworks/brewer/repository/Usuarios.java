package com.algaworks.brewer.repository;

import com.algaworks.brewer.model.Usuario;
import com.algaworks.brewer.repository.helper.usuario.UsuariosQueries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Usuarios extends JpaRepository<Usuario, Long>, UsuariosQueries {

    public Optional<Usuario> findByEmail(String email);

    public List<Usuario> findByCodigoIn(Long[] codigos);
}
