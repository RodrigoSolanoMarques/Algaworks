package com.algaworks.brewer.service;

import com.algaworks.brewer.model.ItemVenda;
import com.algaworks.brewer.model.StatusVenda;
import com.algaworks.brewer.model.Venda;
import com.algaworks.brewer.repository.Vendas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

@Service
public class CadastroVendaService {

    @Autowired
    private Vendas vendas;

    @Transactional
    public Venda salvar(Venda venda) {

        if(venda.isSalvarProibido()){
            throw new RuntimeException("Usuário tentando salvar uma venda proibida");
        }

        if (venda.isNova()) {
            venda.setDataCriacao(LocalDateTime.now());
        }else{
            Venda vendaExisente = vendas.findOne(venda.getCodigo());
            venda.setDataCriacao(vendaExisente.getDataCriacao());
        }

        if (venda.getDataEntrega() != null) {
            venda.setDataHoraEntrega(LocalDateTime.of(venda.getDataEntrega(), venda.getHorarioEntrega() != null ? venda.getHorarioEntrega() : LocalTime.NOON));
        }

        return vendas.saveAndFlush(venda);
    }

    @Transactional
    public void emitir(Venda venda) {
        venda.setStatus(StatusVenda.EMITIDA);
        salvar(venda);
    }

    @PreAuthorize("#venda.usuario == principal.usuario or hasRole('CANCELAR_VENDA')")
    @Transactional
    public void cancelar(Venda venda) {

        Venda vendaExisente = vendas.findOne(venda.getCodigo());

        vendaExisente.setStatus(StatusVenda.CANCELADA);
        vendas.save(vendaExisente);

    }
}
