package com.algaworks.brewer.service;

import com.algaworks.brewer.model.Estilo;
import com.algaworks.brewer.repository.Estilos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CadastroEstiloService {

    @Autowired
    private Estilos estilos;

    @Transactional
    public void salvar(Estilo estilo){
        estilos.save(estilo);
    }
}
