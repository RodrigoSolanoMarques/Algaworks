package com.algaworks.brewer.service;

import com.algaworks.brewer.model.Cidade;
import com.algaworks.brewer.repository.Cidades;
import com.algaworks.brewer.service.exception.NomeCidadeJaCadastradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CadastroCidadeService {

    @Autowired
    Cidades cidades;

    @Transactional
    public void salvar(Cidade cidade){
        Optional<Cidade> cidadeExiste = cidades.findByNomeIgnoreCaseAndAndEstadoCodigo(cidade.getNome(), cidade.getEstado().getCodigo());
        if(cidadeExiste.isPresent()){
            throw new NomeCidadeJaCadastradoException("Nome já cadastrado");
        }

        cidades.save(cidade);
    }
}
