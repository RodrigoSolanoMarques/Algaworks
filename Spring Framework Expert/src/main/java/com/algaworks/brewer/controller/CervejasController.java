package com.algaworks.brewer.controller;

import com.algaworks.brewer.model.Cerveja;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class CervejasController {

    @RequestMapping("/cervejas/novo")
    public String novo(){
        return "cerveja/CadastroCerveja";
    }

    @RequestMapping(value = "/cervejas/novo", method = RequestMethod.POST)
    public String cadastrar(@Valid Cerveja cerveja, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            System.out.println(">>>>> Tem erro sim!");
        }

        System.out.println(cerveja.getSku());
        System.out.println(cerveja.getNome());
        return "cerveja/CadastroCerveja";
    }

}
