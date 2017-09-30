package com.algaworks.brewer.repository;

import com.algaworks.brewer.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Clientes extends JpaRepository<Cliente, Long> {
    public Optional<Cliente> findByCpfOuCnpj(String cpfOuCnpj);
}
