package com.algaworks.brewer.service;

import com.algaworks.brewer.model.Cliente;
import com.algaworks.brewer.repository.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CadastroClienteService {

    @Autowired
    private Clientes clientes;

    @Transactional
    public void salvar(Cliente cliente) {
        clientes.save(cliente);
    }
}
