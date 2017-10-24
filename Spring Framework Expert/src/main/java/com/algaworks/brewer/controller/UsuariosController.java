package com.algaworks.brewer.controller;

import com.algaworks.brewer.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {


    @GetMapping("/novo")
    private ModelAndView novo(Usuario usuario){
        return new ModelAndView("usuario/CadastroUsuario");
    }

    @PostMapping("/novo")
    public ModelAndView cadastrar(@Valid Usuario usuario, BindingResult result, Model model, RedirectAttributes attributes){

        if(result.hasErrors()){
            return novo(usuario);
        }

        attributes.addFlashAttribute("mensagem", "Cerveja salva com sucesso!");
        return new ModelAndView("redirect:/usuarios/novo");
    }
}
