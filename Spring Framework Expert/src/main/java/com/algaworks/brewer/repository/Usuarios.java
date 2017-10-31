package com.algaworks.brewer.repository;

import com.algaworks.brewer.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Usuarios extends JpaRepository<Usuario, Long> {

    public Optional<Usuario> findByEmail(String email);
}
