package com.algaworks.brewer.controller;

import com.algaworks.brewer.model.Estilo;
import com.algaworks.brewer.service.CadastroEstiloService;
import com.algaworks.brewer.service.exception.NomeEstiloJaCadastradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
@RequestMapping("/estilos")
public class EstilosController {

    @Autowired
    private CadastroEstiloService cadastroEstiloService;

    @RequestMapping("/novo")
    private ModelAndView novo(Estilo estilo) {
        return new ModelAndView("estilo/CadastroEstilo");
    }

    @RequestMapping(value = "/novo", method = RequestMethod.POST)
    private ModelAndView cadastrar(@Valid Estilo estilo, BindingResult result, Model model, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            return novo(estilo);
        }

        try {
            cadastroEstiloService.salvar(estilo);
        } catch (NomeEstiloJaCadastradoException e) {
            result.rejectValue("nome", e.getMessage(), e.getMessage());
            return novo(estilo);
        }
        attributes.addFlashAttribute("mensagem", "Estilo salvo com sucesso!");
        return new ModelAndView("redirect:/estilos/novo");
    }

    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    ResponseEntity<?> salvar(@RequestBody @Valid Estilo estilo, BindingResult result) {

        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getFieldError("nome").getDefaultMessage());
        }

        estilo = cadastroEstiloService.salvar(estilo);

        return ResponseEntity.ok(estilo);

    }

}