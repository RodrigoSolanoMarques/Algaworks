package com.algaworks.brewer.repository;

import com.algaworks.brewer.model.Cidade;
import com.algaworks.brewer.repository.helper.cidade.CidadesQueries;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface Cidades extends JpaRepository<Cidade, Long>, CidadesQueries {

    public List<Cidade> findByEstadoCodigo(Long codigoEstado);

    public Optional<Cidade> findByNomeIgnoreCase(String nome);

    public Optional<Cidade> findByNomeIgnoreCaseAndAndEstadoCodigo(String nome, Long codigoEstado);

}
