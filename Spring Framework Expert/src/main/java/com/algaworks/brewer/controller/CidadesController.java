package com.algaworks.brewer.controller;

import com.algaworks.brewer.model.Cidade;
import com.algaworks.brewer.repository.Cidades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/cidades")
public class CidadesController {

    @Autowired
    private Cidades cidades;

    @RequestMapping("/novo")
    public String novo() {
        return "cidade/CadastroCidade";
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
