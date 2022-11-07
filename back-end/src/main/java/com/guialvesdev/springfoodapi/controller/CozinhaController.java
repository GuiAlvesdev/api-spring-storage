package com.guialvesdev.springfoodapi.controller;

import com.guialvesdev.springfoodapi.domain.Cozinha;
import com.guialvesdev.springfoodapi.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {



    @Autowired
    private CozinhaRepository cozinhaRepository;




    @GetMapping
    public List<Cozinha> listar(){
        return cozinhaRepository.listar();


    }







}
