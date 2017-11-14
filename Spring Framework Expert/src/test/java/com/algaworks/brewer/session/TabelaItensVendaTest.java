package com.algaworks.brewer.session;

import com.algaworks.brewer.model.Cerveja;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class TabelaItensVendaTest {

    private TabelaItensVenda tabelaItensVenda;

    @Before
    public void setUp(){
        this.tabelaItensVenda = new TabelaItensVenda();
    }

    @Test
    public void deveCalcularTotalSemItens() throws Exception {
        assertEquals(BigDecimal.ZERO, tabelaItensVenda.getValorTotal());
    }

    @Test
    public void deveCalcularValorTotalComUmItem() throws Exception {
        Cerveja cerveja = new Cerveja();
        BigDecimal valor = new BigDecimal("8.90");
        cerveja.setValor(valor);

        tabelaItensVenda.adicionarItem(cerveja, 1);
        assertEquals(valor, tabelaItensVenda.getValorTotal());
    }


    @Test
    public void deveCalcularValorTotalComVariosItens() throws Exception {
        Cerveja c1 = new Cerveja();
        c1.setCodigo(1L);
        BigDecimal v1 = new BigDecimal("8.90");
        c1.setValor(v1);

        Cerveja c2 = new Cerveja();
        c1.setCodigo(2L);
        BigDecimal v2 = new BigDecimal("4.99");
        c2.setValor(v2);

        tabelaItensVenda.adicionarItem(c1, 1);
        tabelaItensVenda.adicionarItem(c2, 2);

        assertEquals(new BigDecimal("18.88"), tabelaItensVenda.getValorTotal());
    }

    @Test
    public void deveManterTamanhoDaListaParaMesmasCervejas() throws Exception {
        Cerveja c1 = new Cerveja();
        c1.setCodigo(1L);
        BigDecimal v1 = new BigDecimal("4.50");
        c1.setValor(v1);

        tabelaItensVenda.adicionarItem(c1, 1);
        tabelaItensVenda.adicionarItem(c1, 1);

        assertEquals(1, tabelaItensVenda.total());
        assertEquals(new BigDecimal("9.00"), tabelaItensVenda.getValorTotal());
    }

    @Test
    public void deveAlterarQuantidadeDoItem() throws Exception {
        Cerveja c1 = new Cerveja();
        c1.setCodigo(1L);
        BigDecimal v1 = new BigDecimal("4.50");
        c1.setValor(v1);

        tabelaItensVenda.adicionarItem(c1, 1);
        tabelaItensVenda.alterarQuantidadeItens(c1, 3);

        assertEquals(1, tabelaItensVenda.total());
        assertEquals(new BigDecimal("13.50"), tabelaItensVenda.getValorTotal());
    }
}
