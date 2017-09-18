package com.algaworks.brewer.repository.helper.cerveja;

import com.algaworks.brewer.model.Cerveja;
import com.algaworks.brewer.repository.filter.CervejaFilter;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CervejasQueries {

    List<Cerveja> filtrar(CervejaFilter cervejaFilter, Pageable pageable);
}
