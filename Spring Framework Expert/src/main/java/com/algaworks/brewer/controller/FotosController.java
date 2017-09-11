package com.algaworks.brewer.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FotosController {

    @PostMapping("/fotos")
    public String upload(@RequestParam("files[]") MultipartFile[] files){
        System.out.println(">>>>>> Files: " + files[0].getSize());
        return "OK!";
    }
}
