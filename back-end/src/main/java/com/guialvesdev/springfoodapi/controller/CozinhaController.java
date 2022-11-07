package com.guialvesdev.springfoodapi.controller;

import com.guialvesdev.springfoodapi.domain.Cozinha;
import com.guialvesdev.springfoodapi.repository.CozinhaRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{cozinhaId}")
    public ResponseEntity<Cozinha> buscar(@PathVariable Long cozinhaId){
        Cozinha cozinha = cozinhaRepository.buscar(cozinhaId);

       if (cozinha != null){
           return ResponseEntity.ok(cozinha);

       }
       return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       return ResponseEntity.notFound().build();

    }







}
