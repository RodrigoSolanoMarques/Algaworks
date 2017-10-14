package com.algaworks.brewer.controller;

import com.algaworks.brewer.controller.page.PageWrapper;
import com.algaworks.brewer.model.Cidade;
import com.algaworks.brewer.repository.Cidades;
import com.algaworks.brewer.repository.Estados;
import com.algaworks.brewer.repository.filter.CidadeFilter;
import com.algaworks.brewer.service.CadastroCidadeService;
import com.algaworks.brewer.service.exception.NomeCidadeJaCadastradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/cidades")
public class CidadesController {

    @Autowired
    private Cidades cidades;

    @Autowired
    private Estados estados;

    @Autowired
    private CadastroCidadeService cadastroCidadeService;

    @RequestMapping("/nova")
    public ModelAndView novo(Cidade cidade) {

        ModelAndView mv = new ModelAndView("cidade/CadastroCidade");
        mv.addObject("estados", estados.findAll());
        return mv;
    }

    @PostMapping("nova")
    public ModelAndView salvar(@Valid Cidade cidade, BindingResult result, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            return novo(cidade);
        }

        try {
            cadastroCidadeService.salvar(cidade);
        } catch (NomeCidadeJaCadastradoException e) {
            result.rejectValue("nome", e.getMessage(), e.getMessage());
            return novo(cidade);
        }

        attributes.addFlashAttribute("mensagem", "Cidade salva com sucesso!");
        return new ModelAndView("redirect:/cidades/nova");
    }

    @GetMapping
    public ModelAndView pesquisar(CidadeFilter cidadeFilter, BindingResult result, @PageableDefault(value = 2)Pageable pageable, HttpServletRequest httpServletRequest){

        ModelAndView mv = new ModelAndView("cidade/PesquisaCidade");
        PageWrapper<Cidade> paginaWrapper = new PageWrapper<>(cidades.filtrar(cidadeFilter, pageable), httpServletRequest);
        mv.addObject("estados", estados.findAll());
        mv.addObject("pagina", paginaWrapper);

        return mv;
    }


    @RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<Cidade> pesquisrPorCodigoEstado(@RequestParam(name = "estado", defaultValue = "-1") Long codigoEstado) {

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return cidades.findByEstadoCodigo(codigoEstado);
    }

}
