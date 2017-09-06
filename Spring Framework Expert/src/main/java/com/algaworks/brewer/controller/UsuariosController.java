package com.algaworks.brewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsuariosController {


    @RequestMapping("/usuario/novo")
    private String novo(){
        return "usuario/CadastroUsuario";
    }
}
