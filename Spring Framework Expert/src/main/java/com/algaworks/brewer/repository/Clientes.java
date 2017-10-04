package com.algaworks.brewer.repository;

import com.algaworks.brewer.model.Cliente;
import com.algaworks.brewer.repository.helper.cliente.ClientesQueries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Clientes extends JpaRepository<Cliente, Long>, ClientesQueries {
    public Optional<Cliente> findByCpfOuCnpj(String cpfOuCnpj);
}
