package com.algaworks.brewer.controller;

import com.algaworks.brewer.model.Cerveja;
import com.algaworks.brewer.repository.Cervejas;
import com.algaworks.brewer.session.TabelaItensVenda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/vendas")
public class VendasController {

    @Autowired
    private Cervejas cervejas;

    @Autowired
    private TabelaItensVenda tabelaItensVenda;

    @GetMapping("/nova")
    public String nova() {
        return "venda/CadastroVenda";
    }


    @PostMapping("/item")
    public ModelAndView adicionarItem(Long codigoCerveja) {
        Cerveja cerveja = cervejas.findOne(codigoCerveja);
        tabelaItensVenda.adicionarItem(cerveja, 1);

        return mvTabelaItensVenda();
    }

    @PutMapping("/item/{codigoCerveja}")
    public ModelAndView alterarQuantidadeItem(@PathVariable("codigoCerveja") Cerveja cerveja, Integer quantidade) {

        tabelaItensVenda.alterarQuantidadeItens(cerveja, quantidade);
        return mvTabelaItensVenda();
    }

    @DeleteMapping("/item/{codigoCerveja}")
    public ModelAndView excluirItem(@PathVariable("codigoCerveja") Cerveja cerveja) {

        tabelaItensVenda.excluirItem(cerveja);
        return mvTabelaItensVenda();
    }

    private ModelAndView mvTabelaItensVenda() {
        ModelAndView mv = new ModelAndView("venda/TabelaItensVenda");
        mv.addObject("itens", tabelaItensVenda.getItens());
        return mv;
    }

}
