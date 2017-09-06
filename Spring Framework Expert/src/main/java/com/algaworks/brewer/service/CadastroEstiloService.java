package com.algaworks.brewer.service;

import com.algaworks.brewer.model.Estilo;
import com.algaworks.brewer.repository.Estilos;
import com.algaworks.brewer.service.exception.NomeEstiloJaCadastradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CadastroEstiloService {

    @Autowired
    private Estilos estilos;

    @Transactional
    public void salvar(Estilo estilo){
        Optional<Estilo> estiloOptional = estilos.findByNomeIgnoreCase(estilo.getNome());

        if (estiloOptional.isPresent()){
            throw new NomeEstiloJaCadastradoException("Nome do estilo já cadastrado");
        }
        estilos.save(estilo);
    }
}
