package com.guialvesdev.springfoodapi.controller;

import com.guialvesdev.springfoodapi.domain.exception.EntidadeEmUsoException;
import com.guialvesdev.springfoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.guialvesdev.springfoodapi.domain.model.Cozinha;
import com.guialvesdev.springfoodapi.domain.service.CadastroCozinhaService;
import com.guialvesdev.springfoodapi.repository.CozinhaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {



    @Autowired
    private CozinhaRepository cozinhaRepository;

    @Autowired
    private CadastroCozinhaService cadastroCozinha;




    @GetMapping
    public List<Cozinha> listar() {
        return cozinhaRepository.findAll();
    }


    @GetMapping("/{cozinhaId}")
    public Cozinha buscar(@PathVariable Long cozinhaId) {
       return cadastroCozinha.buscarOuFalhar(cozinhaId);


    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cozinha adicionar(@RequestBody Cozinha cozinha) {
        return cadastroCozinha.salvar(cozinha);
    }



    @PutMapping("/{cozinhaId}")
    public Cozinha atualizar(@PathVariable Long cozinhaId, @RequestBody Cozinha cozinha) {
        Cozinha cozinhaAtual = cadastroCozinha.buscarOuFalhar(cozinhaId);

            BeanUtils.copyProperties(cozinha, cozinhaAtual, "id");
            return cadastroCozinha.salvar(cozinhaAtual);
        }




    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{cozinhaId}")
    public void remover(@PathVariable Long cozinhaId) {
       cadastroCozinha.excluir(cozinhaId);
    }




}
