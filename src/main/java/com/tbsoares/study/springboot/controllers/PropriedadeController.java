package com.tbsoares.study.springboot.controllers;

import com.tbsoares.study.springboot.models.Propriedade;
import com.tbsoares.study.springboot.repositories.PropriedadeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PropriedadeController {

    private PropriedadeRepository propriedadeRepository;

    public PropriedadeController(PropriedadeRepository propriedadeRepository) {
        this.propriedadeRepository = propriedadeRepository;
    }

    @GetMapping("/find/{filtro}")
    public List<Propriedade> findByFiltro(@PathVariable("filtro") String filtro){
       return propriedadeRepository.findByFiltro(filtro);
    }
}
